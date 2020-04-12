/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Varun
 */
public class GoFishTest {

    public GoFishTest() {
    }

    /**
     * Test of takeCardFromDeck method, of class GoFish.
     */
    @Test
    //1 card in hand, taking 1 card from 2 card deck, and checking for 2 cards in hand
    public void testTakeCardFromDeckGood() {
        System.out.println("takeCardFromDeckGood");
        GoFishPlayer player = new GoFishPlayer("greg", 0, 0, "gregory");
        player.getHand().getCards().add(new PlayingCard());
        GroupOfCards deck = new GroupOfCards(0);
        deck.getCards().add(new PlayingCard());
        deck.getCards().add(new PlayingCard());
        int expResult = 2;
        GoFish fish = new GoFish("grep");
        fish.takeCardFromDeck(1, player, deck);
        int result = player.getHand().getCards().size();
        //assertEquals compares actual result and expected result.
        //If they match, returns true(test passed), otherwise false(test failed)
        assertEquals(true, result == expResult);
    }

    @Test
    //1 card in hand, taking 2 card from 2 card deck, and checking for 2 cards in hand
    public void testTakeCardFromDeckBad() {
        System.out.println("takeCardFromDeckBad");
        GoFishPlayer player = new GoFishPlayer("greg", 0, 0, "gregory");
        player.getHand().getCards().add(new PlayingCard());
        GroupOfCards deck = new GroupOfCards(0);
        deck.getCards().add(new PlayingCard());
        deck.getCards().add(new PlayingCard());
        int expResult = 2;
        GoFish fish = new GoFish("grep");
        fish.takeCardFromDeck(2, player, deck);
        int result = player.getHand().getCards().size();
        //assertEquals compares actual result and expected result.
        //If they match, returns true(test passed), otherwise false(test failed)
        assertEquals(false, result == expResult);
    }

    @Test
    //1 card in hand, taking 1 card from 1 card deck, and checking for 2 cards in hand
    public void testTakeCardFromDeckBoundary() {
        System.out.println("takeCardFromDeckBoundary");
        GoFishPlayer player = new GoFishPlayer("greg", 0, 0, "gregory");
        player.getHand().getCards().add(new PlayingCard());
        GroupOfCards deck = new GroupOfCards(0);
        deck.getCards().add(new PlayingCard());
        int expResult = 2;
        GoFish fish = new GoFish("grep");
        fish.takeCardFromDeck(1, player, deck);
        int result = player.getHand().getCards().size();
        //assertEquals compares actual result and expected result.
        //If they match, returns true(test passed), otherwise false(test failed)
        assertEquals(true, result == expResult);
    }

    /**
     * Test of declareWinner method, of class GoFish.
     */
    @Test
    //deck size is 0, 1 person's books > another's
    public void testDeclareWinnerGood() {
        System.out.println("declareWinnerGood");
        GoFish fish = new GoFish("grep");
        fish.getPlayers().add(new GoFishPlayer("grep", 0, 0, "grepory"));
        fish.getPlayers().add(new GoFishPlayer("greg", 4, 4, "gregory"));
        boolean expResult = true;
        GroupOfCards deck = new GroupOfCards(0);
        //assertEquals compares actual result and expected result.
        //If they match, returns true(test passed), otherwise false(test failed)
        assertEquals(expResult, fish.declareWinner(deck));
    }

    @Test
    //deck size is 1, 1 person's books > another's
    public void testDeclareWinnerBad() {
        System.out.println("declareWinnerBad");
        GoFish fish = new GoFish("grep");
        fish.getPlayers().add(new GoFishPlayer("grep", 0, 0, "grepory"));
        fish.getPlayers().add(new GoFishPlayer("greg", 4, 4, "gregory"));
        boolean expResult = false;
        GroupOfCards deck = new GroupOfCards(0);
        deck.getCards().add(new PlayingCard());
        //assertEquals compares actual result and expected result.
        //If they match, returns true(test passed), otherwise false(test failed)
        assertEquals(expResult, fish.declareWinner(deck));
    }

    @Test
    //deck size is 0, 1 person's books = another's
    public void testDeclareWinnerBoundary() {
        System.out.println("declareWinnerBoundary");
        GoFish fish = new GoFish("grep");
        fish.getPlayers().add(new GoFishPlayer("grep", 0, 0, "grepory"));
        fish.getPlayers().add(new GoFishPlayer("greg", 0, 0, "gregory"));
        boolean expResult = true;
        GroupOfCards deck = new GroupOfCards(0);
        //assertEquals compares actual result and expected result.
        //If they match, returns true(test passed), otherwise false(test failed)
        assertEquals(expResult, fish.declareWinner(deck));
    }

    /**
     * Test of checkForCard method, of class GoFish.
     */
    @Test
    //check for card we know is in hand
    public void testCheckForCardGood() {
        System.out.println("checkForCardGood");
        PlayingCard card1 = new PlayingCard(Suit.CLUBS, Value.ACE);
        GoFish fish = new GoFish("greg");
        GoFishPlayer player = new GoFishPlayer("greg", 0, 0, "gregory");
        player.getHand().getCards().add(card1);
        boolean expResult = true;
        //assertEquals compares actual result and expected result.
        //If they match, returns true(test passed), otherwise false(test failed)
        assertEquals(expResult, fish.checkForCard(card1, player));
    }

    @Test
    //check for card that is not in hand
    public void testCheckForCardBad() {
        System.out.println("checkForCardBad");
        PlayingCard card1 = new PlayingCard(Suit.CLUBS, Value.ACE);
        PlayingCard card2 = new PlayingCard(Suit.HEARTS, Value.EIGHT);
        GoFish fish = new GoFish("greg");
        GoFishPlayer player = new GoFishPlayer("greg", 0, 0, "gregory");
        player.getHand().getCards().add(card1);
        boolean expResult = false;
        //assertEquals compares actual result and expected result.
        //If they match, returns true(test passed), otherwise false(test failed)
        assertEquals(expResult, fish.checkForCard(card2, player));
    }

    @Test
    //check for card we know is in hand with another card
    public void testCheckForCardBoundary() {
        System.out.println("checkForCardBoundary");
        PlayingCard card1 = new PlayingCard(Suit.CLUBS, Value.ACE);
        PlayingCard card2 = new PlayingCard(Suit.HEARTS, Value.EIGHT);
        GoFish fish = new GoFish("greg");
        GoFishPlayer player = new GoFishPlayer("greg", 0, 0, "gregory");
        player.getHand().getCards().add(card1);
        boolean expResult = false;
        //assertEquals compares actual result and expected result.
        //If they match, returns true(test passed), otherwise false(test failed)
        assertEquals(expResult, fish.checkForCard(card1, player));
    }

}
