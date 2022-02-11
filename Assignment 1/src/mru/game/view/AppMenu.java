package mru.game.view;

import java.util.Scanner;

/**
 * This class will be used to show the menus and sub menus to the user
 * It also prompts the user for the inputs and validates them
 */
public class AppMenu {

    private Scanner scanner;

    public AppMenu() {
        this.scanner =new Scanner(System.in);
    }

    /**
     * Print main menu and take input
     * @return input
     */
    public char menu(){
        System.out.print("Select one of these options:\n" +
                "\n" +
                "\t(P)  Play game\n" +
                "\t(S)  Search\n" +
                "\t(E)  Exit\n" +
                "\n" +
                "Enter a choice:  ");

        char input=scanner.nextLine().toLowerCase().charAt(0);

        while (!(input=='p' || input=='s' || input=='e')){
            System.out.println("\n[Invalid input, try again]\n");

            System.out.print("Select one of these options:\n" +
                    "\n" +
                    "\t(P)  Play game\n" +
                    "\t(S)  Search\n" +
                    "\t(E)  Exit\n" +
                    "\n" +
                    "Enter a choice:  ");

            input=scanner.nextLine().toLowerCase().charAt(0);
        }

        return input;
    }

    /**
     * Print sub menu for search and take input
     * @return input
     */
    public char subMenuForSearch(){
        System.out.print("Select one of these options:\n" +
                "\n" +
                "\t(T)  Top player (Most number of wins)\n" +
                "\t(N)  Looking for a Name\n" +
                "\t(B)  back to main menu\n" +
                "\n" +
                "Enter a choice:  ");

        char input=scanner.nextLine().toLowerCase().charAt(0);

        while (!(input=='t' || input=='n' || input=='b')){
            System.out.println("\n[Invalid input, try again]\n");

            System.out.print("\nSelect one of these options:\n" +
                    "\n" +
                    "\t(T)  Top player (Most number of wins)\n" +
                    "\t(N)  Looking for a Name\n" +
                    "\t(B)  Back to Main menu\n" +
                    "\n" +
                    "Enter a choice:  ");

            input=scanner.nextLine().toLowerCase().charAt(0);
        }

        return input;
    }

    /**
     * Prompt enter to continue
     */
    public void enterToContinue(){
        System.out.print("\nPress enter to continue...");
        scanner.nextLine();
        System.out.println();
    }

    /**
     * Prompt enter name
     * @return name
     */
    public String takeName(){
        System.out.print("\nWhat is your name: ");
        return scanner.nextLine();
    }

    
    /**
     * Print game menu and take input
     * @return input
     */
    public char gameMenu(){
        System.out.print("\nWho do you want to bet on?\n" +
                "\n" +
                "\t(P)  Player Wins\n" +
                "\t(B)  Banker Wins\n" +
                "\t(T)  Tie Game\n" +
                "\n" +
                "Enter your Choice:  ");

        char input=scanner.nextLine().toLowerCase().charAt(0);

        while (!(input=='p' || input=='b' || input=='t')){
            System.out.println("\n[Invalid input, try again]\n");

            System.out.print("\nWho do you want to bet on?\n" +
                    "\n" +
                    "\t(P)  Player Wins\n" +
                    "\t(B)  Banker Wins\n" +
                    "\t(T)  Tie Game\n" +
                    "\n" +
                    "Enter your Choice:  ");

            input=scanner.nextLine().toLowerCase().charAt(0);
        }

        return input;
    }

    /**
     * prompt play again and take input
     * @return input
     */
    public char playAgain(){
        System.out.print("Do you want to play again(Y/N)? ");
        char input=scanner.nextLine().toLowerCase().charAt(0);

        while (!(input=='y' || input=='n')){
            System.out.println("\n[Invalid input, try again]\n");

            System.out.print("Do you want to play again(Y/N)?");

            input=scanner.nextLine().toLowerCase().charAt(0);
        }

        return input;
    }

    /**
     * Take bet amount
     * @return amount
     */
    public int takeBetAmount(){
        System.out.print("How much do you want to bet this round? ");
        return Integer.parseInt(scanner.nextLine());
    }
}
