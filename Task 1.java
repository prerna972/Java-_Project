// I'll create a Java program that implements the number guessing game with all the requested features.


import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 100;
    private static final int MAX_ATTEMPTS = 10;
    
    private static int totalRoundsWon = 0;
    private static int totalAttempts = 0;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        
        System.out.println("🎯 Welcome to the Number Guessing Game! 🎯");
        System.out.println("I'm thinking of a number between " + MIN_RANGE + " and " + MAX_RANGE);
        System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess it correctly.");
        System.out.println("----------------------------------------");
        
        while (playAgain) {
            playRound(scanner, random);
            
            System.out.print("\nWould you like to play another round? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes") || response.equals("y");
        }
        
        displayFinalScore();
        scanner.close();
    }
    
    private static void playRound(Scanner scanner, Random random) {
        int targetNumber = random.nextInt(MAX_RANGE - MIN_RANGE + 1) + MIN_RANGE;
        int attempts = 0;
        boolean guessedCorrectly = false;
        
        System.out.println("\n🌟 New Round Started! 🌟");
        
        while (attempts < MAX_ATTEMPTS && !guessedCorrectly) {
            System.out.print("Attempt " + (attempts + 1) + "/" + MAX_ATTEMPTS + " - Enter your guess: ");
            
            try {
                int guess = scanner.nextInt();
                attempts++;
                
                if (guess == targetNumber) {
                    guessedCorrectly = true;
                    System.out.println("🎉 Congratulations! You guessed the correct number: " + targetNumber);
                    System.out.println("You found it in " + attempts + " attempt(s)!");
                    
                    totalRoundsWon++;
                    totalAttempts += attempts;
                    
                } else if (guess < targetNumber) {
                    System.out.println("⬆ Too low! Try a higher number.");
                    
                    // Provide additional hint if close
                    if (targetNumber - guess <= 10) {
                        System.out.println("💡 Hint: You're getting close!");
                    }
                    
                } else {
                    System.out.println("⬇ Too high! Try a lower number.");
                    
                    // Provide additional hint if close
                    if (guess - targetNumber <= 10) {
                        System.out.println("💡 Hint: You're getting close!");
                    }
                }
                
            } catch (Exception e) {
                System.out.println("❌ Invalid input! Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            }
        }
        
        if (!guessedCorrectly) {
            System.out.println("😢 Game over! You've used all " + MAX_ATTEMPTS + " attempts.");
            System.out.println("The correct number was: " + targetNumber);
        }
    }
    
    private static void displayFinalScore() {
        System.out.println("\n========================================");
        System.out.println("🎮 GAME SUMMARY");
        System.out.println("========================================");
        System.out.println("Total rounds played: " + (totalRoundsWon > 0 ? "At least " + totalRoundsWon : "0"));
        System.out.println("Rounds won: " + totalRoundsWon);
        
        if (totalRoundsWon > 0) {
            double averageAttempts = (double) totalAttempts / totalRoundsWon;
            System.out.printf("Average attempts per win: %.1f%n", averageAttempts);
            
            // Calculate score based on performance
            int score = totalRoundsWon * 100 - totalAttempts * 5;
            System.out.println("Your total score: " + score);
            
            // Performance rating
            if (averageAttempts <= 3) {
                System.out.println("🏆 Performance: Expert Guesser!");
            } else if (averageAttempts <= 6) {
                System.out.println("⭐ Performance: Great Job!");
            } else {
                System.out.println("👍 Performance: Good effort!");
            }
        }
        
        System.out.println("========================================");
        System.out.println("Thank you for playing! 👋");
    }
}


