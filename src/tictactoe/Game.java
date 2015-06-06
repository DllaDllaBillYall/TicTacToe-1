package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author manny
 */
public class Game {
        private Board board;    // Sets the board up for the game
        private Player playerX;
        private Player playerO;
        private Player player; // Current player
        private Scanner in;
        private XorO turn;
        private boolean gameEnd;
        
        public Game(){
            board = new Board();
            playerX =  new Player();
            playerO = new Player();
            in = new Scanner(System.in);
            turn = XorO.PlayerX;
            player = playerX;
            gameEnd = false;
        }
        
        public void start(){
            switch(menu()){
                // 1) Multiplayer choice
                case 1:
                // do this
                    break;
                    
                /** 2) CPU - CPU goes first.
                 * Sets the CPU as Player X and user as Player O
                 */        
                case 2:
                    // 
                    playerX.setIs(HumanOrCPU.CPU);
                    playerX.setTurn(XorO.PlayerX);
                    playerO.setIs(HumanOrCPU.HumanO);
                    playerO.setTurn(XorO.PlayerO);
                    break;
            }
                    
                System.out.println("\n" + playerX);
                System.out.println(playerO);
        }
        
        // Allows players to make their moves
        public void play(){
            board.printBoard();
            
            switch(player.getIs()){
                case CPU:
                    System.out.println("It is the CPU's turn.");
                    break;
                default:
                    System.out.printf("\nYour move %s\n", turn);
            }
            
            // Checks to see if spot is already taken for moves
            boolean spotTaken = true;
            while(spotTaken){
                if(player.move(board)){
                    spotTaken = false;
                } else{
                    System.out.println("\nPlease choose a valid spot on the board.\n");
                }
  
            }
            
            // Checks the status of the game after the most recent move
            switch(board.status(player.turn)){
                case Win:
                    this.gameEnd = true;
                    board.printBoard();
                    System.out.printf("%s has won. Play again?(y/n) \n", turn);
                    playAgain();
                    return;
                case Tie:
                    this.gameEnd = true;
                    board.printBoard();
                    System.out.println("The game is a tie!. Play again?(y/n)");
                    playAgain();
                    return;
                case Continue:
                    break;
            }
            System.out.println(board.status(player.turn));
            nextTurn(turn);
            
        }
        
                // Changes turns
        private XorO nextTurn(XorO turn){
            switch(turn){
                case PlayerX:
                    this.turn = XorO.PlayerO;
                    this.player = playerO;
                    break;
                case PlayerO:
                    this.turn = XorO.PlayerX;
                    this.player = playerX;
                    break;
            }
            
            return turn;
        }
        // Checks to see if player wants to play again
        public void playAgain(){
            YesOrNo choice = YesOrNo.None;
            String strChoice;
            while(choice == YesOrNo.None){
                try {
                    strChoice = in.next();
                    choice = YesOrNo.valueOf(strChoice.trim());
                } catch (IllegalArgumentException e) {
                    System.out.println("Please type in a valid value.");
                    in.next();
                }
            }
            switch(choice){
                case YES:
                case Yes:
                case y:
                case Y:
                    this.board.newBoard();
                    this.turn = XorO.PlayerX;
                    this.player = playerX;
                    this.gameEnd = false;
                    return;
                case NO:
                case No:
                case n:
                case N:
                    System.out.println("Thanks for playing!");
                    return;
            }
            
            
            
        }

        public boolean getGameEnd(){
            return this.gameEnd;
        }
        
        private void setGameEnd(boolean gameEnd){
            this.gameEnd = gameEnd;
        }
        
        // Prints out menu and returns choice selected by user
        private int menu(){
            System.out.println("Tic Tac Toe");
            System.out.println("\nMenu:");
            System.out.println("1) Multiplayer");
            System.out.println("2) CPU");

            int choice = -1;
            
            // Makes sure user inputs correct menu option
            
            while(choice != 1 && choice != 2){
                
                try{
                    choice = in.nextInt();
                    if (choice != 1 && choice != 2){
                        System.out.println("Please choose an option within the menu.");
                        continue;
                    }

                } catch (InputMismatchException ex) {
                    System.out.println("Please choose an option within the menu.");
                    in.next();
                }
            }
            
            return choice;
        }
        
        
}
   
