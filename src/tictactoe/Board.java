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
    
        public WinLoseTie status(){
        /* Using a set to determine if a win. If length is one and 
        that one object int he set is a player, then it's the player who
        just made a move. So the current player is a winner.
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
            if(set.contains(XorO.PlayerX.getTurn())){
                return WinLoseTie.WinX;
            } else if(set.contains(XorO.PlayerO.getTurn())){
                return WinLoseTie.WinO;
            }
        }

       set.clear();

        // Checks for top right to bottom left diagonal
        for(int i = 0; i < length; i++){
            set.add(gameBoard[i][length - i - 1]);
        }

        if(set.size() == 1){
            if(set.contains(XorO.PlayerX.getTurn())){
                return WinLoseTie.WinX;
            } else if(set.contains(XorO.PlayerO.getTurn())){
                return WinLoseTie.WinO;
            }
        }
        set.clear();


        // Checks for straight lines
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                set.add(gameBoard[i][j]);
            }
            if(set.size() == 1){
                if(set.contains(XorO.PlayerX.getTurn())){
                    return WinLoseTie.WinX;
                } else if(set.contains(XorO.PlayerO.getTurn())){
                    return WinLoseTie.WinO;
                }
            }
            set.clear();

            for(int j = 0; j < length; j++){
                set.add(gameBoard[j][i]);
            }
            if(set.size() == 1){
                if(set.contains(XorO.PlayerX.getTurn())){
                    return WinLoseTie.WinX;
                } else if(set.contains(XorO.PlayerO.getTurn())){
                    return WinLoseTie.WinO;
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
            return WinLoseTie.Tie;
        }
        return WinLoseTie.Continue;
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
            this.xCoord = xCoord;
            this.yCoord = yCoord;
            board[xCoord][yCoord] = turn.getTurn();
    }
    
    public char[][] getBoard(){
        return board;
    }
}

