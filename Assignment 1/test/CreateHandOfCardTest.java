package mru.game.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class CreateHandOfCardTest {

    @Test
    void test(){
        CardDeck cardDeck1=new CardDeck();
        CardDeck cardDeck2=new CardDeck();

        ArrayList<Card> hand1= cardDeck1.getDeck();
        ArrayList<Card> hand2= cardDeck2.getDeck();

        hand1.sort(new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });

        hand2.sort(new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });

        boolean equal=true;

        for (int i = 0; i < hand1.size(); i++) {
            System.out.println(hand1.get(i)+" "+hand2.get(i));
            if(!hand1.get(i).toString().equals(hand2.get(i).toString())){
                equal=false;
            }
        }

        Assertions.assertTrue(equal);
    }

}