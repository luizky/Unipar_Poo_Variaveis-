package br.unipar;

import java.sql.*;
import java.util.Scanner;

public class Main {

    private static final String url = "jdbc:postgresql://localhost:5432/Exemplo1";
    private static final String usuario = "postgres";
    private static final String senha = "admin123";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        criarTabelaUsuario();

        while (true) {
            System.out.println("Escolha uma operação: [1] Inserir, [2] Listar, [3] Atualizar, [4] Excluir, [5] Sair");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    inserirUsuarioHandler(scanner);
                    break;
                case 2:
                    listarTodosUsuarios();
                    break;
                case 3:
                    atualizarUsuarioHandler(scanner);
                    break;
                case 4:
                    excluirUsuarioHandler(scanner);
                    break;
                case 5:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Escolha inválida!");
            }
        }
    }

    private static void inserirUsuarioHandler(Scanner scanner) {
        System.out.println("Insira username:");
        String username = scanner.nextLine();
        System.out.println("Insira password:");
        String password = scanner.nextLine();
        System.out.println("Insira nome:");
        String nome = scanner.nextLine();
        System.out.println("Insira data de nascimento:");
        String nascimento = scanner.nextLine();
        inserirUsuario(username, password, nome, nascimento);
    }

    private static void atualizarUsuarioHandler(Scanner scanner) {
        System.out.println("Insira o código do usuário a ser atualizado:");
        int codigoAtualizar = scanner.nextInt();
        scanner.nextLine();  // Consumir o caractere de nova linha
        System.out.println("Insira novo username:");
        String novoUsername = scanner.nextLine();
        System.out.println("Insira novo password:");
        String novoPassword = scanner.nextLine();
        System.out.println("Insira novo nome:");
        String novoNome = scanner.nextLine();
        System.out.println("Insira nova data de nascimento:");
        String novoNascimento = scanner.nextLine();
        atualizarUsuario(codigoAtualizar, novoUsername, novoPassword, novoNome, novoNascimento);
    }

    private static void excluirUsuarioHandler(Scanner scanner) {
        System.out.println("Insira o código do usuário a ser excluído:");
        int codigoExcluir = scanner.nextInt();
        excluirUsuario(codigoExcluir);
    }

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(url, usuario, senha);
    }

    public static void criarTabelaUsuario() {
        String sql = "CREATE TABLE IF NOT EXISTS usuarios ( " +
                "codigo SERIAL PRIMARY KEY, " +
                "username VARCHAR(50) UNIQUE NOT NULL, " +
                "password VARCHAR(300) NOT NULL, " +
                "nome VARCHAR(50) NOT NULL, " +
                "nascimento DATE)";
        try (Connection conn = conectar(); Statement statement = conn.createStatement()) {
            statement.execute(sql);
            System.out.println("Tabela criada");
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static void inserirUsuario(String username, String password, String nome, String dataNascimento) {
        String sql = "INSERT INTO usuarios (username, password, nome, nascimento) VALUES (?, ?, ?, ?)";
        try (Connection conn = conectar(); PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, nome);
            preparedStatement.setDate(4, Date.valueOf(dataNascimento));
            preparedStatement.executeUpdate();
            System.out.println("Usuário inserido!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void listarTodosUsuarios() {
        String sql = "SELECT * FROM usuarios";
        try (Connection conn = conectar(); Statement statement = conn.createStatement(); ResultSet result = statement.executeQuery(sql)) {
            while (result.next()) {
                System.out.println("Código: " + result.getInt("codigo"));
                System.out.println("Username: " + result.getString("username"));
                System.out.println("Nome: " + result.getString("nome"));
                System.out.println("Nascimento: " + result.getDate("nascimento"));
                System.out.println("----------------------");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void atualizarUsuario(int codigo, String username, String password, String nome, String dataNascimento) {
        String sql = "UPDATE usuarios SET username = ?, password = ?, nome = ?, nascimento = ? WHERE codigo = ?";
        try (Connection conn = conectar(); PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, nome);
            preparedStatement.setDate(4, Date.valueOf(dataNascimento));
            preparedStatement.setInt(5, codigo);
            preparedStatement.executeUpdate();
            System.out.println("Usuário atualizado!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void excluirUsuario(int codigo) {
        String sql = "DELETE FROM usuarios WHERE codigo = ?";
        try (Connection conn = conectar(); PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();
            System.out.println("Usuário excluído!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


-------------------------------

import org.junit.jupiter.api.*;
import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

public class Teste {

    @BeforeAll
    public static void setup() {
        Principal.criarTabelaUsuario();
    }

    @Test
    public void testInserirUsuario() {
        Principal.inserirUsuario("testuser", "testpass", "Test User", "2000-01-01");
        try (Connection conn = Principal.conectar(); Statement statement = conn.createStatement(); ResultSet resultSet = statement.executeQuery("SELECT * FROM usuarios WHERE username = 'testuser'")) {
            assertTrue(resultSet.next());
            assertEquals("testuser", resultSet.getString("username"));
        } catch (SQLException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testAtualizarUsuario() {
        Principal.inserirUsuario("updatetest", "pass", "Update Test", "1990-01-01");

        int userId = getUserIdByUsername("updatetest");
        Principal.atualizarUsuario(userId, "updateduser", "newpass", "Updated Name", "1985-05-05");

        try (Connection conn = Principal.conectar(); Statement statement = conn.createStatement(); ResultSet resultSet = statement.executeQuery("SELECT * FROM usuarios WHERE username = 'updateduser'")) {
            assertTrue(resultSet.next());
            assertEquals("updateduser", resultSet.getString("username"));
            assertEquals("Updated Name", resultSet.getString("nome"));
        } catch (SQLException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testExcluirUsuario() {
        Principal.inserirUsuario("deletetest", "pass", "Delete Test", "1990-01-01");

        int userId = getUserIdByUsername("deletetest");
        Principal.excluirUsuario(userId);

        try (Connection conn = Principal.conectar(); Statement statement = conn.createStatement(); ResultSet resultSet = statement.executeQuery("SELECT * FROM usuarios WHERE username = 'deletetest'")) {
            assertFalse(resultSet.next());
        } catch (SQLException e) {
            fail(e.getMessage());
        }
    }

    private int getUserIdByUsername(String username) {
        try (Connection conn = Principal.conectar(); PreparedStatement ps = conn.prepareStatement("SELECT codigo FROM usuarios WHERE username = ?")) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("codigo");
            } else {
                throw new RuntimeException("Usuário não encontrado: " + username);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
