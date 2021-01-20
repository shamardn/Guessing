package com.company;

import java.util.Scanner;

public class Game {

    private String movieToGuess;
    private int pointsLost;
    private String wrongLetters;
    private String rightLetters;
    private boolean gameWon;

    public Game(String pathName){
        MovieList movieList = new MovieList(pathName);
        movieToGuess = movieList.getRandomMovie().trim();
        pointsLost = 0 ;
        wrongLetters = "";
        rightLetters = "";
        gameWon = false;

    }

    public String getMovieTitle(){
        return movieToGuess;
    }


    public String getHiddenMovieTitle(){
        if (rightLetters.equals("")){
            return movieToGuess.replaceAll("[a-zA-Z]","_");
        }
        else {
            return movieToGuess.replaceAll("[a-zA-Z&&[^" + rightLetters + "]]","_");
        }
    }

    public String getWrongLetters(){
        return wrongLetters;
    }

    public boolean WonGame(){
        return gameWon;
    }

    public boolean gameEnded(){
        if (pointsLost >= 10){
            return true;
        }
        if (!(getHiddenMovieTitle().contains("_"))){
            gameWon = true;
            return true;
        }
        return false;
    }

    public String inputLetter(){

        System.out.println("Guess a letter:");
        Scanner scanner = new Scanner(System.in);
        String letter = scanner.nextLine().toLowerCase();

        if (!letter.matches("a-z")){
            System.out.println("Enter a valid letter.");
            return inputLetter();
        }
        else if (rightLetters.contains(letter) || wrongLetters.contains(letter)){
            System.out.println("You already guessed that letter.");
            return inputLetter();
        }
        return letter;
    }

    public void guessLetter(){
        String guessedLetter = inputLetter();
        if (movieToGuess.toLowerCase().contains(guessedLetter)){
            rightLetters += " " + guessedLetter +guessedLetter.toUpperCase();
        }
        else {
            pointsLost++;
            wrongLetters += " " + guessedLetter;
        }
    }

}
