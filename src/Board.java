public class Board {

    private static final int SIZE = 3;
    private final char[][] grid;

    public Board(){
        grid = new char[SIZE][SIZE];
        initializeBoard();
    }

    public void initializeBoard(){
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                grid[i][j] = ' ';
            }
        }
    }

    public void display(){
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                System.out.print(" " + grid[i][j] + " ");
                if (j < SIZE - 1){
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < SIZE - 1){
                System.out.println("-----------");
            }
        }
    }

    public boolean makeMove(int row, int col, char symbol){
        if (grid[row][col] == ' '){
            grid[row][col] = symbol;
            return true;
        }
        return false;
    }

    public boolean isFull(){
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                if (grid[i][j] == ' '){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasWinner(){
        return checkRows() || checkColumns() || checkDiagonal();
    }

    private boolean checkRows(){
        for (int i = 0; i < SIZE; i++){
            if (grid[i][0] == grid[i][1] &&
                grid[i][1] == grid[i][2] &&
                grid[i][0] != ' '){
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns(){
        for (int j = 0; j < 3; j++){
            if (grid[0][j] == grid[1][j] &&
                grid[1][j] == grid [2][j] &&
                grid[0][j] != ' '){
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonal(){
        return (grid[0][0] == grid[1][1] &&
                grid[1][1] == grid[2][2] &&
                grid[0][0] != ' ') ||

                (grid[0][2] == grid[1][1] &&
                 grid[1][1] == grid[2][0] &&
                 grid[0][2] != ' ');

    }
}
