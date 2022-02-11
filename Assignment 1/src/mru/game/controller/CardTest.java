package mru.game.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CardTest {

    @Test
    void getRank() {
        Card card=new Card(1,"Clubs");
        Assertions.assertEquals(1,card.getRank());
        Card card1=new Card(7,"Diamond");
        Assertions.assertEquals(7,card1.getRank());
    }

    @Test
    void getSuit() {
        Card card=new Card(1,"Clubs");
        Assertions.assertEquals("Clubs",card.getSuit());
        Card card1=new Card(7,"Diamond");
        Assertions.assertEquals("Diamond",card1.getSuit());
    }


    @Test
    void testToString() {
        Card card=new Card(7,"Diamond");
        Assertions.assertEquals("7 of Diamond",card.toString());
        Card card1=new Card(11,"Diamond");
        Assertions.assertEquals("Jack of Diamond",card1.toString());
    }

    @Test
    void setRank() {
        Card card=new Card(11,"Diamond");
        card.setRank(10);
        Assertions.assertEquals("10 of Diamond",card.toString());
    }

    @Test
    void setSuit() {
        Card card=new Card(11,"Clubs");
        card.setRank(10);
        Assertions.assertEquals("10 of Clubs",card.toString());
    }
}