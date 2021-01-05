import java.util.ArrayList;
import java.util.Scanner;
    
/**
 * A class for the role of Seer.
 *
 * @author Jasper Williams
 * @version 05/01/21
 */
public class Seer extends Role
{
    /**
     * Constructor for objects of class Seer
     */
    public Seer()
    {
        super("Seer", false, 3, false, "You are a Seer, when you wake up in the night, you may look at a player's card or two of the centre cards.");
    }
        
    /**
     * Checks the role of the entered player or of two of the selected middle cards.
     * Overwrites the action method from role.
     */
    public void action(Player currentPlayer, ArrayList<Player> centreCards, ArrayList<Player> players)
    {
        printDescription();
        System.out.println();
        boolean validChoice = false;
        String input = "";
        while(!validChoice){ 
            System.out.println("Would you like to look at a player's card? (Y / N)");
            input = reader.nextLine();
            if(input.equals("Y")){
                validChoice = true;
                boolean found = false;
                while(!found){
                    System.out.println("Please enter the name of the player whose card you would like to look at. ");
                    input = reader.nextLine();
                    for(Player p : players){
                        String playerName = p.getName();
                        if(playerName.equals(input) && p != currentPlayer){
                            Role role = p.getRole();
                            System.out.println("The selected player is a " + role.toString());
                            found = true;
                        }
                    }
                    String playerName = currentPlayer.getName();
                    if(playerName.equals(input)){
                        System.out.println("Invalid input, you cannot look at your own card, please try again.");
                        found = false;
                    }
                    else if(!found){
                        System.out.println("Invalid input, the specified player could not be found, please try again.");
                    }
                }
            }
            else if(input.equals("N")){
                validChoice = true;
                String[] midCards = {"Left", "Middle", "Right"};
                for (int i = 0; i < 2; i++){
                    boolean foundMidCard = false;
                    System.out.println("Please enter which centre card you would like to look at. (Left / Middle / Right)");
                    input = reader.next();
                    for(Player p : centreCards){
                        String playerName = p.getName();
                        if(playerName.equals(input)){
                            foundMidCard = true;
                            Role role = p.getRole();
                            System.out.println("The selected card is a " + role.toString());
                        }
                    }
                    if(!foundMidCard){
                        System.out.println("Invalid input, the specified card was not a centre card, please try again.");
                    }
                }
            }
            else{
                System.out.println("Invalid input, please try again.");
            }
        }
    }
}
