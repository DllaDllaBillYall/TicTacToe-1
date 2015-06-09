package tictactoe;

/**
 *
 * @author manny
 * 
 * The main class and method of the game
 */
public class TicTacToe {
    
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
        while(!game.getGameEnd()){
            game.play();
        }
    }
    
}
