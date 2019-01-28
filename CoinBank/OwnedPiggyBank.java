package eecs2030.lab4;

import java.util.ArrayList;
import java.util.List;

/**
 * A class representing a piggy bank that has an owner. A piggy bank owns a
 * collection (or possibly collections) of coins, but does not own the coins
 * themselves. In other words, the piggy bank and its collection of coins form a
 * composition.
 * 
 * <p>
 * Only the owner of the piggy bank is able to remove coins from the piggy bank.
 * The piggy bank does own its owner. In other words, the piggy bank and its
 * owner form an aggregation.
 */
public class OwnedPiggyBank {
	/*
	 * YOU NEED A FIELD HERE TO HOLD THE COINS OF THIS PIGGY BANK
	 */
	List<Coin> coins;

	/**
	 * The owner of this piggy bank.
	 */
	private Owner owner;

	/**
	 * Initializes this piggy bank so that it has the specified owner and its
	 * collection of coins is empty.
	 * 
	 * @param owner the owner of this piggy bank
	 */
	public OwnedPiggyBank(Owner owner) {
		this.owner = owner;
		this.coins = new ArrayList<Coin>();
	}

	/**
	 * Initializes this piggy bank by copying another piggy bank. This piggy bank
	 * will have the same owner and the same number and type of coins as the other
	 * piggy bank.
	 * 
	 * @param other the piggy bank to copy
	 */
	public OwnedPiggyBank(OwnedPiggyBank other) {
		this.owner = other.getOwner();
		this.coins = other.deepCopy();

	}

	/**
	 * Returns the owner of this piggy bank.
	 * 
	 * <p>
	 * This method is present only for testing purposes. Returning the owner of this
	 * piggy bank allows any user to remove coins from the piggy bank (because any
	 * user can get the owner of this piggy bank)!
	 * 
	 * @return the owner of this piggy bank
	 */
	public Owner getOwner() {
		// ALREADY IMPLEMENTED; DO NOT MODIFY
		return this.owner;
	}

	/**
	 * Allows the current owner of this piggy bank to give this piggy bank to a new
	 * owner.
	 * 
	 * @param currentOwner the current owner of this piggy bank
	 * @param newOwner     the new owner of this piggy bank
	 * @throws IllegalArgumentException if currentOwner is not the current owner of
	 *                                  this piggy bank
	 */
	public void changeOwner(Owner currentOwner, Owner newOwner) {
		boolean matches = currentOwner.equals(this.getOwner());
		if (!matches) {
			throw new IllegalArgumentException();
		} else {
			this.owner = newOwner;
		}
	}

	/**
	 * Adds the specified coins to this piggy bank.
	 * 
	 * @param coins a list of coins to add to this piggy bank
	 */
	public void add(List<Coin> coins) {
		for (Coin c : coins) {
			this.coins.add(c);
		}
	}

	/**
	 * Returns true if this piggy bank contains the specified coin, and false
	 * otherwise.
	 * 
	 * @param coin a coin
	 * @return true if this piggy bank contains the specified coin, and false
	 *         otherwise
	 */
	public boolean contains(Coin coin) {

		boolean exists = false;

		for (Coin c : this.coins) {
			if (c.equals(coin)) {
				exists = true;
			}
		}

		return exists;

	}

	/**
	 * Allows the owner of this piggy bank to remove a coin equal to the value of
	 * the specified coin from this piggy bank.
	 * 
	 * <p>
	 * If the specified user is not equal to the owner of this piggy bank, then the
	 * coin is not removed from this piggy bank, and null is returned.
	 * 
	 * @param user the person trying to remove the coin
	 * @param coin a coin
	 * @return a coin equal to the value of the specified coin from this piggy bank,
	 *         or null if user is not the owner of this piggy bank @pre. the piggy
	 *         bank contains a coin equal to the specified coin
	 */
	public Coin remove(Owner user, Coin coin) {

		boolean isOwner = user.equals(this.getOwner());

		if (!isOwner) {
			return null;
		} else {
			if (this.coins.contains(coin)) {
				this.coins.remove(coin);
			}
		}
		return coin;
	}

	/**
	 * Allows the owner of this piggy bank to remove the smallest number of coins
	 * whose total value in cents is equal to the specified value in cents from this
	 * piggy bank.
	 * 
	 * <p>
	 * Returns the empty list if the specified user is not equal to the owner of
	 * this piggy bank.
	 * 
	 * @param user  the person trying to remove coins from this piggy bank
	 * @param value a value in cents
	 * @return the smallest number of coins whose total value in cents is equal to
	 *         the specified value in cents from this piggy bank @pre. the piggy
	 *         bank contains a group of coins whose total value is equal to
	 *         specified value
	 */
	public List<Coin> removeCoins(Owner user, int value) {
		boolean matches = user.equals(this.getOwner());
		List<Coin> list = new ArrayList<Coin>();
		if (!matches) {
			return list;
		} else {
			Coin[] cs = new Coin[this.coins.size()];
			cs = this.deepCopy().toArray(cs);
			for (int i = cs.length - 1; i >= 0 && value >= 0; i--) {
				if (value / cs[i].getValue() > 0) {
					list.add(cs[i]);
					value -= cs[i].getValue();
				}
			}
		}
		return list;
	}

	/**
	 * Returns a deep copy of the coins in this piggy bank. The returned list has
	 * its coins in sorted order (from smallest value to largest value; i.e.,
	 * pennies first, followed by nickels, dimes, quarters, loonies, and toonies).
	 * 
	 * @return a deep copy of the coins in this piggy bank
	 */
	public List<Coin> deepCopy() {

		ArrayList<Coin> copyCoins = new ArrayList<Coin>();
		for (Coin c : this.coins) {
			copyCoins.add(new Coin(c));
		}
		return copyCoins;
	}
}
