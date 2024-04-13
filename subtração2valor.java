import java.util.Scanner;

class Subtracao2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        
        int num1, num2, sub;
        
        System.out.println("Subtracao de numeros: ");
        System.out.println("Informe o primeiro numero: ");
        num1 = scanner.nextInt();
        System.out.println("Informe o segundo numero: ");
        num2 = scanner.nextInt();

        sub = (num1 - num2);

        System.out.println("A subtracao dos seus numeros sao: " + sub);
        
    }
}
