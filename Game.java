import java.util.Scanner;

public class Game {

	private Scanner keyboard;
	private int PlayerNumber;
	private int playerOnesBankPoints = 0;
	private int playerTwosBankPoints = 0;
	private int playerThreesBankPoints = 0;
	private int playerFoursBankPoints = 0;
	private String playerOnesName = "ONE";
	private String playerTwosName = "TWO";
	private String playerThreesName = "THREE";
	private String playerFoursName = "FOUR";
	private Player One = new Player(playerOnesName, playerOnesBankPoints);
	private Player Two = new Player(playerTwosName, playerTwosBankPoints);
	private Player Three = new Player(playerThreesName, playerThreesBankPoints);
	private Player Four = new Player(playerFoursName, playerFoursBankPoints);
	private boolean turn = true;

	private Game() {
		askForNumberOfPlayers();
		if (PlayerNumber == 2) {
			while (true) {
				printPlayerScore(playerOnesName, playerOnesBankPoints);
				printPlayerScore(playerTwosName, playerTwosBankPoints);
				playerOnesBankPoints = One.turn(turn);
				turn = true;
				printPlayerScore(playerOnesName, playerOnesBankPoints);
				printPlayerScore(playerTwosName, playerTwosBankPoints);
				playerTwosBankPoints = Two.turn(turn);
				turn = true;
			}
		} else if (PlayerNumber == 3) {
			while (true) {
				printPlayerScore(playerOnesName, playerOnesBankPoints);
				printPlayerScore(playerTwosName, playerTwosBankPoints);
				printPlayerScore(playerThreesName, playerThreesBankPoints);
				playerOnesBankPoints = One.turn(turn);
				turn = true;
				printPlayerScore(playerOnesName, playerOnesBankPoints);
				printPlayerScore(playerTwosName, playerTwosBankPoints);
				printPlayerScore(playerThreesName, playerThreesBankPoints);
				playerTwosBankPoints = Two.turn(turn);
				turn = true;
				printPlayerScore(playerOnesName, playerOnesBankPoints);
				printPlayerScore(playerTwosName, playerTwosBankPoints);
				printPlayerScore(playerThreesName, playerThreesBankPoints);
				playerThreesBankPoints = Three.turn(turn);
				turn = true;
			}
		} else if (PlayerNumber == 4) {
			while (true) {
				printPlayerScore(playerOnesName, playerOnesBankPoints);
				printPlayerScore(playerTwosName, playerTwosBankPoints);
				printPlayerScore(playerThreesName, playerThreesBankPoints);
				printPlayerScore(playerFoursName, playerFoursBankPoints);
				playerOnesBankPoints = One.turn(turn);
				turn = true;
				printPlayerScore(playerOnesName, playerOnesBankPoints);
				printPlayerScore(playerTwosName, playerTwosBankPoints);
				printPlayerScore(playerThreesName, playerThreesBankPoints);
				printPlayerScore(playerFoursName, playerFoursBankPoints);
				playerTwosBankPoints = Two.turn(turn);
				turn = true;
				printPlayerScore(playerOnesName, playerOnesBankPoints);
				printPlayerScore(playerTwosName, playerTwosBankPoints);
				printPlayerScore(playerThreesName, playerThreesBankPoints);
				printPlayerScore(playerFoursName, playerFoursBankPoints);
				playerThreesBankPoints = Three.turn(turn);
				turn = true;
				printPlayerScore(playerOnesName, playerOnesBankPoints);
				printPlayerScore(playerTwosName, playerTwosBankPoints);
				printPlayerScore(playerThreesName, playerThreesBankPoints);
				printPlayerScore(playerFoursName, playerFoursBankPoints);
				playerFoursBankPoints = Four.turn(turn);
				turn = true;
			}
		}
	}

	private void askForNumberOfPlayers() {
		System.out.println("Please choose how many players there will be (2 - 4): ");
		keyboard = new Scanner(System.in);
		PlayerNumber = keyboard.nextInt();
		keyboard.nextLine();
	}

	private void printPlayerScore(String playerName, int playerBankPoints) {
		System.out.println("SCORES: PLAYER " + playerName + ": "
				+ playerBankPoints);
	}

	public static void main(String[] args) {
		System.out.println("Welcome to THE GAME OF PIG!");
		new Game();
	}
}
