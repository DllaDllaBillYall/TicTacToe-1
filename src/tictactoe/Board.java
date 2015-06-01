package tictactoe;

/**
 *
 * @author manny
 */
public class Board {
    private final int ROWS = 3;     // Number of rows for the board
    private final int COLUMNS = 3;  // Number of columns for the board
    private char[][] board = new char[ROWS][COLUMNS];
    private int xCoord;
    private int yCoord;
    
    public Board(){
        newBoard();
    }
    
    // Initializes the board to empty space characters
    public void newBoard(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                board[i][j] = ' ';
            }
        }
    }
    
    // Prints board to the console
    // Outer array is Height Y
    // Inner Arrays are Length X
    public void printBoard(){
        System.out.print("\n\n   0    1    2");
        System.out.println("\n   _ _ _ _ _ _ ");
        for(int i = 0; i < board.length; i++){
            System.out.printf("%d | ", i);
            for(int j = 0; j < board[i].length; j++){
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n  |_ _|_ _|_ _|");
        }
        System.out.println();
    }
    
    // Sets coordinate as X or Y to board
    public void setCoord(int xCoord, int yCoord, XorO turn){
        try {
            this.xCoord = xCoord;
            this.yCoord = yCoord;
            board[xCoord][yCoord] = turn.getTurn();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please pick a coodinate between 0 and 2");
        }
        
        
    }
    
    public char[][] getBoard(){
        return board;
    }
}

