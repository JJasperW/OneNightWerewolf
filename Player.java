/**
 * A class used to create new players.
 *
 * @author Jasper Williams
 * @version 05/01/21
 */
public class Player
{
    // the name of the player
    private String name;
    // the role assigned to this player
    private Role assignedRole;
    // stores whether the player has had a go, preventing a player having multiple goes due to role switches
    private boolean hadGo;
    // stores the number of votes this player has received
    private int votes;
    
    /**
     * Constructor for objects of class Player
     */
    public Player(String name, Role assignedRole)
    {
        this.name = name;
        this.assignedRole = assignedRole;
        this.hadGo = false;
        this.votes = 0;
    }
    
    /**
     * Returns the number of votes against this player.
     * 
     * @return the value of votes
     */
    public int getVotes()
    {
        return votes;
    }
    
    /**
     * Sets the value of votes.
     */
    public void setVotes(int votes)
    {
        this.votes = votes;
    }
    
    /**
     * Returns whether the player has had a go.
     * 
     * @return the value of hadGo
     */
    public boolean gone()
    {
        return hadGo;
    }
    
    /**
     * Changes hadGo to True
     */
    public void haveGo()
    {
        hadGo = true;
    }
    
    /**
     * Returns the name of the player.
     *
     * @return the name of the player
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Returns the role of the player.
     * 
     * @return the role of the player
     */
    public Role getRole()
    {
        return assignedRole;
    }
    
    /**
     * Assigns the player a new role.
     * 
     * @param newRole the player's new role
     */
    public void setRole(Role newRole)
    {
        this.assignedRole = newRole;
    }
}
