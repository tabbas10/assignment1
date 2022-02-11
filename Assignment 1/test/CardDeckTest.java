package mru.game.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardDeckTest {

    @Test
    void createNewDeck(){
        try {
            CardDeck cardDeck=new CardDeck();
        }catch (Exception e){
            fail();
        }
    }

    @Test
    void shuffleTest(){
        CardDeck cardDeck=new CardDeck();
        CardDeck cardDeck1=new CardDeck();

        boolean equal=true;

        for (int i = 0; i < cardDeck.getDeck().size(); i++) {
            if(!cardDeck.getDeck().get(i).toString().equals(cardDeck1.getDeck().get(i).toString())){
                equal=false;
            }
        }

        assertFalse(equal);
    }

    @Test
    void getDeck() {
        CardDeck cardDeck=new CardDeck();
        assertEquals(cardDeck.getDeck().size(),52);
    }
}