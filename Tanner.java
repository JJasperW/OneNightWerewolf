/**
 * A class for the role of Tanner.
 *
 * @author Jasper Williams
 * @version 05/01/21
 */
public class Tanner extends Role
{
    //the description of the Tanner class
    private String description = "You are a tanner, you do not wake up in the night";
    
    /**
     * Constructor for objects of class Tanner
     */
    public Tanner()
    {
        super("Tanner", false, 1, false, "You are a tanner, you do not wake up in the night");
    }
    
    /**
     * Prints the description for this role.
     * Overwrites the printDescription method from role.
     */
    public void printDescription()
    {
        System.out.println(description);
        System.out.println("You are on your own. You win by being voted for.");
    }
}

