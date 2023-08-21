import java.util.Scanner;

public class Tablero {
    private static Reglas reglas;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Eligue el ancho de tu tablero:");
        System.out.println("1. 10");
        System.out.println("2. 20");
        System.out.println("3. 40");
        System.out.println("4. 80");
        int opcionAncho = scanner.nextInt();

        int ancho = 0;
        switch (opcionAncho) {
            case 1:
                ancho = 10;
                break;
            case 2:
                ancho = 20;
                break;
            case 3:
                ancho = 40;
                break;
            case 4:
                ancho = 80;
                break;
            default:
                System.out.println("No es un numero valido, por defecto sera: 20");
                ancho = 20;
        }

        System.out.println("Ahora eligue la altua de tu tablero:");
        System.out.println("1. 10");
        System.out.println("2. 20");
        System.out.println("3. 40");
        int opcionAlto = scanner.nextInt();

        int alto = 0;
        switch (opcionAlto) {
            case 1:
                alto = 10;
                break;
            case 2:
                alto = 20;
                break;
            case 3:
                alto = 40;
                break;
            default:
                System.out.println("Numero no valido, por defecto sera: 20");
                alto = 20;
        }

        boolean[][] generacionActual = new boolean[alto][ancho];

        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                generacionActual[i][j] = Math.random() < 0.5;
            }
        }

        System.out.println("Eligue el numero de generacines: ");
        int numGeneraciones = scanner.nextInt();

        int intervalo = 0;
        do {
            System.out.println("ELigue la velocidad a la que quieres que vaya:");
            System.out.println("1. 250");
            System.out.println("2. 1000");
            int opcionIntervalo = scanner.nextInt();

            switch (opcionIntervalo) {
                case 1:
                    intervalo = 250;
                    break;
                case 2:
                    intervalo = 1000;
                    break;
                default:
                    System.out.println("Tu numero no es correcto, por facor eligue entre 1 y 2");
            }
        } while (intervalo == 0);

        for (int generacion = 0; generacion < numGeneraciones || numGeneraciones == 0; generacion++) {
            limpiarConsola();
            System.out.println("Generación: " + generacion);
            mostrarGeneracion(generacionActual);

            try {
                Thread.sleep(intervalo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            generacionActual = Reglas.aplicarReglas(generacionActual);
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

