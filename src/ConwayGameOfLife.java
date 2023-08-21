import java.util.Scanner;

public class ConwayGameOfLife {
    private Reglas reglas;

    public ConwayGameOfLife(Reglas reglas) {
        this.reglas = reglas;
    }

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el tamaño del tablero (Ancho x Alto): ");
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        boolean[][] currentGeneration = new boolean[height][width];
        boolean[][] nextGeneration;

        // Inicialización del tablero
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                currentGeneration[i][j] = Math.random() < 0.5;
            }
        }

        System.out.println("Ingrese el número de generaciones: ");
        int numGenerations = scanner.nextInt();

        System.out.println("Ingrese el intervalo de tiempo en milisegundos: ");
        int interval = scanner.nextInt();

        for (int generation = 0; generation < numGenerations || numGenerations == 0; generation++) {
            clearConsole();
            System.out.println("Generación: " + generation);
            displayGeneration(currentGeneration);

            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            nextGeneration = Reglas.aplicarReglas(currentGeneration);
            currentGeneration = nextGeneration;
        }

        scanner.close();
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void displayGeneration(boolean[][] generation) {
        for (int i = 0; i < generation.length; i++) {
            for (int j = 0; j < generation[i].length; j++) {
                System.out.print(generation[i][j] ? "■ " : "□ ");
            }
            System.out.println();
        }
    }
}
