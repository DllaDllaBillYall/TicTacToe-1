package tictactoe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author manny
 */
public class Player {
    private int xCoord; 
    private int yCoord;
    public XorO turn;     // Identifier for Player X or Player O
    public HumanOrCPU is; // Identifier to see if player is human or AI
    private Scanner scan;
    
    public Player(){
        this.scan = new Scanner(System.in);
    }
    
    // Allows player to make a move
    public boolean move(Board board){
        
        switch(is){
            case CPU:
                
                if(firstMove(board));
                else {
                CPUMove move = getBestMove(board, this.turn, this.is);
                this.setXCoord(move.xCoord);
                this.setYCoord(move.yCoord);
                }
                break;
            default:
                System.out.println("Enter the coordinates for your move.");
                boolean valid = true;
                while(valid)
                    try {
                        System.out.println("Which row?: ");
                        this.setXCoord(scan.nextInt());
                        System.out.println("Which column: ");
                        this.setYCoord(scan.nextInt());
                        valid = false;
                    } catch (InputMismatchException e) {
                        System.out.println("Please choose a valid option.");
                        scan.next();
                    }
        

                break;
        }
        
        
        try{
            if(board.getBoard()[getXCoord()][getYCoord()] == ' '){
                board.setCoord(getXCoord(), getYCoord(), turn);
                return true;
            } else{
                return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        
    }
    
    // Checks to see if the board is empty and chooses a random corner
    // to fill in for the CPU
    public boolean firstMove(Board board){
        Set<Character> moveCheck = new HashSet<Character>();
        for(char[] chArr:board.getBoard()){
            for(char ch:chArr){
                moveCheck.add(ch);
            }
        }
        if(moveCheck.size() == 1 && moveCheck.contains(' ')){
            Random rand = new Random();
            int move = rand.nextInt(4);
            switch(move){
                case 0:
                    this.setXCoord(0);
                    this.setYCoord(0);
                    return true;
                case 1:
                    this.setXCoord(0);
                    this.setYCoord(2);
                    return true;
                case 2:
                    this.setXCoord(2);
                    this.setYCoord(0);
                    return true;
                case 3:
                    this.setXCoord(2);
                    this.setYCoord(2);
                    return true;
            }
        }
        return false;
    }
    
    // Chooses the best move based on the minimax algorithm
    public CPUMove getBestMove(Board b, XorO turn, HumanOrCPU is){
        // Assign board
        char[][] board = b.getBoard();
        
        // Gets the return value of the board's status
        // Checks the winning value of the player before turn switch
        WinLoseTie rv = b.status();  
        
        // Stores all the moves iterated over the for loop 
        // and picks the highest score
        ArrayList<CPUMove> moves = new ArrayList<>();
       
        if(rv == WinLoseTie.WinX){
            return (new CPUMove(10));
        } else if(rv == WinLoseTie.WinO){

            return (new CPUMove(-10));
        } else if(rv == WinLoseTie.Tie){

            return (new CPUMove(0));
        } else{
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[i].length; j++){
                    if(board[i][j] == ' '){
                        board[i][j] = turn.getTurn();
                        CPUMove move = new CPUMove(i, j);
//                        b.printBoard();

                        if(turn.getTurn() == 'X'){
                            turn = XorO.PlayerO;
                            is = HumanOrCPU.HumanO;
                            move.score = getBestMove(b, turn, is).score;
                            turn = XorO.PlayerX;
                            is = HumanOrCPU.CPU;
                        } else {
                            turn = XorO.PlayerX;
                            is = HumanOrCPU.CPU;
                            move.score = getBestMove(b, turn, is).score;
                            turn = XorO.PlayerO;
                            is = HumanOrCPU.HumanO;
                        } 
                        moves.add(move);
                        // Put board back how it was
                        board[i][j] = ' ';
                    }
                }
            }
            
        }
        
        int bestMove = 0;
        if (is == HumanOrCPU.CPU){
            int bestScore = -1000000;
            for(int i = 0; i < moves.size(); i++){

                if (moves.get(i).score > bestScore){
                    bestScore = moves.get(i).score;
                    bestMove = i;
                }
            }
        } else if (is == HumanOrCPU.HumanO){
            int bestScore = 10000000;
            for(int i = 0; i < moves.size(); i++){
                if(moves.get(i).score < bestScore){
                    bestScore = moves.get(i).score;
                    bestMove = i;
                }
            }
            
        } 
        return moves.get(bestMove);
    }
    
    public HumanOrCPU getIs(){
        return this.is;
    }
    
    public void setIs(HumanOrCPU is){
        this.is = is;
    }
    public void setTurn(XorO turn){
        this.turn = turn;
    }
    
    public int getXCoord(){
        return xCoord;
    }
    
    public int getYCoord(){
        return yCoord;
    }
    
    public void setXCoord(int xCoord){
        this.xCoord = xCoord;
    }
    
    public void setYCoord(int yCoord){
        this.yCoord = yCoord;
    }

    @Override
    public String toString(){
        return "Player " + turn.getTurn() + " is a " + is.getIs() + ".";
    }
}
