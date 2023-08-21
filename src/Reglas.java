import java.util.Scanner;

public class Reglas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int celula = 0;
        System.out.println("numero de celulas");

        celula = scanner.nextInt();

        if (celula == 1) {
            System.out.println(0);
        } else if (celula == 2) {
            System.out.println(0);
        } else if (celula == 4) {
            System.out.println(1);
        } else if (celula == 3) {
            System.out.println(1);
        } else {
            System.out.println("num no valido");
        }


    }
}
