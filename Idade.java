import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
       Scanner scaner = new Scanner(System.in);

       int anos, meses, dias, total;

        System.out.println("Quantos anos tem?");
        anos = scaner.nextInt();

        System.out.println("Quantos meses?");
        meses = scaner.nextInt();

        System.out.println("Quantos dias?");
        dias = scaner.nextInt();

        total =((anos * 365 + meses * 30) + dias);
        System.out.println("O total da  soma de Anos, Meses, Dias é de " + total);

    }

}
