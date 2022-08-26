package ru.job4j.early;

import java.util.Set;
import java.util.function.Predicate;

public class PasswordValidator {

    private static final Set<String> CONTAIN_STRING
            = Set.of("qwerty", "12345", "password", "admin", "user");

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Argument is null.");
        }
        String result = "Validation was successful.";
        if (password.length() < 8 || password.length() > 32) {
            result = "The password length is not in the range [8, 32]";
        } else if (validatePassword(password, Character::isUpperCase)) {
            result = "The password does not contain at least "
                    + "one uppercase character.";
        } else if (validatePassword(password, Character::isLowerCase)) {
            result = "The password does not contain at "
                    + "least one lowercase character.";
        } else if (validatePassword(password, Character::isDigit)) {
            result = "The password does not contain at least one digit.";
        } else if (validatePassword(password,
                ch -> !Character.isDigit(ch) && !Character.isAlphabetic(ch))) {
            result = "The password does not contain at least one special "
                    + "character (not a number or a letter).";
        } else if (validateContain(password.toLowerCase())) {
            result = "The password contains forbidden substrings.";
        }
        return result;
    }

    private static boolean validatePassword(String password, Predicate<Character> predicate) {
        return password.chars().noneMatch(ch -> predicate.test((char) ch));
    }

    private static boolean validateContain(String password) {
        return CONTAIN_STRING.stream().anyMatch(password::contains);
    }
}
