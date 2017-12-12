package com.revature.app.adventureGame;

import java.util.ArrayList;

public class Kitchen extends Room {
	Kitchen () {

        setName("Kitchen");
    
        ArrayList<String> KitchenItems = new ArrayList<String>();
        KitchenItems.add("tv");
        KitchenItems.add("coffee table");
        KitchenItems.add("fern");
        KitchenItems.add("sofa");
        KitchenItems.add("ceiling fan");
        setItemsInRoom(KitchenItems);

        setDescription("WTF = Where's the Food?");

        ArrayList<Integer> exitKitchen = new ArrayList<Integer>();
        exitKitchen.add(0);
        exitKitchen.add(0);
        exitKitchen.add(3);
        exitKitchen.add(55);
        setExits(exitKitchen);
    }
}
