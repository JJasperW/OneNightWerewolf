import java.util.ArrayList;
import java.util.Scanner; 

/**
 * A class for the role of Werewolf.
 *
 * @author Jasper Williams
 * @version 05/01/21
 */
public class Werewolf extends Role
{
    /**
     * Constructor for objects of class Villager
     */
    public Werewolf()
    {
        super("Werewolf", false, 2, true, "You are a werewolf, you may wake up in the night and look for other werewolves. If you are the only werewolf, you may look at a centre card.");
    }
    
    /**
     * Allows the player to see the names of the other werwolves.
     * If there are no other werewolves, they make look at one of the centre cards.
     * Overwrites the action method from role.
     */
    public void action(Player currentPlayer, ArrayList<Player> centreCards, ArrayList<Player> players)
    {
        printDescription();
        String input;
        boolean correctInput = false;
        String[] midCards = {"Left", "Middle", "Right"};
        String name;
        int numOfWerewolves = 0;
        System.out.println();
        System.out.println("The following players are Werewolves: ");
        for(Player p : players){
           if(p.getRole() instanceof Werewolf){
               numOfWerewolves ++;
               name = p.getName();
               System.out.println(name + " is a werewolf. ");
           }
        }
        if(numOfWerewolves == 1){
            System.out.println();
            System.out.println("You are the only werewolf, you may look at one of the centre cards. ");
            input = "";
            while(!correctInput) {
                System.out.println("Please enter which centre card you would like to look at. (Left / Middle / Right)");
                input = reader.nextLine();
                for(String c : midCards){
                    if(input.equals(c)){
                        correctInput = true;
                    }
                }
                if(!correctInput){
                    System.out.println("Invalid input, the specified card is not a centre card, please try again.");
                }
            }
            for(Player p : centreCards){
                String cardName = p.getName();
                if(cardName.equals(input)){
                    Role role = p.getRole();
                    System.out.println("The selected card is a " + role.toString());
                }
            }
        }
    }
}
