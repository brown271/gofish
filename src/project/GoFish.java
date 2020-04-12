/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Alexander Brown
 */
public class GoFish extends Game {

    private GroupOfCards deck = new GroupOfCards(0);

    public GoFish(String givenName) {
        super(givenName);
    }

    @Override
    public void play() {
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 13; j++) {
                deck.getCards().add(new PlayingCard(Suit.values()[i], Value.values()[j]));
            }
        }
        Scanner in = new Scanner(System.in);
        System.out.print("How many player do you want to play?(2-5): ");
        int numPlayers = Integer.parseInt((in.nextLine()));
        while (numPlayers < 2 && numPlayers > 5) {
            System.out.print("Please enter a number between 2 and 5: ");
            numPlayers = Integer.parseInt((in.nextLine()));
        }
        for (int i = 0; i < numPlayers; i++) {
            String id = i + "";
            System.out.print("Please enter a name for player " + (i + 1) + ": ");
            String name = in.nextLine();
            GoFishPlayer player = new GoFishPlayer(id, 0, 0, name);
            super.getPlayers().add(player);
        }
        dealDeck();
        while (!declareWinner(deck)) {
            for (Player player : super.getPlayers()) {
                System.out.println("");
                GoFishPlayer curPlayer = (GoFishPlayer) player;
                Collections.sort(curPlayer.getHand().getCards());
                checkFours();
                System.out.println(curPlayer.getName() + "'s turn!");

                GoFishPlayer temp = player.play(super.getPlayers());
                for (Player targets : super.getPlayers()) {
                    if (targets.getPlayerID().equals(temp.getPlayerID())) {
                        GoFishPlayer target = (GoFishPlayer) targets;
                        GroupOfCards tempCards = new GroupOfCards(0);
                        boolean fish = true;
                        for (Card card : target.getHand().getCards()) {
                            tempCards.getCards().add(card);
                            if (card.getValue() == temp.getHand().getCards().get(0).getValue()) {
                                fish = false;
                                System.out.println(curPlayer.getName() + " Stole a " + card);
                                try {
                                    Thread.sleep(1500);
                                } catch (InterruptedException ex) {

                                }

                                curPlayer.getHand().getCards().add(card);
                                tempCards.getCards().remove(card);
                            }
                        }
                        if (fish) {
                            System.out.println(target.getName() + ": Go FISH!");
                            takeCardFromDeck(1, curPlayer, deck);
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException ex) {

                            }
                        } else {
                            target.setHand(tempCards);
                        }

                    }

                }
                checkFours();
            }
        }
    }

    public boolean checkForCard(Card card, GoFishPlayer player) {
        for (Card x : player.getHand().getCards()) {
            if (x.getValue() == card.getValue()) {

                return true;
            }

        }
        return false;
    }

    public void dealDeck() {
        int size = 0;
        if (super.getPlayers().size() == 2 || super.getPlayers().size() == 3) {
            size = 7;

        } else if (super.getPlayers().size() == 4
                || super.getPlayers().size() == 5) {
            size = 5;
        }
        deck.shuffle();

        for (Player ply : super.getPlayers()) {
            GoFishPlayer player = (GoFishPlayer) ply;
            takeCardFromDeck(size, player, deck);
        }
    }

    @Override
    public boolean declareWinner(GroupOfCards deck) {
        if (deck.getCards().size() == 0) {
            int highscore = 0;
            GoFishPlayer winner = new GoFishPlayer("Alex", 0, 0, "Alex");
            for (Player player : super.getPlayers()) {
                GoFishPlayer x = (GoFishPlayer) player;
                int score = x.getScore();
                if (highscore < score) {
                    highscore = score;
                    winner = (GoFishPlayer) player;
                }
            }
            System.out.println("the winner is" + (GoFishPlayer) winner + "the score is" + highscore);
            return true;

        }
        return false;

    }

    /**
     * @return the deck
     */
    public GroupOfCards getDeck() {
        return deck;
    }

    /**
     * @param deck the deck to set
     */
    public void setDeck(GroupOfCards deck) {
        this.deck = deck;
    }

    public void checkFours() {
        //check for books and add them up
        for (int i = 0; i < super.getPlayers().size(); i++) {
            int[] check = new int[13]; //possible point of error
            GoFishPlayer checker = (GoFishPlayer) super.getPlayers().get(i);
            for (int j = 0; j < checker.getHand().getCards().size(); j++) {
                check[checker.getHand().getCards().get(j).getValue().getWorth() - 1]++;
            }
            for (int j = 0; j < 13; j++) {
                if (check[j] == 4) {
                    System.out.println(checker.getName() + " had all 4 " + Value.values()[j].getShortName() + "'s now they have another point!");
                    GroupOfCards temp = new GroupOfCards(0);
                    for (int k = 0; k < checker.getHand().getCards().size(); k++) {
                        temp.getCards().add(checker.getHand().getCards().get(k));

                        if (checker.getHand().getCards().get(k).getValue().getWorth() == (j + 1)) {

                            Card c = checker.getHand().getCards().get(k);
                            checker.getOffHand().getCards().add(c);
                            temp.getCards().remove(c);
                            checker.setBooks(checker.getBooks() + 1);
                        }
                    }
                    checker.setHand(temp);

                }

            }

        }
    }

    public void takeCardFromDeck(int cards, GoFishPlayer curPlayer, GroupOfCards deck) {
        for (int i = 0; i < cards; i++) {
            Random rand = new Random();
            int x = rand.nextInt(deck.getCards().size());
            curPlayer.getHand().getCards().add(deck.getCards().get(x));
            deck.getCards().remove(x);
        }
    }
}
