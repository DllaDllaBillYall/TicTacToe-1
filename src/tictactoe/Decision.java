package tictactoe;

/**
 *
 * @author manny
 * 
 * Used as a yes or no input
 */
public enum Decision {
    yes("yes"), no("no"), y("y"), n("n"), Yes("Yes"),
    No("No"), YES("YES"), NO("NO"), Y("Y"), N("N"), None(" 0 ");
    
    private String decision;
    
    Decision(String decision){
        this.decision = decision;
    }
    
    public String getDecision(){
        return this.decision;
    }
}
