// This game program is developed by Shivam Srivastava.

package com.GuessingGame;   // Package name

import java.util.Random;    // Random module
import java.util.Scanner;   // Scanner class - It is used for taking input from user.

// Game class - It is a main class
class Game{
    // Game variables
    int winning_no;
    int guess, number,ch;
    // Method for get the secret number
    public Game(){
        Random rand = new Random();
        winning_no = rand.nextInt(100);
    }
    // Method for taking user input
    public void takingUserInput(){
        guess = 1;
        System.out.println("\t \t Lets get started \t \t");
        System.out.println(" WARNING: Number of guesses is only limited to 5 times");
        System.out.print("Guess the Number between 1 and 100: ");
        Scanner input = new Scanner(System.in);
        number = input.nextInt();
    }
    // Game loop
    public void guessing_game(){
        takingUserInput();      // calling takingUserInput method
        // main loop
        while (guess <= 10){
            if (number == winning_no) {
                System.out.println("YOU WIN!!");
                System.out.println("Congratulations! You've guessed the correct number in " + guess + " times.");
                break;
            }
            else{
                if (number < winning_no) {
                    System.out.println("TOO LOW");
                }
                else {
                    System.out.println("TOO HIGH");
                }
                System.out.println(10 - guess + " number of guesses left.");
                guess += 1;
                if (guess <= 10) {
                    System.out.print("Guess Again: ");
                    Scanner againInput = new Scanner(System.in);
                    number = againInput.nextInt();
                }
            }
        }
        if (guess > 10) {
            System.out.println("GAME OVER!! \nBetter luck next time!!");
        }
    }
    // Method for Play Again
    public void playAgain(){
        for (guess=1; guess<=10; guess++){
            System.out.println("1. Play Again for 1 \n2. Quit for 2");
            System.out.print("Play Again   OR  Quit the game : ");
            Scanner againInput = new Scanner(System.in);
            ch = againInput.nextInt();
            if (ch == 1) {
                Random rand = new Random();
                winning_no = rand.nextInt(100);
                guessing_game();
            }
            else if (ch == 2) {
                System.exit(0);
            }
            else {
                System.out.println("Invalid Option!");
            }
        }
    }
}
// Class for calling all the methods of Game Class (main class)
public class GuessingGame {
    public static void main(String[] args) {
        Game game = new Game();      // Creating an instance of Game class
        game.guessing_game();       // Calling guessing_game() method (Game loop method)
        game.playAgain();          // Calling playAgain() method for Play Again the game
    }
}
