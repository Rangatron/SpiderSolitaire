/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spidersolitaire;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alex Winterton
 */
public class TableTest {
    
    public TableTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getDeck method, of class Table.
     */
    @Test
    public void testGetDeck() {
        System.out.println("getDeck");
        Table instance = new Table();
        Deck expResult = null;
        Deck result = instance.getDeck();
        assertNotEquals(expResult, result);
    }

    /**
     * Test of getPile method, of class Table.
     */
    @Test
    public void testGetPile() {
        System.out.println("getPile");
        Table instance = new Table();
        int expResult = 0;
        int result = instance.getPile();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of revealCard method, of class Table.
     */
    @Test
    public void testRevealCard() {
        System.out.println("revealCard");
        int x = 0;
        int y = 0;
        Table instance = new Table();
        instance.revealCard(x, y);
        if(instance.getTable().get(x).get(y).getCard().get(0) == 0)
        {
            fail();
        }
        if(instance.getTable().get(x).get(y).getCard().get(1) == 0)
        {
            fail();
        }
        //fail("The test case is a prototype.");
    }   
}
