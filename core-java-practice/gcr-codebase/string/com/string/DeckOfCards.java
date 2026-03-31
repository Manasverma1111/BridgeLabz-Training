package com.string;
import java.util.*;

public class DeckOfCards {
//    function to initialize the deck
    public static String[] initializeDeck() {

        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
        String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

        String[] deck = new String[suits.length * ranks.length];
        int index = 0;

        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }

        return deck;
    }
//    function to shuffle the deck
    public static void shuffleDeck(String[] deck) {

        int n = deck.length;

        for (int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n - i));
            String temp = deck[i];
            deck[i] = deck[r];
            deck[r] = temp;
        }
    }
//    function to distribute the cards among the players
    public static String[][] distributeCards(String[] deck, int players, int cards) {

        if (players * cards > deck.length) {
            return null;
        }

        String[][] result = new String[players][cards];
        int index = 0;

        for (int i = 0; i < players; i++) {
            for (int j = 0; j < cards; j++) {
                result[i][j] = deck[index++];
            }
        }

        return result;
    }
//    function to print the players
    public static void printPlayers(String[][] players) {

        for (int i = 0; i < players.length; i++) {
            System.out.println("Player " + (i + 1));

            for (String card : players[i]) {
                System.out.println(card);
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);
//        get input value for players
        System.out.print("Enter number of players: ");
        int players = sc.nextInt();
//        get input value for cards
        System.out.print("Enter number of cards per player: ");
        int cards = sc.nextInt();
//        function calling and display output
        String[] deck = initializeDeck();
        shuffleDeck(deck);
        String[][] distributedCards = distributeCards(deck, players, cards);

        if (distributedCards == null) {
            System.out.println("Cannot distribute cards");
        } else {
            printPlayers(distributedCards);
        }
    }
}

