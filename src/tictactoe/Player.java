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
    public void move(Board board){
        switch(is){ // Checks to see if huamn or AI before making move
            case CPU:
                // AI functions go here
                break;  
            default:
                System.out.println("Enter the coordinates for your move.");
                System.out.println("X Coordinate: ");
                this.setXCoord(scan.nextInt());
                System.out.println("Y Coordinate: ");
                this.setYCoord(scan.nextInt());
                break;
        }
        
        board.setCoord(getXCoord(), getYCoord(), turn);
        
    }
    
    public HumanOrCPU getIs(){
        return is;
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
