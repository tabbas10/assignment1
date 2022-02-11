package mru.game.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PuntoBancoGameTest {

    @Test
    void addCardsAndRetrieve(){
        try{
            PuntoBancoGame puntoBancoGame=new PuntoBancoGame();
            for (Card bankerCard : puntoBancoGame.getBankerCards()) {
                System.out.println(bankerCard);
            }

            for (Card playerCard : puntoBancoGame.getPlayerCards()) {
                System.out.println(playerCard);
            }
        }catch (Exception e){
            fail();
        }


    }

    @Test
    void playerTotal() {
        PuntoBancoGame puntoBancoGame=new PuntoBancoGame();
        assertTrue(puntoBancoGame.playerTotal()<10);
    }

    @Test
    void bankerTotal() {
        PuntoBancoGame puntoBancoGame=new PuntoBancoGame();
        assertTrue(puntoBancoGame.bankerTotal()<10);
    }

    @Test
    void getPlayerCards() {
        try {
            PuntoBancoGame puntoBancoGame=new PuntoBancoGame();
            for (Card playerCard : puntoBancoGame.getPlayerCards()) {
                System.out.println(playerCard);
            }
        }catch (Exception e){
            fail();
        }
    }

    @Test
    void getBankerCards() {
        try {
            PuntoBancoGame puntoBancoGame=new PuntoBancoGame();
            for (Card bankerCard : puntoBancoGame.getBankerCards()) {
                System.out.println(bankerCard);
            }

        }catch (Exception e){
            fail();
        }
    }
}