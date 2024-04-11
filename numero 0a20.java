import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero = 0;

        for (int n = 1; n <= 20; n++) {
            System.out.println("Escreva numero");
            numero = scanner.nextInt();


            if (numero >= 0 && numero <= 100) {
                System.out.println("Este numero" + numero + "está entre 0 e 100 ");
            } else if (numero >= 101 && numero <= 200) {
                System.out.println("Este numero " + numero + " está entre 101 e 200");

            } else {
                System.out.println("O numero está acima de 201");

            }
        }

    }

}
