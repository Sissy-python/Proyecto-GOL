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
        //switch (opcionAncho) {
        if (opcionAncho == 1) { //Se dan opcines para el ancho y manda a poner esas medidas a la matiz
            ancho = 10;
        } else if (opcionAncho == 2) {
            ancho = 20;
        } else if (opcionAncho == 3) {
            ancho = 40;
        } else if (opcionAncho == 4) {
            ancho = 80;
        } else {
            System.out.println("Opción inválida. El programa se detendrá.");
            System.exit(0); // esta parte sirve para que si el usuario no pone un numero valido se detenga el programa
        }


        System.out.println("Ahora eligue la altua de tu tablero:");
        System.out.println("1. 10");
        System.out.println("2. 20");
        System.out.println("3. 40");
        int opcionAlto = scanner.nextInt();

        int alto = 0;
        //switch (opcionAlto) {
        if (opcionAlto == 1) { //Se dan opcines para el alto y manda a poner esas medidad a la matiz
            alto = 10;
        } else if (opcionAlto == 2) {
            alto = 20;
        } else if (opcionAlto == 3) {
            alto = 40;
        } else {
            System.out.println("Numero no valido, el programa se detendra");
            System.exit(0);
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

            if (opcionIntervalo == 1) {
                intervalo = 250;
            } else if (opcionIntervalo == 2) {
                intervalo = 1000;
            } else {
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
        System.out.print("\033[H\033[2J"); //Esta parte da la ilucion de que las celulas de la matriz anterior se borra y aparace la nueva generacion
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
