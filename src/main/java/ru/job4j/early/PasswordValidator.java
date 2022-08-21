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
        if (password.length() < 8 || password.length() > 32) {
            return "The password length is not in the range [8, 32]";
        }
        if (validatePassword(password, Character::isUpperCase)) {
            return "The password does not contain at least one uppercase character.";
        }
        if (validatePassword(password, Character::isLowerCase)) {
            return "The password does not contain at least one lowercase character.";
        }
        if (validatePassword(password, Character::isDigit)) {
            return "The password does not contain at least one digit.";
        }
        if (validatePassword(password,
                ch -> !Character.isDigit(ch) && !Character.isAlphabetic(ch))) {
            return "The password does not contain at least one special character (not a number or a"
                    + " letter).";
        }
        if (validateContain(password.toLowerCase())) {
            return "The password contains forbidden substrings.";
        }
        return "Validation was successful.";
    }

    private static boolean validatePassword(String password, Predicate<Character> predicate) {
        return password.chars().noneMatch(ch -> predicate.test((char) ch));
    }

    private static boolean validateContain(String password) {
        return CONTAIN_STRING.stream().anyMatch(password::contains);
    }
}
