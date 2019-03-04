import java.util.Scanner;

public class Hangman {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] letterWords = new String[1];
        String word = "";

        int guess = 0;

        System.out.println("Player One, enter a word:");
        String player1 = sc.next();

        for (int i = 0; i < letterWords.length; i++) {
            letterWords[i] = player1;
            word = letterWords[i];
        }

        String underscore = new String(new char[word.length()]).replace("\0", "_");

        System.out.println(underscore);

        int turns = 8;

        while (guess < 8 && underscore.contains("_")) {
            System.out.println("Player Two, you have " + turns + " guesses left. Enter a guess:");
            String player2 = sc.next();


            String new_underscore = "";

            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == player2.charAt(0)) {
                    new_underscore += player2.charAt(0);
                } else if (underscore.charAt(i) != '_') {
                    new_underscore += word.charAt(i);
                } else {
                    new_underscore += "_";
                }
            }

            if(underscore.contains(String.valueOf(player2))) {
                System.out.println("You have already guessed " + "'" + player2 + "'.");
                System.out.println(underscore);
            }
            else if (underscore.equals(new_underscore)) {
                turns--;
                guess++;
                if(guess < 8){
                    System.out.println(underscore);

                }

            } else {
                underscore = new_underscore;
                System.out.println(underscore);
            }


            if (underscore.equals(word)) {
                System.out.println("Game over. Player Two wins!");
            }
            else if(guess == 8){
                System.out.println("Game over. Player One wins! The word was: " + word);
            }
        }
        sc.close();
    }
}


