/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Alexander Brown
 */
public class GoFishPlayer extends Player {

    private GroupOfCards hand = new GroupOfCards(0),
            offHand = new GroupOfCards(0);
    private String name;
    private int books, score;

    public GoFishPlayer(String playerID, int books, int score, String name) {
        super(playerID);
        this.name = name;
        this.books = books;
        this.score = score;
    }

    @Override
    public GoFishPlayer play(ArrayList<Player> players) {
        showCards();
        System.out.println("Which player do you want to take from?");
        System.out.println("Please enter the number before their name!");
        for (int i = 0; i < players.size(); i++) {
            GoFishPlayer player = (GoFishPlayer) players.get(i);
            if (player != this) {
                System.out.println((i) + ": " + player.getName());
            } else {
                System.out.println((i) + ": (YOU!)");
            }
        }
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        int response = Integer.parseInt((in.nextLine()));
        while (response == Integer.parseInt(this.getPlayerID().trim())) {
            System.out.println("Fuck you retard pick someone whos not yourself");
            System.out.println("Which player do you want to take from?");
            System.out.println("Please enter the number before their name!");
            for (int i = 0; i < players.size(); i++) {
                GoFishPlayer player = (GoFishPlayer) players.get(i);
                if (player != this) {
                    System.out.println((i) + ": " + player.getName());
                } else {
                    System.out.println((i) + ": (YOU!)");
                }
            }
            System.out.print("Enter your choice: ");
            response = Integer.parseInt((in.nextLine()));
        }
        while (response < 0 || response > players.size() - 1) {
            System.out.println("Enter a valid number!");
            System.out.println("Which player do you want to take from?");
            System.out.println("Please enter the number before their name!");
            for (int i = 0; i < players.size(); i++) {
                GoFishPlayer player = (GoFishPlayer) players.get(i);
                if (player != this) {
                    System.out.println((i) + ": " + player.getName());
                } else {
                    System.out.println((i) + ": (YOU!)");
                }
            }
            System.out.print("Enter your choice: ");
            response = Integer.parseInt((in.nextLine()));
        }
        System.out.println("Enter which card you want to look for (One, Ace, Jack, etc..)");
        String valueR = in.nextLine();
        boolean valid = false;
        Value value = Value.ACE;

        while (!valid) {
            int i = 0;
            for (Value x : Value.values()) {
                String check = x.getShortName().toLowerCase();
                if (valueR.equalsIgnoreCase(check)) {
                    value = Value.values()[i];
                    valid = true;
                    break;
                }
                i++;
            }
            if (!valid) {
                System.out.println("Enter a correct value!");
                valueR = in.nextLine();
            }

        }

        GoFishPlayer temp = new GoFishPlayer(response + "", 0, 0, "TEMP");
        temp.getHand().getCards().add(new PlayingCard(Suit.CLUBS, value));
        return (temp);
    }

    public void showCards() {
        //printing off the cards in my hand
        for (Card c : hand.getCards()) {
            PlayingCard card = (PlayingCard) c;
            System.out.println(card);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {

            }
        }
        System.out.println(" ");
    }

    /**
     * @return the hand
     */
    public GroupOfCards getHand() {
        return hand;
    }

    /**
     * @param hand the hand to set
     */
    public void setHand(GroupOfCards hand) {
        this.hand = hand;
    }

    /**
     * @return the offHand
     */
    public GroupOfCards getOffHand() {
        return offHand;
    }

    /**
     * @param offHand the offHand to set
     */
    public void setOffHand(GroupOfCards offHand) {
        this.offHand = offHand;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the books
     */
    public int getBooks() {
        return books;
    }

    /**
     * @param books the books to set
     */
    public void setBooks(int books) {
        this.books = books;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }

}
