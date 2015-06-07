package tictactoe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

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
                CPUMove move = getBestMove(board, this.turn, this.is);
                this.setXCoord(move.xCoord);
                this.setYCoord(move.yCoord);
                break;
            default:
                System.out.println("Enter the coordinates for your move.");
                System.out.println("Which row?: ");
                this.setXCoord(scan.nextInt());
                System.out.println("Which column: ");
                this.setYCoord(scan.nextInt());
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
    
    public CPUMove getBestMove(Board b, XorO turn, HumanOrCPU is){
        // Assign board
        char[][] board = b.getBoard();
        
        // Gets the return value of the board's status
        WinLoseTie rv = b.status(turn);
        
        if(rv == WinLoseTie.Win){
            if(this.is == HumanOrCPU.CPU){
                return new CPUMove(10);
            } else{
                return new CPUMove(-10);
            }
        } else if(rv == WinLoseTie.Tie){
            return new CPUMove(0);
        }
        
        // Stores all the moves iterated over the for loop 
        // and picks the highest score
        ArrayList<CPUMove> moves = new ArrayList<>();
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == ' '){
                    board[i][j] = turn.getTurn();
                    CPUMove move = new CPUMove(i, j);
                    
                    if(turn.getTurn() == 'X'){
                        turn = XorO.PlayerO;
                        is = HumanOrCPU.HumanO;
                        move.score = getBestMove(b, turn, is).score;
                    } else{
                        this.turn = XorO.PlayerX;
                        this.is = HumanOrCPU.CPU;
                        move.score = getBestMove(b, turn, is).score;
                    }
                    
                    moves.add(move);
                    // Put board back how it was
                    board[i][j] = ' ';
                }
            }
        }
        int bestMove = 0;
        if (this.is == HumanOrCPU.CPU){
            int bestScore = -1000000;
            for(int i = 0; i < moves.size(); i++){
                if (moves.get(i).score > bestScore){
                    bestScore = moves.get(i).score;
                    bestMove = i;
                }
            }
            
        } else{
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
