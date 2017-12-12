package com.revature.app.adventureGame;

import java.util.ArrayList;

public class LivingRoom extends Room {
	LivingRoom () {

        setName("Living Room");
    
        ArrayList<String> LivingRoomItems = new ArrayList<String>();
        LivingRoomItems.add("tv");
        LivingRoomItems.add("coffee table");
        LivingRoomItems.add("fern");
        LivingRoomItems.add("sofa");
        LivingRoomItems.add("ceiling fan");
        setItemsInRoom(LivingRoomItems);

        setDescription("A room in which we live. - Drake");

        ArrayList<Integer> exitLiving = new ArrayList<Integer>();
        exitLiving.add(0);
        exitLiving.add(2);
        exitLiving.add(3);
        exitLiving.add(45);
        setExits(exitLiving);
    }
}