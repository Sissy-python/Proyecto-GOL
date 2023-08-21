import java.util.Scanner;

public class Generaciones {

    public static void main(String[] args) {
        char[][] tablero = {
                {'#', '#', '#', '#', '#'},
                {'#', 'P', ' ', 'G', '#'},
                {'#', ' ', '#', ' ', '#'},
                {'#', '*', ' ', ' ', '#'},
                {'#', '#', '#', '#', '#'}
        };
        int pacmanRow = 1;
        int pacmanCol = 1;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printBoard(tablero);

            System.out.println("Enter move (WASD): ");
            char move = scanner.next().charAt(0);
            int vidas = 3;
            int newRow = pacmanRow;
            int newCol = pacmanCol;

            switch(move) {
                case 'W':
                case 'w':
                    newRow--;
                    break;
                case 'A':
                case 'a':
                    newCol--;
                    break;
                case 'S':
                case 's':
                    newRow++;
                    break;
                case 'D':
                case 'd':
                    newCol++;
                    break;
                default:
                    System.out.println("Invalid move. Use WASD.");
                    continue;
            }

            if (tablero[newRow][newCol] == 'G') {
                System.out.println("Game over! Ghost caught Pacman!");
                vidas--;
                break;

            } else if (tablero[newRow][newCol] == ' ') {
                tablero[pacmanRow][pacmanCol] = ' ';
                tablero[newRow][newCol] = 'P';
                pacmanRow = newRow;
                pacmanCol = newCol;
            } else if (tablero[newRow][newCol] == '*') {
                tablero[pacmanRow][pacmanCol] = ' ';
                tablero[newRow][newCol] = 'P';
                pacmanRow = newRow;
                pacmanCol = newCol;
                vidas++;
            }
        }

        scanner.close();
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    }
}
