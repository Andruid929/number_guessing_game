package net.guess;

import net.guess.number.RNG;
import net.guess.util.InvalidModeException;

import java.util.Scanner;

public class Start extends RNG {

    final Scanner SCANNER = new Scanner(System.in);

    int number;
    int c = 10;

    void main() {
        generateNumber();

        System.out.println("\nAlright, I have generated a number, take your best guess.");

        int guess;

        do {
            guess = Integer.parseInt(SCANNER.next()); //guess = SCANNER.nextInt() also works by the way

            System.out.println(validation(guess));
            c--;

            if (number == guess) {
                break;
            }

        } while (c > 0);

        System.out.println("Number was " + number);

        System.out.println("\nShall we go again?");

        if (SCANNER.next().equalsIgnoreCase("yes")) {
            System.out.print("\n");
            c = 10; //Reset the chances
            main();
        } else if (SCANNER.next().equalsIgnoreCase("no")) {
            System.out.println("Good bye.");
        }
    }

    private String validation(int guess) { //Check how close or far you were to the answer
        if (guess - number <= 3 && guess - number > 0 || number - guess <= 3 && number - guess > 0) {
            return "Warm";
        }
        if (guess - number > 3 && guess - number <= 7 || number - guess > 3 && number <= 7) {
            return "Cold";
        }

        if (guess == number) {
            return "Yup, that's it.";
        }

        return "Quite far from it...";
    }

    private void generateNumber() { //Generate the number itself

        System.out.println("Shall we do positives or...");
        String posOrNeg = SCANNER.next();

        System.out.println("How hard should I make this guess?");
        String mode = SCANNER.next();

        if (posOrNeg.equalsIgnoreCase("pos")) {
            number = generatePositive(mode);
            return;
        }
        if (posOrNeg.equalsIgnoreCase("neg")) {
            number = generateNegative(mode);
            return;
        }

        throw new InvalidModeException();
    }

}
