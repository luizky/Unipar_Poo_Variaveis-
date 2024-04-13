import java.util.Scanner;

class ImparePar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int numero;
        
        System.out.println("Informe um numero: ");
        numero = scanner.nextInt();
        
        if (numero % 2 == 0) {
            System.out.println("O numero " + numero + " e PAR!");
        } else {
            System.out.println("O numero " + numero + " e IMPAR!");
        }
    scanner.close();

    }
}
