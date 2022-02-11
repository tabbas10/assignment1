package mru.game.controller;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This class is an implementation of the game.
 *
 */
public class PuntoBancoGame {

    private ArrayList<Card> playerCards;
    private ArrayList<Card> bankerCards;
    private Queue<Card> cards;

    /**
     * Default constructor
     */
    public PuntoBancoGame() {
        this.playerCards = new ArrayList<>();
        this.bankerCards = new ArrayList<>();
        cards = new LinkedList<>(new CardDeck().getDeck());

        playerDraw();
        playerDraw();

        bankerDraw();
        bankerDraw();

        if (playerTotal() > 7 || bankerTotal() > 7) {

        } else {
            if (playerTotal() <= 5) {
                playerDraw();
                Card thirdCard = playerCards.get(2);
                if ((thirdCard.getRank() == 2 || thirdCard.getRank() == 3) && (bankerTotal() <= 4)) {
                    bankerDraw();
                } else if ((thirdCard.getRank() == 4 || thirdCard.getRank() == 5) && (bankerTotal() <= 5)) {
                    bankerDraw();
                } else if ((thirdCard.getRank() == 6 || thirdCard.getRank() == 7) && (bankerTotal() <= 6)) {
                    bankerDraw();
                } else if ((thirdCard.getRank() == 8) && (bankerTotal() <= 2)) {
                    bankerDraw();
                } else if ((thirdCard.getRank() == 1 || thirdCard.getRank() >= 9) && (bankerTotal() <= 3)) {
                    bankerDraw();
                }

            } else {
                if (bankerTotal() <= 5) {
                    bankerDraw();
                }
            }
        }

        printGame();
    }

    /**
     * Calculate total point of player 
     * @return total point of player
     */
    public int playerTotal() {
        int total = 0;
        for (Card playerCard : playerCards) {
            if (playerCard.getRank() < 10) {
                total += playerCard.getRank();
            }
        }

        return total % 10;
    }

    /**
     * Calculate total point of banker 
     * @return total point of banker
     */
    public int bankerTotal() {
        int total = 0;
        for (Card bankerCard : bankerCards) {
            if (bankerCard.getRank() < 10) {
                total += bankerCard.getRank();
            }
        }

        return total % 10;
    }

    /**
     * A method to banker draw a card
     */
    private void bankerDraw() {
        bankerCards.add(cards.poll());
    }

    /**
     * A method to player draw a card
     */
    private void playerDraw() {
        playerCards.add(cards.poll());
    }

    /**
     * Getter method for player cards
     * @return player cards
     */
    public ArrayList<Card> getPlayerCards() {
        return playerCards;
    }

    /**
     * Getter method for banker cards
     * @return banker cards
     */
    public ArrayList<Card> getBankerCards() {
        return bankerCards;
    }

    /**
     * A method to print the game
     */
    private void printGame() {
        System.out.println("\n               - PUNTO BANCO -");
        System.out.println("+=======================+=======================+");
        System.out.println("||PLAYER                |BANKER                ||");
        System.out.println("+=======================+=======================+");
        for (int i = 0; i < 3; i++) {
            System.out.printf("| %-22s| %-22s|\n",
                    (i < playerCards.size() ? playerCards.get(i) : ""),
                    (i < bankerCards.size() ? bankerCards.get(i) : ""));
            System.out.println("+-----------------------+-----------------------+");
        }
        System.out.printf("|PLAYER POINTS: %d       |BANKER POINTS: %d       |\n",
                playerTotal(),
                bankerTotal());
        System.out.println("+=======================+=======================+");

    }
}
