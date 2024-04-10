import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    int patinhos;
    int numerospatos;

        System.out.println("Quatos patinhos a pata tem?");
        numerospatos = scanner.nextInt();

        for (patinhos = numerospatos; patinhos >=1; patinhos--){
            System.out.println(patinhos + " Foram passear alem das montanhas para brincar, " +
                    "a mamãe gritou quá quá quá quá mas só " + (patinhos -1) + " voltaram de lá");

        }
        System.out.println();
        System.out.println("A mamãe pata foi atrás desses pelego e começou a gritar quá quá quá, " +
                "e os " +numerospatos+ " patinhos voltaram de lá");

    }

}
