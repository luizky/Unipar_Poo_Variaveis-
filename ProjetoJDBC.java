package br.unipar;

import java.sql.*;

public class Main {

    private static final String url = "jdbc:postgresql://localhost:5432/Exemplo1";
    private static final String user = "postgres";
    private static final String password = "admin123";

    public static void main(String[] args) {
        criarTabelaUsuario();
        inserirUsuario("Taffe", "123456","Fabio","1899-01-01");
    }

    public static Connection connection() throws SQLException {

        //localhost -> Onde esta o banco
        //5432 -> Porta padão do banco

        return DriverManager.getConnection(url, user, password);

    }

    public static void criarTabelaUsuario(){
        try {
            Connection conn = connection();

            Statement statement = conn.createStatement();
            String sql = " CREATE TABLE IF NOT EXISTS usuarios ( " + " codigo SERIAL PRIMARY KEY,"
                       + "username varchar(50) UNIQUE NOT NULL,"
                       + "password varchar(300) NOT NULL,"
                       + "nome VARCHAR(50) NOT NULL,"
                       + "nascimento DATE )";

            statement.execute(sql);

            System.out.println("TABELA CRIADA");

        }catch (SQLException exception) {
            exception.printStackTrace();
        }

    }
//prepara a execução de umsql
    public static  void inserirUsuario(String username, String password,
                                       String nome, String dataNascimento){
        try {
            Connection conn = connection();

            PreparedStatement preparedStatement = conn.prepareStatement(
            ("Insert into usuarios (username, password, nome, nascimento )")
             + " values (?,?,?,?)");

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, nome);
            preparedStatement.setDate(4, java.sql.Date.valueOf(dataNascimento));

            preparedStatement.executeUpdate();

            System.out.println("usuario inserido !");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
