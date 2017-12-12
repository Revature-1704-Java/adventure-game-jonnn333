package com.revature.app.adventureGame;

import java.util.ArrayList;

public class Bedroom extends Room {
	Bedroom () { 
	    
        setName("Bedroom");
    
        ArrayList<String> BedroomItems = new ArrayList<String>();
        BedroomItems.add("bed");
        BedroomItems.add("lamp");
        BedroomItems.add("sweater");
        BedroomItems.add("books");
        BedroomItems.add("desk");
        setItemsInRoom(BedroomItems);

        setDescription("A place to sleep!");

        ArrayList<Integer> exitBedroom = new ArrayList<Integer>();
        exitBedroom.add(1);
        exitBedroom.add(2);
        exitBedroom.add(0);
        exitBedroom.add(0);
        setExits(exitBedroom);
        }
}
