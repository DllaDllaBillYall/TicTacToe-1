package tictactoe;

/**
 *
 * @author manny
 * 
 * Used to determine whether the player is a human or CPU
 */
public enum PlayerType {
    CPU("CPU"), HumanO("user"), HumanX("user");
    
    private String type;
    
    PlayerType(String type){
        this.type = type;
    }
    
    @Override
    public String toString(){
        return type;
    }
    
}
