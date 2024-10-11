package net.guess.number;

import net.guess.util.InvalidModeException;

import java.util.Random;

/**
 * Hello there, Andrew here. If you're here from YouTube, hope you're doing great
 * You can use the code here for whatever you want, I won't be upset if you make
 * an epic program with it.
 *
 * <p>But if you're down for it, share the video to a friend, or anyone who might
 * be interested in trying this out, and help buy me a
 * coffee. I don't really like coffee, but it's the thought that counts.
 *
 * <p>If you don't feel like it, that's OK too. No hard feelings :)
 * */

public abstract class RNG {

    private final Random random = new Random();

    public int generatePositive(String mode) { //Only generate positive numbers

        return switch (mode.toLowerCase()) {
            case "easy" -> random.nextInt(0, 10);
            case "mid" -> random.nextInt(0, 30);
            case "hard" -> random.nextInt(0, 50);
            case "ggs" -> random.nextInt(0, 100);

            default -> throw new InvalidModeException("numbers only");
        };

    }

    public int generateNegative(String mode) { //Generate with negative numbers

        return switch (mode.toLowerCase()) {
            case "easy" -> random.nextInt(-10, 10);
            case "mid" -> random.nextInt(-30, 30);
            case "hard" -> random.nextInt(-50, 50);
            case "ggs" -> random.nextInt(-100, 100);

            default -> throw new InvalidModeException("numbers only");
        };

    }

}
