package com.gamingroom;

/**
 * Application start-up program
 * 
 * @author coce@snhu.edu
 */
public class ProgramDriver {

	/**
	 * The one-and-only main() method
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {

		// FIXME: obtain reference to the singleton instance

		// Initialize the singleton GameService instance
		GameService service = GameService.getInstance(); // replace null with ???

		System.out.println("\nAbout to test initializing game data...");
		
		//Tested java classes with new set of game data and print statements
		Game game1 = service.addGame("Game #1"); 
		Team team1 = game1.addTeam("Team #1"); 
		Player player1 = team1.addPlayer("Player #1"); 
		System.out.println(game1);
		System.out.println(team1); 
		System.out.println(player1); 
		Game game2 = service.addGame("Game #2"); 
		Team team2 = game2.addTeam("Team #2"); 
		Player player2 = team2.addPlayer("Player #2"); 
		System.out.println(game2);
		System.out.println(team2); 
		System.out.println(player2);

		// use another class to prove there is only one instance
		SingletonTester tester = new SingletonTester();
		tester.testSingleton();
	}
}
