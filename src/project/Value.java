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
public enum Value {
    ACE("Ace", 1),
    TWO("Two", 2),
    THREE("Three", 3),
    FOUR("Four", 4),
    FIVE("Five", 5),
    SIX("Six", 6),
    SEVEN("Seven", 7),
    EIGHT("Eight", 8),
    NINE("Nine", 9),
    TEN("Ten", 10),
    JACK("Jack", 11),
    QUEEN("Queen", 12),
    KING("King", 13);

    private String shortName;
    private int worth;

    private Value(String shortName, int worth) {
        this.shortName = shortName;
        this.worth = worth;
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

    /**
     * @return the worth
     */
    public int getWorth() {
        return worth;
    }

    /**
     * @param worth the worth to set
     */
    public void setWorth(int worth) {
        this.worth = worth;
    }

}
