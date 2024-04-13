import java.util.Scanner;

class MediaNotas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        
        Double nota1, nota2, nota3, nota4, media;
        
        System.out.println("Divisao de numeros: ");
        System.out.println("Informe a primeira nota: ");
        nota1 = scanner.nextDouble();
        System.out.println("Informe a segunda nota: ");
        nota2 = scanner.nextDouble();
        System.out.println("Informe a terceira nota: ");
        nota3 = scanner.nextDouble();
        System.out.println("Informe a quarta nota: ");
        nota4 = scanner.nextDouble();

        media = (nota1 + nota2 + nota3 + nota4) /4;

        System.out.println("A divisao dos seus numeros sao: " + media);
        
    }
}
