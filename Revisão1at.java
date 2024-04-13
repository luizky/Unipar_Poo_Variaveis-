package Objetos;

public class Carro {

    private String marca;
    private String modelo;
    private int ano;
    private String cor;

    public void setMarca(String marca){
        this.marca = marca;
    }

    public String getMarca(){
        return marca;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public String getModelo(){
        return modelo;
    }

    public void setAno(int ano){
        this.ano = ano;
    }

    public int getAno(){
        return ano;
    }

    public void setCor(String cor){
        this.cor = cor;
    }

    public String getCor(){
        return cor;
    }

    public void InformacoesCarro(){
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
        System.out.println("Cor: " + cor);
    }

}

package Main;

import Objetos.Carro;

public class Main {
    public static void main(String[] args) {

        Carro carro1 = new Carro();
        Carro carro2 = new Carro();

        System.out.println(" ");
        carro1.setMarca("Hyundai");
        carro1.setModelo("HB20");
        carro1.setAno(2016);
        carro1.setCor("Prata");

        carro2.setMarca("Honda");
        carro2.setModelo("CIVIC");
        carro2.setAno(2022);
        carro2.setCor("Branco");

        System.out.println("CARRO 1:");
        carro1.InformacoesCarro();
        System.out.println(" ");
        System.out.println("CARRO 2:");
        carro2.InformacoesCarro();

        // Modificando Atributos dos carros

        carro1.setMarca("Chevrolet");
        carro1.setModelo("Onix");
        carro1.setAno(2005);
        carro1.setCor("Azul");

        carro2.setMarca("Renault");
        carro2.setModelo("Kangoo");
        carro2.setAno(2008);
        carro2.setCor("Branco");

        System.out.println(" ");
        System.out.println("CARRO 1 (Após modificações):");
        carro1.InformacoesCarro();
        System.out.println(" ");
        System.out.println("CARRO 2 (Após modificações):");
        carro2.InformacoesCarro();

    }
}
