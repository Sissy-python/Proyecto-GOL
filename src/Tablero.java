import java.util.Scanner;

public class Tablero {
    private static Reglas reglas;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Elige el ancho de tu tablero:");
        System.out.println("1. 10");
        System.out.println("2. 20");
        System.out.println("3. 40");
        System.out.println("4. 80");
        int opcionAncho = scanner.nextInt();

        int ancho = 0;
        if (opcionAncho == 1) {
            ancho = 10;
        } else if (opcionAncho == 2) {
            ancho = 20;
        } else if (opcionAncho == 3) {
            ancho = 40;
        } else if (opcionAncho == 4) {
            ancho = 80;
        } else {
            System.out.println("Opción inválida. El programa se detendrá.");
            System.exit(0);
        }

        System.out.println("Ahora elige la altura de tu tablero:");
        System.out.println("1. 10");
        System.out.println("2. 20");
        System.out.println("3. 40");
        int opcionAlto = scanner.nextInt();

        int alto = 0;
        if (opcionAlto == 1) {
            alto = 10;
        } else if (opcionAlto == 2) {
            alto = 20;
        } else if (opcionAlto == 3) {
            alto = 40;
        } else {
            System.out.println("Número no válido, el programa se detendrá.");
            System.exit(0);
        }

        boolean[][] generacionActual = new boolean[alto][ancho];

        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                generacionActual[i][j] = Math.random() < 0.5;
            }
        }

        System.out.println("Elige el número de generaciones:");
        int numGeneraciones = scanner.nextInt();

        int intervalo = 0;
        do {
            System.out.println("Elige la velocidad a la que quieres que vaya:");
            System.out.println("1. 250");
            System.out.println("2. 1000");
            System.out.println("3. 2000");
            int opcionIntervalo = scanner.nextInt();

            if (opcionIntervalo == 1) {
                intervalo = 250;
            } else if (opcionIntervalo == 2) {
                intervalo = 1000;
            } else if (opcionIntervalo == 3) {
                intervalo = 2000;
            } else {
                System.out.println("Tu número no es correcto, por favor elige entre 1 y 2 o 3.");
            }

        } while (intervalo == 0);

        System.out.println("Si quieres que una genercaion se intercambie introduce el num de la misma o 0 si no quieres que se habilite");
        int numIntercambio = scanner.nextInt();
        if (numIntercambio == 0) {
            System.out.println("No se aplicará la ley de intercambio");
        } else {
            System.out.println("Se aplicará en la generación: " + numIntercambio);
        }

        for (int generacion = 0; generacion < numGeneraciones || numGeneraciones == 0; generacion++) {
            limpiarConsola();
            System.out.println("Generación: " + generacion);
            mostrarGeneracion(generacionActual);

            try {
                Thread.sleep(intervalo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (numIntercambio != 0 && generacion == numIntercambio) {
                generacionActual = Reglas.intercambio(generacionActual);
            } else {
                generacionActual = Reglas.aplicarReglas(generacionActual);
            }
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
