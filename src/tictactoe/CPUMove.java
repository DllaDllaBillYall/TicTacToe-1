package tictactoe;
/**
 *
 * @author manny
 */
public class CPUMove{
    public int score;
    public int xCoord;
    public int yCoord;
    
    public CPUMove(int score){
        this.score = score;
    }
    
    public CPUMove(int xCoord, int yCoord){
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }
}
