package tictactoe;

/**
 *
 * @author manny
 * 
 * Used to determine whether the player is a human or CPU
 */
public enum PlayerType {
    CPU("CPU"), HumanO("user"), HumanX("user");
    
    private String is;
    
    PlayerType(String is){
        this.is = is;
    }
    
    
    public String getIs(){
        return is;
    }
    
}
