package tictactoe;

import java.util.Scanner;

/**
 *
 * @author manny
 */
public class Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Board board = new Board();
        Scanner in = new Scanner(System.in);
        
        System.out.println("Tic Tac Toe");
        System.out.println("1) Multiplayer");
        System.out.println("2) CPU");
        int choice = in.nextInt();
        
        
    }
    
}
