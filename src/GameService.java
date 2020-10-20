package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;

	// holds the next team identifier
	private static long nextPlayerId = 1;

	// holds the next team identifier
	private static long nextTeamId = 1;

	// FIXME: Add missing pieces to turn this class a singleton

	// Stores Instance of GameServicee
	private static GameService Instance;

	// Creates Instance method
	private GameService() {

	}

	// Method which will update the static Instance variable
	public static GameService getInstance() {
		// checks if GameService exist
		if (Instance == null) {
			// creates new instance if not
			Instance = new GameService();
		}
		return Instance;
	}

	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		// FIXME: Use iterator to look for existing game with same name
		// if found, simply return the existing instance
		for (Game currentGame : games) {
			if (currentGame.getName().equals(name)) {
				return currentGame;
			}
			break; //placed a break statement so if game was found then there's no need to keep searching 
		}

		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;

	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * 
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}

	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;

		// FIXME: Use iterator to look for existing game with same id
		// if found, simply assign that instance to the local variable
		for (Game currentGame : games) {
			if (currentGame.getId() == id) {
				game = currentGame; //need to complete code so currentGame iterated appropriately
				break; //placed a break statement so if game id was found then there's no need to keep searching 
			}
		}

		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		// FIXME: Use iterator to look for existing game with same name
		// if found, simply assign that instance to the local variable
		for (Game currentGame : games) {
			if (currentGame.getName().equals(name)) {
				game = currentGame;
				break; //placed a break statement so if game name was found then there's no need to keep searching 
			}
		}

		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}

	// returns the player whose turn is next
	public long getNextPlayerId() {
		return nextPlayerId++; //needed to increment value so the next player id printed to the console
	}

	// returns the team whose turn is next
	public long getNextTeamId() {
		return nextTeamId++; //needed to increment vale so the next team id printed to the console
	}
}
