package mru.game.model;

/**
 * This class represent each player record in the Database
 * It is basically a model class for each record in the text file
 */
public class Player {

	private String name;
	private int balance;
	private int numberOfWins;

	/**
	 * Default constructor
	 * @param name: player name
	 * @param balance: player balance
	 * @param numberOfWins: player number of wins
	 */
	public Player(String name, int balance, int numberOfWins) {
		this.name = name;
		this.balance = balance;
		this.numberOfWins = numberOfWins;
	}

	/**
	 * Getter method for name
	 * @return player name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter method for name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter method for balance
	 * @return player balance
	 */
	public int getBalance() {
		return balance;
	}

	/**
	 * Setter method for balance
	 * @param balance
	 */
	public void setBalance(int balance) {
		this.balance = balance;
	}

	/**
	 * Getter method for numberOfWins
	 * @return player numberOfWins
	 */
	public int getNumberOfWins() {
		return numberOfWins;
	}

	/**
	 * Setter method for numberOfWins
	 * @param numberOfWins
	 */
	public void setNumberOfWins(int numberOfWins) {
		this.numberOfWins = numberOfWins;
	}

	@Override
	public String toString() {
		return name +
				"," + balance +
				"," + numberOfWins;
	}
}
