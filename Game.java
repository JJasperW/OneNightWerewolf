import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

/**
 * A class used to initialise and run a game of One Night Werewolf.
 *
 * @author Jasper Williams
 * @version 05/01/21
 */
public class Game
{
    // stores the centre cards
    private ArrayList<Player> centreCards;
    // stores the players
    private ArrayList<Player> players;
    // source of inputs
    private Scanner newReader;
    // stores the number of players
    private int numOfPlayers;
    
    /**
     * Constructor for objects of class Game
     */
    public Game()
    {
        this.centreCards = new ArrayList<Player>();
        this.players = new ArrayList<Player>();
        newReader = new Scanner(System.in);
        this.numOfPlayers = 0;
    }
    
    /**
     * Sets up a game of One Night Werewolf.
     */
    private void setup()
    {
        ArrayList<String> nameList = new ArrayList<String>();
        nameList.add("Left");
        nameList.add("Middle");
        nameList.add("Right");
        while((numOfPlayers < 3) || (numOfPlayers > 6)){
            System.out.println("How many players are there? (3-6) ");
            while(!newReader.hasNextInt()){
                String input = newReader.next();
                System.out.println("Your input is not an integer, please try again.");
                System.out.println("How many players are there? (3-6) ");
            }
            numOfPlayers = newReader.nextInt();
            if((numOfPlayers < 3) || (numOfPlayers > 6)){
                System.out.println("Invalid input, the integer is not in the specified range, please try again.");
            }
        } 
        for(int i = 1; i <= numOfPlayers; i ++){
            boolean validName = false;
            while(!validName){
                System.out.println("Please input the name of the next player (all names must be unique): ");
                String nextName = newReader.next();
                validName = true;
                for(String n : nameList){
                    if(n.equals(nextName)){
                        System.out.println("Invalid input, that name has already been used, please try again.");
                        validName = false;
                    }
                }
                if(validName){
                    nameList.add(nextName);
                }
            }
        }
        playerSetup(numOfPlayers, nameList);
    }
    
    /**
     * Constructs new player objects, randomly assigning each player to a role (including the middle cards).
     */
    private void playerSetup(int numOfPlayers, ArrayList<String> nameList)
    {
        Collections.shuffle(nameList);
        Player player1 = new Player(nameList.get(0), new Werewolf());
        Player player2 = new Player(nameList.get(1), new Werewolf());
        Player player3 = new Player(nameList.get(2), new Tanner());
        Player player4 = new Player(nameList.get(3), new Seer());
        Player player5 = new Player(nameList.get(4), new Troublemaker());
        Player player6 = new Player(nameList.get(5), new Robber());
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        players.add(player5);
        players.add(player6);
        if(numOfPlayers >= 4){
            Player player7 = new Player(nameList.get(6), new Villager());
            players.add(player7);
        }
        if(numOfPlayers >= 5){
            Player player8 = new Player(nameList.get(7), new Villager());
            players.add(player8);
        }
        if(numOfPlayers >= 6){
            Player player9 = new Player(nameList.get(8), new Villager());
            players.add(player9);
        }
        String[] midCards = {"Left", "Middle", "Right"};
        for(Player p : players){
            String name = p.getName();
            for(String c : midCards){
                if(name.equals(c)){
                    centreCards.add(p);
                }
            }
        }
        for(Player p : centreCards){
            players.remove(p);
        }
    }
    
    /**
     * The main play method of class Game.
     * Runs a game of One Night Werewolf.
     */
    public void play()
    {
        setup();
        int turnNumber = 1;
        int maxTurns = 6;
        while(maxTurns > turnNumber){
            for(Player p : players){
                Role role = p.getRole();
                String name = p.getName();
                boolean goneYet = p.gone();
                if(role.getTurnNumber() == turnNumber && goneYet == false){
                    System.out.println();
                    System.out.println("It is " + name + "'s turn:");
                    role.action(p, centreCards, players);
                    p.haveGo();
                }
            }
            turnNumber ++;
        }
        System.out.println();
        System.out.println("The game is over, the voting phase will now begin.");
        for(Player p : players){
            boolean validName = false;
            String myName = p.getName();
            while(!validName){
                System.out.println(myName + ", who would you like to vote for? (You may vote for yourself) ");
                String voteName = newReader.next();
                for(Player c : players){
                    String theirName = c.getName();
                    if(theirName.equals(voteName)){
                        validName = true;
                        int votes = c.getVotes();
                        c.setVotes(votes + 1);
                    }
                }
                if(!validName){
                    System.out.println("Invalid input, the specified player could not be found, please try again.");
                }
            }
        }
        int highestVotes = 0;
        for(Player p : players){
            if(p.getVotes() > highestVotes){
                highestVotes = p.getVotes();
            }
        }
        ArrayList<Player> highestVoted = new ArrayList<Player>();
        for(Player p : players){
            if(p.getVotes() == highestVotes){
                highestVoted.add(p);
            }
        }
        boolean tannerKilled = false;
        boolean werewolfKilled = false;
        System.out.println();
        System.out.println("You voted for and killed the following players: ");
        for(Player p : highestVoted){
            String pName = p.getName();
            Role pRole = p.getRole();
            String pRoleName = pRole.toString();
            System.out.println(pName + " who was a " + pRoleName + ". ");
            if(pRole.getEvil()){
                werewolfKilled = true;
            }
            if(pRoleName.equals("Tanner")){
                tannerKilled = true;
            }
        }
        System.out.println();
        if((!tannerKilled) && (!werewolfKilled)){
            System.out.println("You did not kill a Werewolf, the Werewolf team wins!");
        }
        else if((tannerKilled) && (!werewolfKilled)){
            System.out.println("You did not kill a Werewolf, but you killed a Tanner. The Tanner wins!");
        }
        else if((!tannerKilled) && (werewolfKilled)){
            System.out.println("You killed a Werewolf, the Village team wins!");
        }
        else if((tannerKilled) && (werewolfKilled)){
            System.out.println("You killed a Werewolf and you killed a Tanner. THe Village team and the Tanner wins!");
        }
        System.out.println();
        System.out.println("The post-game details are as follows: ");
        System.out.println();
        getGameDetails();
    }
    
    /**
     * Returns all the players and middle cards.
     */
    public void getGameDetails()
    {
        for(Player p : players){
            Role role = p.getRole();
            String roleString = role.toString();
            String name = p.getName();
            System.out.println(name + " is a " + roleString);
        }
        for(Player p : centreCards){
            Role role = p.getRole();
            String roleString = role.toString();
            String name = p.getName();
            System.out.println(name + " is a " + roleString);
        }
    }
}
