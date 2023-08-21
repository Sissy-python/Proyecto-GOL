import java.util.Scanner;

public class Tablero {
    private Reglas reglas;

    public Tablero(Reglas reglas) {
        this.reglas = reglas;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el tamaño del tablero (Ancho x Alto): ");
        int ancho = scanner.nextInt();
        int alto = scanner.nextInt();

        boolean[][] generacionActual = new boolean[alto][ancho];
        boolean[][] siguienteGeneracion;

        // Inicialización del tablero
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                generacionActual[i][j] = Math.random() < 0.5;
            }
        }

        System.out.println("Ingrese el número de generaciones: ");
        int numGeneraciones = scanner.nextInt();

        System.out.println("Ingrese el intervalo de tiempo en milisegundos: ");
        int intervalo = scanner.nextInt();

        for (int generacion = 0; generacion < numGeneraciones || numGeneraciones == 0; generacion++) {
            limpiarConsola();
            System.out.println("Generación: " + generacion);
            mostrarGeneracion(generacionActual);

            try {
                Thread.sleep(intervalo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            siguienteGeneracion = Reglas.aplicarReglas(generacionActual);
            generacionActual = siguienteGeneracion;
        }

        scanner.close();
    }

    public static void limpiarConsola() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void mostrarGeneracion(boolean[][] generacion) {
        for (int i = 0; i < generacion.length; i++) {
            for (int j = 0; j < generacion[i].length; j++) {
                System.out.print(generacion[i][j] ? "■ " : "□ ");
            }
            System.out.println();
        }
    }
}
