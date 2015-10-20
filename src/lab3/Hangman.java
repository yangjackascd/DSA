package lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Hangman {
    
    private static WordList load(String fileName) {
        WordList wordList = null;
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            int size = Integer.parseInt(scanner.nextLine());
            wordList = new WordList(size);
            while(scanner.hasNextLine()) {
                wordList.add(scanner.nextLine());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Hangman.class.getName()).log(Level.SEVERE, null, ex);
        }
        return wordList;
    }
    
    private static boolean play(String word) {
        int round = 5;
        boolean isWin = true;
        int filled = 0;
        Scanner scanner = new Scanner(System.in);
        char c;
        System.out.println();
        for (int i = 0; i < word.length(); i++) {
            System.out.print("_ ");
        }
        System.out.println();
        
        char[] appear = new char[word.length()];
        for (int i = 0; i < appear.length; i++) {
            appear[i] = '_';
        }
        int prev;
        while (filled < word.length() && round > 0) {
            prev = filled;
            HangmanDraw.draw(round);
            System.out.println("You have " + round + " guesses left. Your next letter:");
            c = scanner.next().charAt(0);
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == c) {
                    filled++;
                    appear[i] = c;
                }
            }
            if (filled == prev) {
                round--;
            }
            for (int i = 0; i < appear.length; i++) {
                System.out.print(appear[i] + " ");
            }
            System.out.println();
        }
        
        if (round == 0) {
            isWin = false;
            HangmanDraw.draw(round);
        }
        return isWin;
    }
    
    public static void main(String[] args) {
        WordList wordList = load("words.txt");
        System.out.println("Welcome to Hangman!");
        
        String userInput;
        boolean isPlaying = true;
        Scanner scanner = new Scanner(System.in);
        while(!wordList.isEmpty() && isPlaying) {
            System.out.println("Guess the following word:");
            String word = wordList.selectAny();
            System.out.println(word);
            boolean isWin = play(word);
            if (isWin) {
                wordList.remove(word);
                if (wordList.isEmpty()) {
                    System.out.println("You have mastered Hangman!");
                } else {
                    System.out.println("Well done! Do you want to play again (Y/N)?");
                    userInput = scanner.next();
                    if (userInput.charAt(0) != 'Y' && userInput.charAt(0) != 'y') {
                        System.out.println("Goodbye!");
                        isPlaying = false;
                    }
                }
            } else {
                System.out.println("You are dead!");
                isPlaying = false;
            }
        }
    }
}
