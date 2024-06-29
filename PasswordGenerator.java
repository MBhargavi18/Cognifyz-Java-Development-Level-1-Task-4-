import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for password length
        System.out.println("Enter the desired length of the password:");
        int length = scanner.nextInt();

        // Prompt user for character inclusion criteria
        System.out.println("Include numbers? (true/false):");
        boolean includeNumbers = scanner.nextBoolean();

        System.out.println("Include lowercase letters? (true/false):");
        boolean includeLowercase = scanner.nextBoolean();

        System.out.println("Include uppercase letters? (true/false):");
        boolean includeUppercase = scanner.nextBoolean();

        System.out.println("Include special characters? (true/false):");
        boolean includeSpecial = scanner.nextBoolean();

        scanner.close();

        // Generate the password
        String password = generatePassword(length, includeNumbers, includeLowercase, includeUppercase, includeSpecial);

        // Display the generated password
        System.out.println("Generated Password: " + password);
    }

    private static String generatePassword(int length, boolean includeNumbers, boolean includeLowercase, boolean includeUppercase, boolean includeSpecial) {
        String numbers = "0123456789";
        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String specialCharacters = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/~`";

        StringBuilder characterPool = new StringBuilder();

        // Build the pool of characters to be used in the password
        if (includeNumbers) {
            characterPool.append(numbers);
        }
        if (includeLowercase) {
            characterPool.append(lowercaseLetters);
        }
        if (includeUppercase) {
            characterPool.append(uppercaseLetters);
        }
        if (includeSpecial) {
            characterPool.append(specialCharacters);
        }

        // If no character types are selected, default to using all character types
        if (characterPool.length() == 0) {
            characterPool.append(numbers).append(lowercaseLetters).append(uppercaseLetters).append(specialCharacters);
        }

        Random random = new Random();
        StringBuilder password = new StringBuilder(length);

        // Generate the password
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterPool.length());
            password.append(characterPool.charAt(index));
        }

        return password.toString();
    }
}
