package com.revature.app.adventureGame;

import java.util.ArrayList;
import java.util.Scanner;

public class Adventure {
	
	static Bedroom allBeds = new Bedroom();
	static Kitchen allKits = new Kitchen();
	static LivingRoom allLivs = new LivingRoom();
	static Basement allBases = new Basement();
	static Attic allAttics = new Attic();

	public static void main(String[] args) {
		/*
		Adventure Game (last 2 1/2 hours to do this, 12/6/2017)
		    Room (Object) [done]
		        contents
		        description
		        exits
		    Parser (Object) [only one input -- in Game]
		        input
		        parse into command
		    Command (Object) [combined with Game]
		        take command and execute
		    Game (design to constantly run until win/lose condition is met) [will contain parser and command]
		        running the game 
			
			Project requirements [Mehrab 12/8/17] for Monday, 12/11/17
			- [y] OOP (interface, polymorphism) [like inherit child-par, abstract,...]
			- [y] Maven (junit) (more than one...)
			- [y] packages (know how to do in VSCode) (JUnit test)
			- [] file i/o (optional)
			- [y] git (for upload)
			- [y] collections/Maps [like in 12/7 such as maps, lists, sets]
			- [] Design patterns (optional) (Mehrab would-like) such as Singleton, Factory, DAO
			- [y] WORK ON THIS regularly
		*/
		// run the game here
	        
		System.out.println("Welcome to Another Adventure Text Game!");
		System.out.println("You are at your friend's house, in the guest Bedroom.");
		System.out.println("Your friend comes in and asks you to find something.");
		/*
		System.out.println("You are currently at home, in your room.");
		System.out.println("Please enter a number that I'm thinking...below. (Hint: an int between and including 1-5)");    
		Scanner sc = new Scanner(System.in);
	    int initial_input = sc.nextInt();
	    if (initial_input == 1) {
	    	System.out.println("Congrats! You did it.");
	    }
	    else {
	        System.out.println("Ehh, close enough.");
	    } 
	    */

		// instantiate the GAME object
		Game gameObj = new Game();
		
		// prepare random objective
		ArrayList<String> holdAllItems = new ArrayList<String>();
		holdAllItems.addAll(allLivs.checkItemsInRoom());
		holdAllItems.addAll(allKits.checkItemsInRoom());
		holdAllItems.addAll(allBeds.checkItemsInRoom());
		holdAllItems.addAll(allBases.checkItemsInRoom());
		holdAllItems.addAll(allAttics.checkItemsInRoom());
		gameObj.setObjective(holdAllItems);
		
        // game object; contains current state, markers, and direction-related methods
        Scanner gameIn = new Scanner(System.in);

        // run the game! 
        while (gameObj.isPlaying == true && gameObj.checkWinCondition() == false) {
        	System.out.println("---------------------------------------------------------------------------------------");
        	System.out.println("\nPick (type in) a place to explore: Living Room | Kitchen | Bedroom | Basement | Attic");
        	System.out.println("You can also 'search' for items. \nMission Objective: "
        			+ "Find the "+gameObj.getObjective()+".");
        	System.out.println("You're currently in the: "+gameObj.getLocation());
        	/*
        	// input check, filter out all but specific string
        	while( gameIn.nextLine() != null) { // is next user input a string, and satisfies 1/3 room names?
	                
        		System.out.println("Very funny...that's not a string");
        		gameIn.next(); // if not, discard and redo
        	}
        	*/
	        // read in input
        	String requestMove = gameIn.nextLine();

        	// check/verify input + execute
	        if (requestMove.equals("Bedroom") ) {
	        	gameObj.moveBedroom(gameObj.currentRoom);
	        }
	        else if (requestMove.equals("Living Room") ) {
	        	 gameObj.moveLivingRoom(gameObj.currentRoom);
	        }
	        else if (requestMove.equals("Kitchen") ) {
	        	 gameObj.moveKitchen(gameObj.currentRoom);
	         }
	        else if (requestMove.equals("Jump") && gameObj.getLocation().equals("Bedroom") ) {
	        	gameObj.moveOutside(gameObj.currentRoom);
	        	/*gameObj.setWinCondition(true);
	        	//System.out.println("\nCongrats! You...won?");
	        	break; */
	        	gameObj.isPlaying = false;
	        	System.out.println("Mission Failed.");
	        }
	        else if (requestMove.equals("search")) {
	        	
	        	// search
	        	gameObj.searchForItem(gameObj.getObjective(), gameObj.getLocation());
	        	
	        	if (gameObj.checkWinCondition() == true) {
	        		//System.out.println("\nYou found the item!");
	        	}
	        	else {
	        		System.out.println("\nAfter searching around, you find nothing of interest.");
	        	}
	        }
	        else if (requestMove.equals("Basement")) {
	        	gameObj.moveBasement(gameObj.currentRoom);
	        }
	        
	        else if (requestMove.equals("Attic")) {
	        	gameObj.moveAttic(gameObj.currentRoom);
	        }
	        
	        else {
	        	System.out.println("Not a valid move.");
	        }
	            
        }
        
        // close the scanner 
        gameIn.close();
	    
	}
	
}

