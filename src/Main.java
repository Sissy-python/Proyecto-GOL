import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int f = 0;
        int c = 0;

        System.out.println("escoge el tamaño de tu matriz: ");
        f = scanner.nextInt();
        c = scanner.nextInt();


        // Declarar la matriz después de leer el tamaño
        int[][] matriz = new int[f][c];
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                matriz[i][j] = 0;
            }
        }

        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

    }



}
