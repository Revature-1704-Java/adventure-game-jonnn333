package com.revature.app.adventureGame;

import java.util.ArrayList;


public class Attic extends Room {
	
	Attic () {
		
        setName("Attic");
        
        ArrayList<String> AtticItems = new ArrayList<String>();
        AtticItems.add("family photo albums");
        AtticItems.add("unused bitcoin server");
        AtticItems.add("tie-die shirt from art class");
        AtticItems.add("Jason Bourne: The Trilogy DVD Set");
        AtticItems.add("Frankenstein");
        setItemsInRoom(AtticItems);

        setDescription("There aren't any ghosts lurking around here, right?");

        // need to attach attic! 12/9/17
        ArrayList<Integer> exitAttic = new ArrayList<Integer>();
        exitAttic.add(0);
        exitAttic.add(45);
        exitAttic.add(0);
        exitAttic.add(0);
        setExits(exitAttic);
    
	}
}
