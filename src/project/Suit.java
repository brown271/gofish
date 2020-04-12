/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author alex
 */
public enum Suit {
    HEARTS("Hearts"),
    CLUBS("Clubs"),
    SPADES("Spades"),
    DIAMONDS("Diamonds");
    private String shortName;

    private Suit(String shortName) {
        this.shortName = shortName;
    }

    /**
     * Retrieves the short name of this enum.
     *
     * @return the shortName
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * Sets the short name of this enum.
     *
     * @param shortName the shortName to set
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
