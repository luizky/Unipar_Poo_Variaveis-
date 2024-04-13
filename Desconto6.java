import java.util.Scanner;

class Produto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        
        Double precoP, percP, totalP;
        String nomeP;
        
        System.out.println("Pproduto: ");
        System.out.println("Informe o nome do produto: ");
        nomeP = scanner.nextLine();
        System.out.println("Informe o preco do produto: ");
        precoP = scanner.nextDouble();
        System.out.println("Informe o percentual de desconto: ");
        percP = scanner.nextDouble();
        
        totalP = precoP - (precoP * percP /100);
        
        System.out.println("O novo preco do produto: " + nomeP + " ,eh: " + totalP);
        
    }
}
