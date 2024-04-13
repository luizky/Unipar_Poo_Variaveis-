import java.util.Scanner;
class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String usuario, senha, usuario2, senha2;

        System.out.println("Faca login: ");
        System.out.println("Usuario: ");
        usuario = scanner.nextLine();
        usuario2 = "usuario";
        
        System.out.println("Senha: ");
        senha = scanner.nextLine();
        senha2 = "senha123";
        
        if(usuario.equals(usuario2)){
            System.out.println("Usuario Correto!");
        } else {
            
            System.out.println("Usuario Errado!");
        }
        
        if (senha.equals(senha2)){
            System.out.println("Senha correta!");
        } else {
            System.out.println("Senha Incorreta!");
        }


        scanner.close();

    }
}
