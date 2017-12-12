package com.revature.app.adventureGame;


import java.util.ArrayList;

public class Basement extends Room {
	
	Basement () {
		
        setName("Basement");
        
        ArrayList<String> BasementItems = new ArrayList<String>();
        BasementItems.add("old board game collection");
        BasementItems.add("dusty boxes");
        BasementItems.add("family typewriter");
        BasementItems.add("heater");
        BasementItems.add("air conditioner");
        setItemsInRoom(BasementItems);

        setDescription("It's really dark down here, mate.");

        // need to attach basement! 12/9/17
        ArrayList<Integer> exitBasement = new ArrayList<Integer>();
        exitBasement.add(55);
        exitBasement.add(0);
        exitBasement.add(0);
        exitBasement.add(0);
        setExits(exitBasement);
    
	}
	
}
