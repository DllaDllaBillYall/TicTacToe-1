package tictactoe;
/**
 *
 * @author manny
 * 
 * Used to store and return the best 
 * move based on the minimax algorithm
 */
public class CPUMove{
    public int score;
    public int xCoord;
    public int yCoord;
    
    public CPUMove(int score){
        this.score = score;
    }
    
    public CPUMove(int xCoord, int yCoord){
        this.score = 0;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }
}
