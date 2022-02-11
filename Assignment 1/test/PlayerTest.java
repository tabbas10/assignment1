package mru.game.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void getName() {
        Player player=new Player("idk",100,0);
        assertEquals("idk",player.getName());
    }

    @Test
    void setName() {
        Player player=new Player("idk",100,0);
        player.setName("toy");
        assertEquals("toy",player.getName());
    }

    @Test
    void getBalance() {
        Player player=new Player("idk",100,0);
        assertEquals(100,player.getBalance());
    }

    @Test
    void setBalance() {
        Player player=new Player("idk",100,0);
        player.setBalance(300);
        assertEquals("idk,300,0",player.toString());
    }

    @Test
    void getNumberOfWins() {
        Player player=new Player("idk",100,0);
        assertEquals(0,player.getNumberOfWins());
    }

    @Test
    void setNumberOfWins() {
        Player player=new Player("idk",100,0);
        player.setNumberOfWins(3);
        assertEquals("idk,100,3",player.toString());
    }

    @Test
    void testToString() {
        Player player=new Player("idk",100,0);
        assertEquals("idk,100,0",player.toString());
    }
}