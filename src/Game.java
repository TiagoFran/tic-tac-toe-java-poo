import java.util.Random;
import java.util.Scanner;

public class Game {

    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();

    private final Board board;
    private char currentPlayer;
    private boolean vsBot;


    public Game() {
        this.board = new Board();
        this.currentPlayer = 'X';
    }

    public void setGameMode(int choice){
        vsBot = (choice == 2);
    }

    public void start(){
        while (true) {
            System.out.println("==============================");

            board.display();

            boolean moveMade = false;

            if (currentPlayer == 'O' && vsBot){
                
                while (!moveMade){
                    int row = random.nextInt(3);
                    int col = random.nextInt(3);

                    moveMade = board.makeMove(row, col, currentPlayer);
                }

                System.out.println("\nBot played...");

            } else {
                while (!moveMade){
                    System.out.println("Player " + currentPlayer + ", your turn.");

                    System.out.print("Enter a row (0-2): ");
                    int row = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter column (0-2): ");
                    int col = scanner.nextInt();
                    scanner.nextLine();

                    if (isValidPosition(row, col)) {
                        moveMade = board.makeMove(row, col, currentPlayer);

                        if (!moveMade){
                            System.out.println("Position already taken.");
                        }
                    } else {
                        System.out.println("Invalid move.");
                    }
                }
            }

            if (isGameOver()) break;

            switchPlayer();
        }
    }

    private boolean isValidPosition(int row, int col){
        return row >= 0 && row <= 2 && col >= 0 && col <= 2;
    }

    private void switchPlayer(){
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private boolean isGameOver(){
        if (board.hasWinner()) {
            System.out.println();
            board.display();
            System.out.println("Winner: " + currentPlayer + "!");
            return true;

        } else if (board.isFull()) {
            System.out.println();
            board.display();
            System.out.println("Draw!");
            return true;
        }
        return false;
    }
}
