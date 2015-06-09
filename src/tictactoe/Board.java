package tictactoe;

import java.util.HashSet;
import java.util.Set;

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
    
    public Status status(){
    /** Uses a set to determine if the checked spots is a winner.
     * Determines whether the game is a tie if the board is full,
     * otherwise it continues.
     */
     
        Set<Character> set = new HashSet<Character>();

        char[][] gameBoard = this.getBoard(); 

        // Length of game board
        int length = gameBoard.length; 


        // Checks for top left to bottom right diagonal
        for(int i = 0; i < length; i++){
            set.add(gameBoard[i][i]);
        }

        if(set.size() == 1){
            if(set.contains(GamePiece.X.toChar())){
                return Status.WinX;
            } else if(set.contains(GamePiece.O.toChar())){
                return Status.WinO;
            }
        }

       set.clear();

        // Checks for top right to bottom left diagonal
        for(int i = 0; i < length; i++){
            set.add(gameBoard[i][length - i - 1]);
        }

        if(set.size() == 1){
            if(set.contains(GamePiece.X.toChar())){
                return Status.WinX;
            } else if(set.contains(GamePiece.O.toChar())){
                return Status.WinO;
            }
        }
        set.clear();


        // Checks for straight lines
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                set.add(gameBoard[i][j]);
            }
            if(set.size() == 1){
                if(set.contains(GamePiece.X.toChar())){
                    return Status.WinX;
                } else if(set.contains(GamePiece.O.toChar())){
                    return Status.WinO;
                }
            }
            set.clear();

            for(int j = 0; j < length; j++){
                set.add(gameBoard[j][i]);
            }
            if(set.size() == 1){
                if(set.contains(GamePiece.X.toChar())){
                    return Status.WinX;
                } else if(set.contains(GamePiece.O.toChar())){
                    return Status.WinO;
                }
            }
            set.clear();
        }

        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                set.add(gameBoard[i][j]);
            }
        }



        if(!set.contains(' ')){
            return Status.Tie;
        }
        return Status.Continue;
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
    public void setCoord(int xCoord, int yCoord, GamePiece piece){
            this.xCoord = xCoord;
            this.yCoord = yCoord;
            board[xCoord][yCoord] = piece.toChar();
    }
    
    public char[][] getBoard(){
        return board;
    }
}

