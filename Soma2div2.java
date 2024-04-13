import java.util.Scanner;

class Divisao2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        
        int num1, num2, div;
        
        System.out.println("Divisao de numeros: ");
        System.out.println("Informe o primeiro numero: ");
        num1 = scanner.nextInt();
        System.out.println("Informe o segundo numero: ");
        num2 = scanner.nextInt();

        div = (num1 + num2) /2;

        System.out.println("A divisao dos seus numeros sao: " + div);
        
    }
}
