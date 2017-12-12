package com.revature.app.adventureGame;

import java.util.ArrayList;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    // real tests start here!

    // if instantiated child class of Room, Bedroom, correctly prints its initialized description
	public void testPrintBedroomDescription() {
		Bedroom testBed = new Bedroom();
		
		Assert.assertEquals(testBed.getName(), "Bedroom");
	}
	
	// if Game is instantiated, room location should be set to Bedroom (by default)
	public void testStartRoom() {
		Game testGame = new Game();
		Assert.assertEquals(testGame.getLocation(), "Bedroom");
	}
	
	// check if objective is really randomized 
	public void testObjectiveGenerator() {
		
		// two separate game objects, instantiated
		Game testGame = new Game();
		Game testGame_dup = new Game();
		
		// all rooms, instantiated
		LivingRoom liv = new LivingRoom();
		Kitchen kit = new Kitchen();
		Bedroom bed = new Bedroom();
		Basement basem = new Basement();
		Attic attic = new Attic();
		
		// arraylists for each Game object
		ArrayList<String> gameItems = new ArrayList<String>();
		ArrayList<String> gameItems_dup = new ArrayList<String>();
		
		// adding all elements
		gameItems.addAll(liv.checkItemsInRoom());
		gameItems.addAll(kit.checkItemsInRoom());
		gameItems.addAll(bed.checkItemsInRoom());
		gameItems.addAll(basem.checkItemsInRoom());
		gameItems.addAll(attic.checkItemsInRoom());
		gameItems_dup.addAll(liv.checkItemsInRoom());
		gameItems_dup.addAll(kit.checkItemsInRoom());
		gameItems_dup.addAll(bed.checkItemsInRoom());
		gameItems_dup.addAll(basem.checkItemsInRoom());
		gameItems_dup.addAll(attic.checkItemsInRoom());
		
		// set objective
		testGame.setObjective(gameItems);
		testGame_dup.setObjective(gameItems_dup);
		
		// hold a copy of the original objective as a new Object in String Pool
		String objectiveOrig = testGame.getObjective();
		String objectiveCopy = testGame_dup.getObjective();
		
		// while FIRST objective is equal to the objective returned by the "Objective" getter
		// get new objective
		while (objectiveOrig.equals(objectiveCopy)) {
			testGame.setObjective(gameItems);
			objectiveOrig = testGame.getObjective();
		}
		
		// test to see if they're not equal
		if (!objectiveOrig.equals(objectiveCopy)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertFalse(false);
		}
		
		
	}
}
