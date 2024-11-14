import java.util.Scanner;

public class PasswordValidator {

    public static boolean isValidPassword(String password) {
        // Check length of password
        if (password.length() < 8) {
            return false;
        }

        // Flags to check different criteria
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        // Iterate through each character in the password
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(ch)) {
                hasLowerCase = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if (isSpecialCharacter(ch)) {
                hasSpecialChar = true;
            }
        }

        // Check if all criteria are met
        return hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar;
    }

    // Method to check if the character is a special character
    private static boolean isSpecialCharacter(char ch) {
        String specialChars = "!@#$%^&*()-+";
        return specialChars.contains(String.valueOf(ch));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if (isValidPassword(password)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is invalid. It must be at least 8 characters long, "
                    + "contain an uppercase letter, a lowercase letter, a digit, and a special character.");
        }

        scanner.close();
    }
}
