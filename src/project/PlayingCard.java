/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Alexander Brown
 */
public class PlayingCard extends Card {

    private Suit suit;

    /**
     * Default constructor, sets the PlayingCard to EIGHT of HEARTS.
     */
    public PlayingCard() {
        super();
        this.suit = Suit.HEARTS;
    }

    /**
     * Two parameter constructor, sets the PlayingCard to the suit and value
     * passed into it.
     *
     * @param suit the suit of the PlayingCard
     * @param value the value of the PlayingCard
     */
    public PlayingCard(Suit suit, Value value) {
        super(value);
        this.suit = suit;
    }

    /**
     * Retrieves the suit of the object
     *
     * @return the suit
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Sets the suit of the object.
     *
     * @param suit the suit to set
     */
    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return (super.toString() + " of " + this.suit.getShortName()); //To change body of generated methods, choose Tools | Templates.
    }

}
