package tictactoe;

/**
 *
 * @author manny
 * 
 * Assigns X or O to players
 */
public enum GamePiece {
    X('X'), O('O');
    
    private char piece;
    
    GamePiece(char piece) {
        this.piece = piece;
    }
    
    public char toChar(){
        return piece;
    }
}
