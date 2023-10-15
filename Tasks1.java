import java.util.Random;
import java.util.Scanner;

public class Tasks1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerLimit = 1;
        int upperLimit = 100;
        int maxAttempts = 10;
        int roundsPlayed = 0;
        int roundsWon = 0;

        System.out.println("Welcome to the Number Game!");

        while (true) {
            int secretNumber = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
            int attempts = 0;

            System.out.println("Round " + (roundsPlayed + 1));
            System.out.println("You have " + (maxAttempts - attempts) + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Guess the number between " + lowerLimit + " and " + upperLimit + ": ");
                int userGuess = scanner.nextInt();

                if (userGuess < lowerLimit || userGuess > upperLimit) {
                    System.out.println("Please guess a number within the specified range.");
                } else if (userGuess == secretNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    roundsWon++;
                    roundsPlayed++;
                    break;
                } else if (userGuess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                attempts++;
                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            if (attempts >= maxAttempts) {
                System.out.println("Out of attempts. The secret number was " + secretNumber + ".");
                roundsPlayed++;
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                System.out.println("Rounds played: " + roundsPlayed + ", Rounds won: " + roundsWon);
                System.out.println("Thanks for playing!");
                break;
            }
        }

        scanner.close();
    }
}
