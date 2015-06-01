package tictactoe;

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
        switch(is){ // Checks to see if huamn or AI before making move
            case CPU:
                System.out.println("Enter the coordinates for your move.");
                System.out.println("Which row?: ");
                this.setXCoord(scan.nextInt());
                System.out.println("Which column: ");
                this.setYCoord(scan.nextInt());
                break;
            default:
                System.out.println("Enter the coordinates for your move.");
                System.out.println("Which row?: ");
                this.setXCoord(scan.nextInt());
                System.out.println("Which column: ");
                this.setYCoord(scan.nextInt());
                break;
        }
        
        if(board.getBoard()[getXCoord()][getYCoord()] == ' '){
            board.setCoord(getXCoord(), getYCoord(), turn);
            return true;
        } else{
            return false;
        }
        
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
