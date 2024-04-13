package Objeto;

public class Produto {

    private String nome;
    private double preco;
    private int QuantEstoque;

    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    public void setQuantEstoque(int quantEstoque) {
        QuantEstoque = quantEstoque;
    }

    public int getQuantEstoque() {
        return QuantEstoque;
    }



}

package Main;

import br.unipar.Loja.Produto;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Produto> estoque = new ArrayList<>();

        // Variáveis
        char continuar;

        do {
            System.out.println("Estoque de loja:");
            System.out.println("1 - Adicionar Produto");
            System.out.println("2 - Modificar Produto");
            System.out.println("3 - Consulta de Produto");
            System.out.println(" ");
            System.out.print("Digite sua opção: ");
            int opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.print("Digite o nome do produto: ");
                String nome = scanner.next();
                System.out.print("Digite o preço do produto: ");
                double preco = scanner.nextDouble();
                System.out.print("Digite a quantidade em estoque do produto: ");
                int quantEstoque = scanner.nextInt();
                Produto novoProduto = new Produto();
                novoProduto.setNome(nome);
                novoProduto.setPreco(preco);
                novoProduto.setQuantEstoque(quantEstoque);
                estoque.add(novoProduto);
                System.out.println(" ");
                System.out.println("Produto adicionado com sucesso!");
                System.out.println(" ");
            }
            if (opcao == 2) {
                System.out.print("Digite o nome do produto que deseja modificar: ");
                scanner.nextLine();
                String nome = scanner.nextLine();
                System.out.print("Digite 'preco' para mudar o preço ou 'quantidade' para mudar " +
                        "a quantidade: ");
                String opcaoModificar = scanner.nextLine();
                boolean produtoEncontrado = false;
                for (Produto produto : estoque) {
                    if (produto.getNome().equalsIgnoreCase(nome)) {
                        if (opcaoModificar.equalsIgnoreCase("preco")) {
                            System.out.print("Digite o novo preço do produto: ");
                            double novoPreco = scanner.nextDouble();
                            produto.setPreco(novoPreco);
                        } else if (opcaoModificar.equalsIgnoreCase("quantidade")) {
                            System.out.print("Digite a nova quantidade em estoque: ");
                            int novaQuantidade = scanner.nextInt();
                            produto.setQuantEstoque(novaQuantidade);
                        }
                        System.out.println("Produto modificado com sucesso!");
                        break;
                    }
                }
            }
                if (opcao == 3) {
                    System.out.print("Digite o nome do produto que deseja consultar: ");
                    scanner.nextLine();
                    String nomeConsulta = scanner.nextLine();
                    for (Produto produto : estoque) {
                        if (produto.getNome().equalsIgnoreCase(nomeConsulta)) {
                            System.out.println("Nome: " + produto.getNome());
                            System.out.println("Preço: " + produto.getPreco());
                            System.out.println("Quantidade em estoque: " + produto.getQuantEstoque());
                            break;
                        }

                    }
                }
                System.out.println(" ");
                System.out.println("Deseja continuar? s/n");
                continuar = scanner.next().charAt(0);
            }
            while (continuar == 's' || continuar == 'S') ;
            System.out.println(" ");
            System.out.println(" ---------------------");
            System.out.println("| PROGRAMA ENCERRADO  |");
            System.out.println(" ---------------------");
        }
    }
