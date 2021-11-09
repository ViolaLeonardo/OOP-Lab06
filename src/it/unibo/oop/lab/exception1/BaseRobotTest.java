package it.unibo.oop.lab.exception1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * Testing class for PositionOutOfBound.
 * 
 */
public final class BaseRobotTest {

    /**
     * Simple test for testing a robot moving, wandering the available
     * environment.
     * 
     */
    @Test
    public void testRobotMovementBase() {
        /*
         * FIRST OF ALL, take a look to "TestWithExceptions". Read the source and the
         * comments very carefully.
         */
        /*
         *  1) Create a Robot with battery level 100
         */
        final Robot r1 = new Robot("SimpleRobot", 100);
        // checking if robot is in position x=0; y=0
        assertEquals("[CHECKING ROBOT INIT POS X]", 0, r1.getEnvironment().getCurrPosX());
        assertEquals("[CHECKING ROBOT INIT POS Y]", 0, r1.getEnvironment().getCurrPosY());
        /*
         * 2) Move the robot right until it touches the world limit
         */
        try {
        	
        	for (int i = 0; i < RobotEnvironment.WORLD_X_UPPER_LIMIT; i++) {
                // check if position if coherent
                r1.moveRight();
            }
        	r1.moveRight();
        	fail("Non è stata lanciata nessuna eccezione");
        	
        }catch(PositionOutOfBoundException e) {
        	assertTrue( e.getMessage().contains("pos(" + (RobotEnvironment.WORLD_X_UPPER_LIMIT + 1) + ", 0)") );
        }catch(NotEnoughBatteryException e) {
        	fail("Non aspettavo eccezioni sulla batteria!!!");
        }
        
        
        /*
         * 2) Move to the top until it reaches the upper right corner of the world
         */
        try {
        	
	        for (int i = 0; i < RobotEnvironment.WORLD_Y_UPPER_LIMIT; i++) {
	            // check if position if coherent
	            r1.moveUp();
	        }
	        r1.moveUp();
	        fail("Non è stata lanciata nessuna eccezione");
	        
        }catch(PositionOutOfBoundException e) {
        	assertNotNull(e.getMessage());
        	System.out.println(e.getMessage());
        	//assertTrue( e.getMessage().contains("pos(" + RobotEnvironment.WORLD_X_UPPER_LIMIT + ", " + (RobotEnvironment.WORLD_Y_UPPER_LIMIT + 1) + ")") );
        }catch(NotEnoughBatteryException e) {
        	fail("Non aspettavo eccezioni sulla batteria!!!");
        }
    }

    /**
     * Simple test for testing robot battery.
     * 
     */
    @Test
    public void testRobotBatteryBase() {
        final Robot r2 = new Robot("SimpleRobot2", 20);
        
        try {
        	/*
	         * Repeatedly move the robot up and down until the battery is completely
	         * exhausted.
	         */
	        while (r2.getBatteryLevel() > 0) {
	            r2.moveUp();
	            r2.moveDown();
	        }
	        // verify battery level:
	        // expected, actual, delta (accepted error as we deal with decimal
	        // values: in this case we accept NO ERROR, which is generally bad)
	        assertEquals(0d, r2.getBatteryLevel(), 0);
	        // verify position: same as start position
	        assertEquals("[CHECKING ROBOT INIT POS Y]", 0, r2.getEnvironment().getCurrPosY());
	        // out of world: returns false
	        r2.moveUp();
	        fail("Eccezione non lanciata!!!");
        }catch(PositionOutOfBoundException e) {
        	fail("Non aspettavo eccezioni sul limite!!!");
        }catch(NotEnoughBatteryException e) {
        	assertNotNull(e.getMessage());
        	System.out.println(e.getMessage());
        }
        
	        
	    // recharge battery
	    r2.recharge();
	    // verify battery level
	    assertEquals(100, r2.getBatteryLevel(), 0);
    }
}
