import java.util.Scanner;

class Soma3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        
        int num1, num2, num3, soma;
        
        System.out.println("Soma de numeros: ");
        System.out.println("Informe o primeiro numero: ");
        num1 = scanner.nextInt();
        System.out.println("Informe o segundo numero: ");
        num2 = scanner.nextInt();
        System.out.println("Informe o terceiro numero: ");
        num3 = scanner.nextInt();
        
        soma = (num1 + num2 + num3);
        
        System.out.println("A soma dos seus numeros sao: " + soma);
        
    }
}
