import java.util.Scanner;

public class CarromBoardGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize game components
        int strikerPositionX = 4;
        int strikerPositionY = 8;
        int redCoinPositionX = 8;
        int redCoinPositionY = 4;

        char[][] board = new char[9][9];
        initializeBoard(board);

        // Main game loop
        while (true) {
            displayBoard(board);

            System.out.println("Enter your move (e.g., 'UP', 'DOWN', 'LEFT', 'RIGHT'): ");
            String move = scanner.nextLine().toUpperCase();

            int newX = strikerPositionX;
            int newY = strikerPositionY;

            switch (move) {
                case "UP":
                    newX--;
                    break;
                case "DOWN":
                    newX++;
                    break;
                case "LEFT":
                    newY--;
                    break;
                case "RIGHT":
                    newY++;
                    break;
                default:
                    System.out.println("Invalid move.");
                    continue;
            }

            // Update striker position
            if (isValidMove(newX, newY)) {
                board[strikerPositionX][strikerPositionY] = ' ';
                strikerPositionX = newX;
                strikerPositionY = newY;
                board[strikerPositionX][strikerPositionY] = 'S';
            }

            // Update red coin position (random movement in this example)
            int randomDirection = (int) (Math.random() * 4);
            int newRedX = redCoinPositionX;
            int newRedY = redCoinPositionY;

            switch (randomDirection) {
                case 0:
                    newRedX--;
                    break;
                case 1:
                    newRedX++;
                    break;
                case 2:
                    newRedY--;
                    break;
                case 3:
                    newRedY++;
                    break;
            }

            if (isValidMove(newRedX, newRedY)) {
                board[redCoinPositionX][redCoinPositionY] = ' ';
                redCoinPositionX = newRedX;
                redCoinPositionY = newRedY;
                board[redCoinPositionX][redCoinPositionY] = 'R';
            }
        }
    }

    private static void initializeBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
        board[4][4] = 'S'; // Striker
        board[8][4] = 'R'; // Red coin
    }

    private static boolean isValidMove(int x, int y) {
        return x >= 0 && x < 9 && y >= 0 && y < 9;
    }

    private static void displayBoard(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
