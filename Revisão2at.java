package Objetos;

    public class Produto {
        private String nome;
        private double preco;
        private int QuantEstoque;


        // Métodos para acessar os atributos
        public String getNome() {
            return nome;
        }

        public double getPreco() {
            return preco;
        }

        public int getQuantidadeEmEstoque() {
            return QuantEstoque;
        }

        // Métodos para modificar os atributos
        public void setNome(String nome) {
            this.nome = nome;
        }

        public void setPreco(double preco) {
            this.preco = preco;
        }

        public void setQuantEstoque(int QuantEstoque) {
            this.QuantEstoque = QuantEstoque;
        }

        // Método para exibir informações do produto
        public void exibirInformacoes() {
            System.out.println("Nome: " + nome);
            System.out.println("Preço: R$" + preco);
            System.out.println("Quantidade em estoque: " + QuantEstoque);
        }

        // Adicionar quantidade ao estoque
        public void adicionarQuantidadeEstoque(int quantidade) {
            QuantEstoque += quantidade;
        }

        // Remover quantidade do estoque
        public void removerQuantidadeEstoque(int quantidade) {
            if (QuantEstoque >= quantidade) {
                QuantEstoque -= quantidade;
            } else {
                System.out.println("Quantidade insuficiente em estoque.");
            }
        }
}

package Main;

import br.unipar.objetos.Produto;

public class Main {
    public static void main(String[] args) {

        Produto produto1 = new Produto();
        Produto produto2 = new Produto();

        produto1.setNome("Computador");
        produto1.setPreco(2500.55);
        produto1.setQuantEstoque(50);

        produto2.setNome("Celular");
        produto2.setPreco(5999.99);
        produto2.setQuantEstoque(30);

        System.out.println(" ");
        System.out.println("Produto 1:");
        produto1.exibirInformacoes();

        System.out.println(" ");
        produto2.exibirInformacoes();

        // MODIFICANDO PRODUTOS

        // PRODUTO 1
        produto1.setPreco(4500.00);
        produto1.adicionarQuantidadeEstoque(20);

        // PRODUTO 2
        produto2.setNome("Celular");
        produto2.removerQuantidadeEstoque(10);
        produto2.setPreco(1599.99);

        // EXIBINDO PRODUTOS MODIFICADOS

        System.out.println(" ");
        System.out.println("Produto 1 (Após modificações): ");
        produto1.exibirInformacoes();

        System.out.println(" ");
        System.out.println("Produto 2 (Após modificações): ");
        produto2.exibirInformacoes();
    }
}
