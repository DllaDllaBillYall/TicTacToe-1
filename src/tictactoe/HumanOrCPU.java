package tictactoe;

/**
 *
 * @author manny
 */
public enum HumanOrCPU {
    CPU("CPU"), HumanO("user"), HumanX("user");
    
    private String is;
    
    HumanOrCPU(String is){
        this.is = is;
    }
    
    public String getIs(){
        return is;
    }
    
}
