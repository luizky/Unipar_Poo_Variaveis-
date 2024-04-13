package Objeto;

public class Circulo {
    private double raio;
    private String cor;

    // Construtor da classe Circulo
    public Circulo(double raio, String cor) {
        this.raio = raio;
        this.cor = cor;
    }

    // Métodos para acessar e modificar o raio
    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    // Métodos para acessar e modificar a cor
    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    // Método para calcular a área do círculo
    public double calcularArea() {
        return Math.PI * raio * raio;
    }

    // Método para calcular o perímetro do círculo
    public double calcularPerimetro() {
        return 2 * Math.PI * raio;
    }
}

package Main;

import br.unipar.Objetos.Circulo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Digite o raio do círculo: ");
        double raio = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Digite a cor do círculo: ");
        String cor = scanner.nextLine();

        Circulo circulo = new Circulo(raio, cor);

        System.out.println("Características do círculo:");
        System.out.println("Raio: " + circulo.getRaio());
        System.out.println("Cor: " + circulo.getCor());
        System.out.println("Área: " + circulo.calcularArea());
        System.out.println("Perímetro: " + circulo.calcularPerimetro());

        scanner.close();
    }
}
