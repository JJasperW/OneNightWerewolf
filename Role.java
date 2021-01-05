import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class used as a template to create new roles.
 *
 * @author Jasper Williams
 * @version 05/01/21
 */
public class Role
{
    // the name of the role
    private String role;
    // dictates whether the role wakes up and performs an action in the night
    private boolean wakesUp;
    // dictates when the role wakes up and performs their action
    private int turnNumber;
    // indicates whether the role is on the Werewolf team or Villager team, and thus whether they are evil or not.
    private boolean evil;
    // describes how to play the role and how they win
    private String description;
    // soure of inputs
    public Scanner reader;
    
    /**
     * Constructor for objects of class Role
     */
    public Role(String role, boolean wakesUp, int turnNumber, boolean evil, String description)
    {
        this.role = role;
        this.wakesUp = wakesUp;
        this.turnNumber = turnNumber;
        this.evil = evil;
        this.description = description;
        reader = new Scanner(System.in);
    }
    
    /**
     * Returns the name of the role.
     * 
     * @return The name of the role
     */
    public String toString()
    {
        return role;
    }
    
    /**
     * Returns the turn number of this role
     *
     * @return This role's turn number
     */
    public int getTurnNumber()
    {
        return turnNumber;
    }
    
    /**
     * Returns whether or not this role is evil.
     * 
     * @return the value of evil
     */
    public boolean getEvil()
    {
        return evil;
    }
    
    /**
     * Performs this role's action.
     */
    public void action(Player currentPlayer, ArrayList<Player> centreCards, ArrayList<Player> players)
    {
        printDescription();
    }
    
    /**
     * Prints the description for this role.
     */
    public void printDescription()
    {
        System.out.println(description);
        if(evil) {
            System.out.println("You are on the werewolf team. To win, you must try and stop yourself or other werewolves from being voted for.");
        }
        else {
            System.out.println("You are on the villager team. To win, the majority of your team must vote for a player on the werewolf team.");
        }
    }
}