import java.util.*;

public class Player {

	private Scanner keyboard;
	private String reply;
	private String playerName;
	private int playersCurrentPoints;
	private int playersBankPoints;
	private int dice;
	
	public Player(String playerName, int playersBankPoints){
		this.playerName = playerName;
		this.playersBankPoints = playersBankPoints;
	}

	public int rollDice() {
		Random rand = new Random();
		dice = rand.nextInt(6) + 1;
		return dice;
	}
	
	public void displayDiceRoll(){
		System.out.println("You have rolled a: " + dice);
	}
	
	public void playerReply(){
		keyboard = new Scanner(System.in);
		reply = keyboard.nextLine();
	}
	
	public void resetPlayersCurrentPoints(){
		playersCurrentPoints = 0;
	}

	public void callPlayersName(){
		System.out.println("It is PLAYER " + playerName + "'s turn.");
	}
	public void playerMustRoll(){
		System.out.println("Press any key to roll.");
	}
	
	public void continueOrStopTurn(){
		System.out.println("Press any key to roll or 'b' to bank points.");
	}
	
	public void playerTurnOver(){
		System.out.println("You have rolled a 1. Your turn is over");
	}
	
	public void displayPlayersCurrentScore(){
		System.out.println("PLAYER " + playerName
				+ "'s Current Points: "
				+ playersCurrentPoints);
	}
	
	public void playerWins(){
		System.out.println("PLAYER " + playerName + " has won!");
		System.exit(0);
	}

	public int turn(boolean playersTurn) {
		callPlayersName();
		playerMustRoll();
		playerReply();
		while (playersTurn == true) {
			rollDice();
			if (dice == 1) {
				playerTurnOver();
				resetPlayersCurrentPoints();
				playersTurn = false;
			} else {
				playersCurrentPoints += dice;
				displayDiceRoll();
				displayPlayersCurrentScore();
				continueOrStopTurn();
				playerReply();
				if (reply.equals("b")) {
					playersBankPoints += playersCurrentPoints;
					resetPlayersCurrentPoints();
					if (playersBankPoints >= 50) {
						playerWins();
					}
					playersTurn = false;
				} else {
					rollDice();
				}
			}
		}
		return playersBankPoints;
	}
}