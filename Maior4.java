import java.util.Scanner;
class NumerosMaiores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int x,y;
        
        System.out.println("Informe o primeiro numero: ");
        x = scanner.nextInt();
        
        System.out.println("Informe o segundo numero: ");
        y = scanner.nextInt();
        
        if (x == y) {
            System.out.println("Os numeros sao iguais!");
        } else if (x > y) {
            System.out.println("O numero " + x + " e MAIOR que " + y + "!" );
        } else {
            System.out.println("O numero " + x + " e MENOR que " + y + "!" );
        } 

        scanner.close();

    }
}
