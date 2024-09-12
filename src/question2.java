import java.util.Random;
import java.util.Scanner;

// Base class for a generic game
class Game {
    protected int maxAttempts;
    protected int attempts;

    public Game(int maxAttempts) {
        this.maxAttempts = maxAttempts;
        this.attempts = 0;
    }

    public boolean hasAttemptsLeft() {
        return attempts < maxAttempts;
    }

    public void incrementAttempts() {
        attempts++;
    }

    public void startGame() {
        // This will be overridden by subclasses
    }
}

// Inherited class for Number Guessing Game
class NumberGuessingGame extends Game {
    private int numberToGuess;
    private int lowerBound;
    private int upperBound;
    private Scanner scanner;

    public NumberGuessingGame(int lowerBound, int upperBound, int maxAttempts) {
        super(maxAttempts);
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.scanner = new Scanner(System.in);
        this.numberToGuess = new Random().nextInt(upperBound - lowerBound + 1) + lowerBound;
    }

    @Override
    public void startGame() {
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess a number between " + lowerBound + " and " + upperBound + ".");

        while (hasAttemptsLeft()) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            incrementAttempts();

            if (guess == numberToGuess) {
                System.out.println("Congratulations! You've guessed the number.");
                return;
            } else if (guess < numberToGuess) {
                System.out.println("The number is higher. Try again.");
            } else {
                System.out.println("The number is lower. Try again.");
            }

            System.out.println("Attempts left: " + (maxAttempts - attempts));
        }

        System.out.println("Game Over! The number was: " + numberToGuess);
    }
}

// Main class to run the game
public class question2 {
    public static void main(String[] args) {
        // Set the game parameters
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 5;

        // Create an instance of the NumberGuessingGame and start it
        Game game = new NumberGuessingGame(lowerBound, upperBound, maxAttempts);
        game.startGame();
    }
}
