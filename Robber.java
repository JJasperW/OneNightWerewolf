import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class for the role of Robber.
 *
 * @author Jasper Williams
 * @version 05/01/21
 */
public class Robber extends Role
{
   /**
     * Constructor for objects of class Robber
     */
    public Robber()
   {
       super("Robber", true, 4, false, "You are a robber, when you wake up in the night you may swap your card with a player and then view your new card.");
   }

   /**
     * Swaps the role of the inputted player with the current player.
     * Overwrites the action method from role.
     */
    public void action(Player currentPlayer, ArrayList<Player> centreCards, ArrayList<Player> players)
   {
       printDescription();
       System.out.println();
       String playerName;
       String currentPlayerName = currentPlayer.getName();
       Player playerTemp1 = null;
       boolean validInput = false;
       while(!validInput){
           System.out.println("Please enter the name of the player whose card you would like to switch with. ");
           playerName = reader.nextLine();
           if(playerName.equals(currentPlayerName)){
               System.out.println("Invalid input, you may not switch cards with yourself, please try again. ");
           }
           else{
               boolean found = false;
               for(Player p : players){
                   String currentName = p.getName();
                   if(currentName.equals(playerName)){
                       playerTemp1 = p;
                       found = true;
                   }
               }
               if(!found){
                   System.out.println("Invalid input, the specified player could not be found, please try again.");
                }
               else{
                   Role role1 = currentPlayer.getRole();
                   Role role2 = playerTemp1.getRole();
                   playerTemp1.setRole(role1);
                   currentPlayer.setRole(role2);
                   System.out.println("Swapped your role with " + playerName);
                   validInput = true;
                }
            }
       }
   }
}
