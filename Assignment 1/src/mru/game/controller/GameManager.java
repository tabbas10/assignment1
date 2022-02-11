package mru.game.controller;


import mru.game.model.Player;
import mru.game.view.AppMenu;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Main game controller class
 *
 */
public class GameManager {

    private AppMenu appMenu;
    private ArrayList<Player> players;
    

    /**
     * Game starting point 
     */
    public GameManager() {
        appMenu = new AppMenu();
        players = new ArrayList<>();

        loadTxt();

        while (true) {
            char input = appMenu.menu();

            if (input == 'p') {
                String name = appMenu.takeName();
                boolean exist = false;
                Player tmpPlayer = null;
                for (Player player : players) {
                    if (player.getName().equals(name)) {
                        exist = true;
                        tmpPlayer = player;
                    }
                }

                if (exist) {
                    System.out.println("\n*************************************************************************");
                    System.out.printf("***   Welcome back %s     ---    Your balance is: %d $    ***\n", tmpPlayer.getName(), tmpPlayer.getBalance());
                    System.out.println("*************************************************************************");
                } else {
                    Player newPlayer = new Player(name, 100, 0);
                    players.add(newPlayer);
                    tmpPlayer = newPlayer;
                    System.out.println("\n*************************************************************************");
                    System.out.printf("***   Welcome %s     ---    Your initial balance is: %d $      ***\n", tmpPlayer.getName(), tmpPlayer.getBalance());
                    System.out.println("*************************************************************************");
                }

                boolean flag = true;
                while (flag) {
                    input = appMenu.gameMenu();
                    int amount = appMenu.takeBetAmount();
                    while (amount > tmpPlayer.getBalance()) {
                        System.out.println("\n[Amount should be lesser or equal to your balance]\n");
                        amount = appMenu.takeBetAmount();
                    }
                    PuntoBancoGame puntoBancoGame = new PuntoBancoGame();
                    boolean win = false;

                    if (input == 'p') {
                        if (puntoBancoGame.playerTotal() > puntoBancoGame.bankerTotal()) {
                            win = true;
                        } else {
                            win = false;
                        }
                    } else if (input == 'b') {
                        if (puntoBancoGame.playerTotal() < puntoBancoGame.bankerTotal()) {
                            win = true;
                        } else {
                            win = false;
                        }
                    } else {
                        if (puntoBancoGame.playerTotal() == puntoBancoGame.bankerTotal()) {
                            win = true;
                            amount *= 5;
                        } else {
                            win = false;
                        }
                    }

                    if (win) {
                        System.out.println("\n\t\t$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                        System.out.printf("\t\t$      PLAYER WON %-13s$\n", amount + "$");
                        System.out.println("\t\t$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n");
                        tmpPlayer.setBalance(tmpPlayer.getBalance() + amount);
                        tmpPlayer.setNumberOfWins(tmpPlayer.getNumberOfWins() + 1);
                    } else {
                        System.out.println("\n\t\t$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                        System.out.printf("\t\t$      PLAYER LOST %-12s$\n", amount + "$");
                        System.out.println("\t\t$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n");
                        tmpPlayer.setBalance(tmpPlayer.getBalance() - amount);
                    }


                    if (appMenu.playAgain() == 'n') {
                        flag = false;
                    }
                }


            } else if (input == 's') {
                boolean flag = true;
                while (flag) {
                    input = appMenu.subMenuForSearch();
                    if (input == 't') {
                        ArrayList<Player> topPlayers = topPlayers();
                        printTopPlayers(topPlayers);
                        appMenu.enterToContinue();

                    } else if (input == 'n') {
                        ArrayList<Player> searchedPlayer = search(appMenu.takeName());
                        printPlayers(searchedPlayer);
                        appMenu.enterToContinue();

                    } else {
                        flag = false;
                        System.out.println();
                    }
                }


            } else {
                System.out.println("\nSaving...");
                saveTxt();
                System.out.println("Done! Please visit us again!");
                break;
            }
        }


    }

    /**
     * A method to load the text file into an arrayList (if it exists, so you check if the text file exists first)
     */
    private void loadTxt() {
        File file = new File("res\\CasinoInfo.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Scanner reader = new Scanner(new FileReader(file));
                while (reader.hasNextLine()) {
                    String[] info = reader.nextLine().split(",");
                    players.add(new Player(info[0], Integer.parseInt(info[1]), Integer.parseInt(info[2])));
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *  A save method to store the arraylist into the the txt file 
     */
    private void saveTxt() {
        File file = new File("res\\CasinoInfo.txt");
        try {
            PrintWriter printWriter = new PrintWriter(file);
            for (Player player : players) {
                printWriter.println(player);
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * A method to search for a player based their name.
     * 
     * @param key: player name
     * @return a arrayList of players 
     */
    private ArrayList<Player> search(String key) {
        ArrayList<Player> result = new ArrayList<>();
        for (Player player : players) {
            if (player.getName().contains(key)) {
                result.add(player);
            }
        }
        return result;
    }

    /**
     * A method to find the top players.
     * @return a arrayList of players 
     */
    private ArrayList<Player> topPlayers() {
        ArrayList<Player> result = new ArrayList<>();
        int highestWin = 0;
        for (Player player : players) {
            highestWin = Math.max(highestWin, player.getNumberOfWins());
        }

        for (Player player : players) {
            if (player.getNumberOfWins() == highestWin) {
                result.add(player);
            }
        }

        return result;
    }

    /**
     * A method to print top players
     * @param topPlayers list of top players
     */
    private void printTopPlayers(ArrayList<Player> topPlayers) {
        System.out.printf("\n%28s", "- TOP PLAYERS -\n");
        System.out.println("+==================+==================+");
        System.out.println("|NAME              |# WINS            |");
        System.out.println("+==================+==================+");
        for (Player topPlayer : topPlayers) {
            System.out.printf("|%-18s", topPlayer.getName());
            System.out.printf("%s", "|");
            System.out.printf("%-18s", topPlayer.getNumberOfWins());
            System.out.printf("%s\n", "|");
            System.out.println("+------------------+------------------+");
        }
    }

    /**
     * A method to print players
     * @param topPlayers list of players
     */
    private void printPlayers(ArrayList<Player> searchedPlayers) {
        System.out.printf("\n%28s", "- PLAYERS INFO -\n");
        System.out.println("+==================+===============+======================+");
        System.out.println("|NAME              |# WINS         |BALANCE               |");
        System.out.println("+==================+===============+======================+");
        for (Player searchedPlayer : searchedPlayers) {
            System.out.printf("|%-18s", searchedPlayer.getName());
            System.out.printf("%s", "|");
            System.out.printf("%-15s", searchedPlayer.getNumberOfWins());
            System.out.printf("%s", "|");
            System.out.printf("%-22s", searchedPlayer.getBalance());
            System.out.printf("%s\n", "|");
            System.out.println("+------------------+---------------+----------------------+");
        }
    }
}
