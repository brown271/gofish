/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package project;

/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card game. Students wishing to add to the
 * code should remember to add themselves as a modifier.
 *
 * @author megha, 2020
 */
public abstract class Card implements Comparable {

    private Value value;

    /**
     * Default constructor for this Card class, sets the Value to eight.
     */
    public Card() {
        this.value = Value.ACE;

    }

    /**
     * One parameter constructor for this card class, sets the value to whatever
     * is being passed in.
     *
     * @param value
     */
    public Card(Value value) {
        this.value = value;
    }

    /**
     * Returns the value of this Card as its print.
     *
     * @return
     */
    @Override
    public String toString() {
        return (value.getShortName());
    }

    /**
     * Retrieves the value of this enum object.
     *
     * @return the value
     */
    public Value getValue() {
        return value;
    }

    /**
     * Sets the value of this enum object.
     *
     * @param value the value to set
     */
    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public int compareTo(Object o) {
        PlayingCard c = ((PlayingCard) o);
        return (this.getValue().getWorth() - c.getValue().getWorth());
    }

}
