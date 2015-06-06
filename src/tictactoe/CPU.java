package tictactoe;

/**
 *
 * @author manny
 */
public class CPU extends Player{
    
    public CPU(Board board){
        this.is = HumanOrCPU.CPU;
        this.turn =  XorO.PlayerX;
        
    }
    
    // Allows player to make a move
    @Override
    public boolean move(Board board){
        
        // Continue here
        getBestMove();
        
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
    // Pass a board object as argument
    public void getBestMove(Board b){
        // Assign board
        char[][] board = b.getBoard();
        
        WinLoseTie rv = b.status(turn);
        
        if(rv == WinLoseTie.Win){
            if(this.is == HumanOrCPU.CPU){
                return 10;
            } else{
                return -10;
            }
        } else if(rv == WinLoseTie.Tie){
            return 0;
        }
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == ' '){
                    board[i][j] = turn.getTurn();
                    this.setXCoord(i);
                    this.setYCoord(j);
                    
                    if(turn.getTurn() == 'X'){
                        this.turn = XorO.PlayerO;
                        this.is = HumanOrCPU.HumanO;
                        getBestMove(b);
                    } else{
                        this.turn = XorO.PlayerX;
                        getBestMove(b);
                    }
                    
                    // Put board back how it was
                    board[i][j] = ' ';
                }
            }
        }
    
}
