package tictactoe;

/**
 *
 * @author manny
 */
public enum XorO {
    PlayerX('X'), PlayerO('O');
    
    private char player;
    
    XorO(char player) {
        this.player = player;
    }
    
    public char getTurn(){
        return player;
    }
    
}
