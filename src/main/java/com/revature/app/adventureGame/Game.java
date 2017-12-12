package com.revature.app.adventureGame;

import java.util.ArrayList;

public class Game {
	String objective;
    String currentRoom;
    String nextRoom;
    boolean isValidMove;

    // variables that help game running until you win/lose
    boolean isPlaying = true;
    boolean hasWon = false;

    Game () {
        setLocation("Bedroom");
    }

    // 1 is outside (from Bedroom)
    // 2 is between Living and Bedroom only
    // 3 is between Living and Kitchen only
    boolean moveLivingRoom (String curr) {

    	
        // from bed to living
        if (Adventure.allBeds.getExits().contains(2) && curr.equals(Adventure.allBeds.getName())) {
            System.out.println("You move from the Bedroom to the Livng Room");
            setLocation("Living Room");
            System.out.println(Adventure.allLivs.getDescription());
            return true;  
        }
        // from kitchen to living
        else if (Adventure.allKits.getExits().contains(3) && curr.equals(Adventure.allKits.getName())){
            System.out.println("You move from the Kitchen to the Living Room");
            setLocation("Living Room");
            System.out.println(Adventure.allLivs.getDescription());
            return true;
        }
        // from attic to livng room
        else if (Adventure.allAttics.getExits().contains(45) && curr.equals(Adventure.allAttics.getName())) {
        	System.out.println("You move from the Attic to the Living Room");
        	setLocation("Living Room");
        	System.out.println(Adventure.allLivs.getDescription());
        	return true;
        }
        else {
            System.out.println("Nah, you can't move into the Living Room like that. Try Again.");
            return false;
        }
    }
    
    boolean moveKitchen (String curr) { 
        
    	// from living to kitchen
        if (Adventure.allLivs.getExits().contains(3) && curr.equals(Adventure.allLivs.getName())) {
            System.out.println("You move from the Living Room to the Kitchen");
            setLocation("Kitchen");
            System.out.println(Adventure.allKits.getDescription());
            return true;
        }
        // from basement to kitchen
        else if (Adventure.allBases.getExits().contains(55) && curr.equals(Adventure.allBases.getName())) {
        	System.out.println("You move from the Basement to the Kitchen");
        	setLocation("Kitchen");
        	System.out.println(Adventure.allKits.getDescription());
        	return true;
        }
        else {
            System.out.println("Nah, you can't move into the Kitchen like that. Try again.");
            return false;
        }
    }
    boolean moveBedroom (String curr) {
        
    	// living room to bedroom
        if (Adventure.allLivs.getExits().contains(2) && curr.equals(Adventure.allLivs.getName())) {
            System.out.println("You move from the Living Room to your bedroom");
            setLocation("Bedroom");
            System.out.println(Adventure.allBeds.getDescription());
            return true;
        }
        else {
            System.out.println("Nah, you can't move into the Bedroom like that. Try again.");
            return false;
        }
    }
    
    boolean moveOutside (String curr) {
        
        if (Adventure.allBeds.getExits().contains(1) && curr.equals(Adventure.allBeds.getName())) {
        	System.out.println("You try to leave the Bedroom. You unfortunately slip " +
        			"on the carpet \nand accidentally perform a somersault through the nearest window.");
        	return true;
        }
        return false;
    }
    
    boolean moveBasement (String curr) {
    	
    	// from kitchen to basement
    	if (Adventure.allKits.getExits().contains(55) && curr.equals(Adventure.allKits.getName())) {
            System.out.println("You move from the Living Room to your bedroom");
            setLocation("Basement");
            System.out.println(Adventure.allBases.getDescription());
            return true;
        }
    	System.out.println("Nah, you can't move into the Basement like that. Try again.");
    	return false;
    }
    
    boolean moveAttic (String curr) {
    	// from living room to attic
    	if (Adventure.allLivs.getExits().contains(45) && curr.equals(Adventure.allLivs.getName())) {
            System.out.println("You move from the Living Room to the Attic");
            setLocation("Attic");
            System.out.println(Adventure.allAttics.getDescription());
            return true;
        }
    	System.out.println("Nah, you can't move into the Attic like that. Try again.");
    	return false;
    }

    String getLocation () {
        return this.currentRoom;
    }
    void setLocation (String newLoc) {
        this.currentRoom = newLoc;
    }

    boolean checkValidMove (String nextRoom) {
        return true; // placeholder
    }
    void setValidMove (String nextRoom, boolean tf) {
        this.isValidMove = tf;
    }
    
    void setWinCondition(boolean win) {
    	this.hasWon = win;
    }
    boolean checkWinCondition() {
    	return this.hasWon;
    }
    
    String getObjective() {
    	if (this.objective == null) {
    		return "ERROR. Blame the programmer.";
    	}
    	return this.objective;
    }
    
    void setObjective(ArrayList<String> listToChooseFrom) {
    	// randomizing! +12/9/17 
    	double rng = Math.random();
    	int indexLimit = listToChooseFrom.size()-1;
        int randomIndex = (int) (rng * indexLimit);
        //System.out.println("indexLimit is "+indexLimit+" and randomIndex is "+randomIndex);
        
    	this.objective = listToChooseFrom.get(randomIndex);
    }

    String searchForItem (String instruction, String currLoc) {
        
        String theItem;
        
        if (Adventure.allBeds.getName().equals(currLoc)) {
        	theItem = doSearch(Adventure.allBeds.checkItemsInRoom(), instruction);
        	return theItem;
        }
    	
        else if (Adventure.allKits.getName().equals(currLoc)) {
        	theItem = doSearch(Adventure.allKits.checkItemsInRoom(), instruction);
    		return theItem;
    	}
        
        else if (Adventure.allLivs.getName().equals(currLoc)) {
        	theItem = doSearch(Adventure.allLivs.checkItemsInRoom(), instruction);
        	return theItem;
        }
        
        else if (Adventure.allBases.getName().equals(currLoc)) {
        	theItem = doSearch(Adventure.allBases.checkItemsInRoom(), instruction);
        	return theItem;
        }
        
        else if (Adventure.allAttics.getName().equals(currLoc)) {
        	theItem = doSearch(Adventure.allAttics.checkItemsInRoom(), instruction);
        	return theItem;
        }
        return "not found";
        
    }
    
    private String doSearch (ArrayList<String> arrL, String instruct) {
    	
        // random number gen for probability of retrieving item given arrayList passed through
        //double rng = Math.random();
        //int indexLim = arrL.size()-1;
        //int randomInd = (int) (rng*indexLim);
        //System.out.println("\nDoSearch Index Max is: "+indexLim+" and randomIndex is: "+randomInd);
        
        // assigning probability that you reach an index (using a bunch of if-else statements
        // and manually-input probability chances...[removed for better method ABOVE]
        
        try {
        	// retrieve item of itemLimit's index (0-4 because 5 elements and start-from-zero indexing)
        	for (String findItem : arrL) {
        		if (arrL.contains(findItem) && findItem.equals(instruct)) {
        			System.out.println("WOOHOO! You found the "+findItem+"!");
        			System.out.println("Mission Complete.");
            		setWinCondition(true);
            		return findItem;
        		}
        	}
        	/*
        	if (arrL.get(randomInd).equals(instruct)) {
        		System.out.println("HOORAY! You found the "+arrL.get(randomInd)+"!");
        		setWinCondition(true);
        		return arrL.get(randomInd);
        	}	*/
        } catch (IndexOutOfBoundsException ex) {
        	ex.getMessage();
        }
    	
    	return "not found";
    }
}
