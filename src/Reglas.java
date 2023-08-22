public class Reglas {

    public static boolean[][] aplicarReglas(boolean[][] actual) {
        boolean[][] generacion = new boolean[actual.length][actual[0].length];

        for (int i = 0; i < actual.length; i++) {
            for (int j = 0; j < actual[i].length; j++) {
                int vecinos = contarVecinos(actual, i, j);

                if (actual[i][j]) {
                    if (vecinos < 2) { //Se establece la regla de subpoblacion
                        generacion[i][j] = false;
                    }
                    else if (vecinos > 3) { //Se establece la regla de sobrepoblacion
                        generacion[i][j] = false;
                    }
                    else {
                        generacion[i][j] = true; //Se establece la regla de superviviencia
                    }
                } else {
                    if (vecinos == 3) { //Se establece la regla de revivir
                        generacion[i][j] = true;
                    }
                }
            }
        }
        return generacion;
    }

    private static int contarVecinos(boolean[][] actual, int i, int j) {
        int vecinos = 0;
        for (int x = i - 1; x <= i + 1; x++) {
            for (int y = j - 1; y <= j + 1; y++) {
                if (x >= 0 && x < actual.length && y >= 0 && y < actual[x].length) {
                    if (!(x == i && y == j)) {
                        if (actual[x][y]) {
                            vecinos++;
                        }
                    }
                }
            }
        }
        return vecinos;
    }
}
