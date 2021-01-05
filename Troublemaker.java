import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class for the role of Troublemaker.
 *
 * @author Jasper Williams
 * @version 05/01/21
 */
public class Troublemaker extends Role
{
    /**
     * Constructor for objects of class Troublemaker
     */
    public Troublemaker()
    {
        super("Troublemaker", true, 5, false, "You are a troublemaker, when you wake up in the night you may exchange roles between two other players.");
    }

    /**
     * Swaps the role of the two inputted players.
     * Overwrites the action method from role.
     */
    public void action(Player currentPlayer, ArrayList<Player> centreCards, ArrayList<Player> players)
    {
        printDescription();
        System.out.println();
        String currentPlayerName = currentPlayer.getName();
        String playerName1;
        String playerName2;
        Player playerTemp1 = null;
        Player playerTemp2 = null;
        boolean validInput = false;
        while(!validInput){
            System.out.println("Please enter the name of the first player whose card you would like to switch. ");
            playerName1 = reader.nextLine();
            System.out.println("Please enter the name of the seoncd player whose card you'd like to switch. ");
            playerName2 = reader.nextLine();
            if(currentPlayerName.equals(playerName1) || currentPlayerName.equals(playerName2)){
                    System.out.println("Invalid input, you cannot choose yourself, please try again. ");
                }
            else{
                boolean found1 = false;
                boolean found2 = false;
                for(Player p : players){
                    String currentName = p.getName();
                    if(currentName.equals(playerName1)){
                        playerTemp1 = p;
                        found1 = true;
                    }
                    else if(currentName.equals(playerName2)){
                        playerTemp2 = p;
                        found2 = true;
                    }
                }
                if((!found1) && (!found2)){
                    System.out.println("Invalid input, those players could not all be found, please try again.");
                }
                else{
                    Role role1 = playerTemp1.getRole();
                    Role role2 = playerTemp2.getRole();
                    playerTemp2.setRole(role1);
                    playerTemp1.setRole(role2);
                    System.out.println("Swapped the roles of " + playerName1 + " and " + playerName2 + ".");
                    validInput = true;
                }
            }
        }
    }
}
