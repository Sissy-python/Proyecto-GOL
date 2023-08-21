import java.util.Scanner;

public class Celulas {
    public static int[][] Celula(String sucecion) {
        Scanner scanner = new Scanner(System.in);
        //int f = 3;
        //int c = 3;
        System.out.println("escoge el tamaño de tu matriz: ");
        //f = scanner.nextInt();
        //c = scanner.nextInt();
        int v = 1;
        int m = 0;

        // n codigo
        String[] cambios = sucecion.split("#");
        int f = cambios.length;
        int c = cambios[0].length();
        int[][] matriz = new int[f][c];

        for (int i = 0; i < f; i++) {
            String cambio = cambios[i];
            for (int j = 0; j < c; j++) {
                char caracter = cambio.charAt(j);
                if (caracter == 'x') {
                    matriz[i][j] = 1;
                } else if (caracter == 'y') {
                    matriz[i][j] = 0;
                } //else if (caracter == 'z') {
                   // matriz[i][j] = 0;
                //}
            }
        }
        return matriz;
    }

    public static void main(String[] args) {
        String sucecion = "xxx#xyy#xyy";
        int[][] resultadoMatriz = Celula(sucecion);

        for (int i = 0; i < resultadoMatriz.length; i++) {
            for (int j = 0; j < resultadoMatriz[i].length; j++) {
                System.out.print(resultadoMatriz[i][j]);
            }
            System.out.println();
        }
    }
}