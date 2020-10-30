// This game program is developed by Shivam Srivastava.

package com.GuessingGame;

import java.util.Random;
import java.util.Scanner;

class Game{
    int winning_no;
    int guess, number,ch;
    public Game(){
        Random rand = new Random();
        winning_no = rand.nextInt(100);
    }
    public void takingUserInput(){
        guess = 1;
        System.out.println("\t \t Lets get started \t \t");
        System.out.println(" WARNING: Number of guesses is only limited to 5 times");
        System.out.print("Guess the Number between 1 and 100: ");
        Scanner input = new Scanner(System.in);
        number = input.nextInt();
    }

    public void guessing_game(){
        takingUserInput();
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

    public void playAgain(){
        for (guess=1; guess<=10; guess++){
            System.out.println("1. Play Again for 1 \n2. Quit for 2");
            System.out.print("Play Again   OR  Quit the game : ");
            Scanner againInput = new Scanner(System.in);
            ch = againInput.nextInt();
            switch (ch){
                case 1: {
                    Random rand = new Random();
                    winning_no = rand.nextInt(100);
                    guessing_game();
                    break;
                }
                case 2: {
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Invalid Option!");
                }
            }
        }
    }
}

public class GuessingGame {
    public static void main(String[] args) {
        Game game = new Game();
        game.guessing_game();
        game.playAgain();
    }
}