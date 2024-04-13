package Objeto;

public class Produto {

    private final String nome;
    private final double preco;
    private final int quantEstoque;

    public Produto(String nome){
        this.nome = nome;
        this.preco = 0.0;
        this.quantEstoque = 0;
    }

    public Produto(String nome, double preco){
        this.nome = nome;
        this.preco = preco;
        this.quantEstoque = 0;
    }

    public Produto(String nome, double preco, int quantEstoque){
        this.nome = nome;
        this.preco = preco;
        this.quantEstoque = quantEstoque;
    }

    public String getNome(){
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantEstoque() {
        return quantEstoque;
    }

}

package Main;
import br.unipar.objetos.Produto;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criação de objeto (Produto) com o 1º construtor;
        Produto produto1 = new Produto("Produto A");
        System.out.println("Produto 1:");
        System.out.println("Nome: " + produto1.getNome());
        System.out.println("Preço: " + produto1.getPreco());
        System.out.println("Quantidade em estoque: " + produto1.getQuantEstoque());
        System.out.println(" ");

        // Criação de objeto (Produto) com o 2º construtor;

        System.out.print("Digite o nome do Produto B: ");
        String nomeProdutoB = scanner.nextLine();
        System.out.print("Digite o preço do Produto B: ");
        double precoProdutoB = scanner.nextDouble();
        Produto produto2 = new Produto(nomeProdutoB, precoProdutoB);
        System.out.println();
        System.out.println("Produto 2:");
        System.out.println("Nome: " + produto2.getNome());
        System.out.println("Preço: " + produto2.getPreco());
        System.out.println("Quantidade em estoque: " + produto2.getQuantEstoque());
        System.out.println();

        // Criação de obejto (Produto) com o 3º construtor;

        System.out.print("Digite o nome do Produto C: ");
        scanner.nextLine();
        String nomeProdutoC = scanner.next();
        System.out.print("Digite o preço do Produto C: ");
        double precoProdutoC = scanner.nextDouble();
        System.out.print("Digite a quantidade de estoque do Produto C: ");
        int estoqueProdutoC = scanner.nextInt();
        Produto produto3 = new Produto(nomeProdutoC, precoProdutoC, estoqueProdutoC);
        System.out.println();
        System.out.println("Produto 3:");
        System.out.println("Nome: " + produto3.getNome());
        System.out.println("Preço: " + produto3.getPreco());
        System.out.println("Quantidade em estoque: " + produto3.getQuantEstoque());

        scanner.close();
    }
}
