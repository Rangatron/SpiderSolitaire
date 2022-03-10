/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spidersolitaire;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
/**
 *
 * @author Alex Winterton
 */
public class DeckTest {
    
    public DeckTest() {
        
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of shuffleDeck method, of class Deck.
     */
    @Test
    public void testShuffleDeck() {
        System.out.println("shuffleDeck");
        Deck instance = new Deck();
        Deck expected = new Deck();
        instance.shuffleDeck();
        assertNotSame(expected.getDeck().get(0), instance.getDeck().get(0));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
