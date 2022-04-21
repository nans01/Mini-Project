package com.company;

import java.util.Scanner;

public class MorseConverter {

    public static void main(String[] args) {
        String morse[] = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..",
                "--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..",
                "|",".---","..---","...--","....-",".....","-....","--...","---..","----.","-----"};
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ 1234567890";

        Scanner input = new Scanner(System.in);
        System.out.print("Is your phrase in Morse Code or English? Enter 'morse' for Morse Code and 'english' for English\n");
        String userInput = input.nextLine();


        if( userInput.equalsIgnoreCase("morse") )
            morseToEnglish(alphabet, morse);
        else if( userInput.equalsIgnoreCase("english") )
            englishToMorse(alphabet, morse);
        else
            System.out.println("Your entry is invalid");
    }

    public static void englishToMorse(String alphabet, String morse[])
    {
        System.out.println("Enter your english phrase.");
        Scanner phraseInput = new Scanner(System.in);
        String phrase = phraseInput.nextLine();
        phrase = phrase.toUpperCase();

        for( int i = 0; i < phrase.length(); i++ )
        {
            if( phrase.charAt(i) == ' ' )
            {
                System.out.print("| ");
                continue;
            }

            for( int j = 0; j < alphabet.length(); j++ )
            {
                if( alphabet.charAt(j) == phrase.charAt(i) )
                {
                    System.out.print( morse[j] + " " );
                    break;
                }
            }
        }
    }


    public static void morseToEnglish(String alphabet, String morse[])
    {
        System.out.println("Enter a phrase in morse code.");
        Scanner morseInput = new Scanner(System.in);
        String morseCode = morseInput.nextLine();

        if (!isMorseCode(morseCode)) {
            System.out.print("This was not morse code.");
        }

        String[] splitMorse = morseCode.split(" ");


        for( int i = 0; i < splitMorse.length; i++ )
        {
            for( int j = 0; j < morse.length; j++ )
            {
                if ( morse[j].equals(splitMorse[i]) )
                    System.out.print( Character.toLowerCase(alphabet.charAt(j)) );

            }
        }
    }

    public static boolean isMorseCode( String code ){
        return code.trim().matches(
                "[.-]{1,5}(?> [.-]{1,5})*(?>   [.-]{1,5}(?> [.-]{1,5})*)*");
    }
}
