package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires an id and name to be passed
 * when creating. Also note that no mutators (setters) defined so these values
 * cannot be changed once a game is created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
public class Game extends Entity {

	// list of active teams
	private List<Team> teams = new ArrayList<Team>();

	/**
	 * Constructor with an identifier and name
	 */
	public Game(long id, String name) {
		super(id, name);

	}

	// use iterator pattern to find existing team with same name or adds unique
	// named team to list
	public Team addTeam(String name) {

		// a local game instance
		Team team = null;

		// if found, simply return the existing instance
		for (Team currentTeam : teams) {
			if (currentTeam.getName().equals(name)) {
				return currentTeam;
			}
			break; //placed a break statement so if team name was found then there's no need to keep searching
		}

		// if not found, make a new game instance and add to list of games
		if (team == null) {
			GameService instance = GameService.getInstance(); //added instance in order to grab team Id identifier
			team = new Team(instance.getNextTeamId(), name);
			teams.add(team);
		}

		// return the new/existing game instance to the caller
		return team;

	}

	@Override
	public String toString() {

		return "Game [id=" + super.getId() + ", name=" + super.getName() + "]";
	}

}
