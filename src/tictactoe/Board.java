package tictactoe;

/**
 *
 * @author manny
 */
public class Board {
    private final int ROWS = 3;     // Number of rows for the board
    private final int COLUMNS = 3;  // Number of columns for the board
    private char[][] board = new char[ROWS][COLUMNS];
    
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
    public void printBoard(){
        System.out.println("\n _ _ _ _ _ _ ");
        for(int i = 0; i < board.length; i++){
            System.out.print("| ");
            for(int j = 0; j < board[i].length; j++){
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n|_ _|_ _|_ _|");
        }
    }
    
    public void setCoord(Turn turn){
        switch(turn){
            case X:
                
        }
    }
    
    
    
}
