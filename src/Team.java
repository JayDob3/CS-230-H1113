package com.gamingroom;

import java.util.ArrayList;	
import java.util.List;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires an id and name to be passed
 * when creating. Also note that no mutators (setters) defined so these values
 * cannot be changed once a team is created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
public class Team extends Entity {

	// list active teams
	private List<Player> players = new ArrayList<Player>();

	/*
	 * Constructor with an identifier and name
	 */
	public Team(long id, String name) {
		super(id, name);
	}

	// use iterator pattern to find existing player with the same name or adds
	// unique named player to list
	public Player addPlayer(String name) {

		// a local game instance
		Player player = null;

		// FIXME: Use iterator to look for existing game with same name
		// if found, simply return the existing instance
		for (Player currentPlayer : players) {
			if (currentPlayer.getName().equals(name)) {
				return currentPlayer;
			}
			break; //placed a break statement so if player's name was found then there's not need to keep searching 
		}

		// if not found, make a new game instance and add to list of games
		if (player == null) {
			GameService instance = GameService.getInstance();
			player = new Player(instance.getNextPlayerId(), name);
			players.add(player);
		}

		// return the new/existing game instance to the caller
		return player;
	}

	@Override
	public String toString() {
		return "Team [id=" + super.getId() + ", name=" + super.getName() + "]";
	}
}
