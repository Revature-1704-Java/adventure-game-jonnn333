package com.revature.app.adventureGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Room {

    String name;
    ArrayList<String> inRoom = new ArrayList<String>();
    String roomDescription; 
    ArrayList<Integer> exits = new ArrayList<Integer>(); 
    
    Map<Integer, String> improvedExitList = new HashMap<Integer, String>();

    // constructor
    Room () {

    }

    String getName () {
        return this.name;
    }
    String setName (String name) {
        return this.name = name;
    }

    String getDescription() {
        return this.roomDescription;    
    }
    void setDescription(String description) {
        this.roomDescription = description;
    }

    void setItemsInRoom (ArrayList<String> itemsToAdd) {
        for (int itr = 0; itr < itemsToAdd.size(); itr++) {
            inRoom.add(itemsToAdd.get(itr));
        }
    }
    
    ArrayList<String> checkItemsInRoom () {
        return this.inRoom;
    }
    
    void setExits (ArrayList<Integer> newExits) {
        
        if (newExits.size() < 4) {
            System.out.println("Hey, WAIT - there's no exit! :O");
        }
        else {
           this.exits = newExits;
        }
    }
    
    ArrayList<Integer> getExits () {
        return this.exits;
    }
    
    // adding new data structure
    void setExitsImproved (Map<Integer,String> newExits) {
    	if (newExits.size() < 4) {
    		System.out.println("Hey, WAIT - there's not enough exits! :O");
    	}
    	else {
    		this.improvedExitList = newExits;
    	}
    }
    
    
}
