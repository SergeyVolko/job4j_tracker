package ru.job4j.early;

import org.junit.Test;
import static org.junit.Assert.*;

public class PasswordValidatorTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenPasswordIsNullThenException() {
        PasswordValidator.validate(null);
    }

    @Test
    public void whenPasswordLengthLower() {
        String password = "eee";
        String expect = "The password length is not in the range [8, 32]";
        String rsl = PasswordValidator.validate(password);
        assertEquals(expect, rsl);
    }

    @Test
    public void whenPasswordNotUpper() {
        String password = "eeeeeeee";
        String expect = "The password does not contain at least one uppercase character.";
        String rsl = PasswordValidator.validate(password);
        assertEquals(expect, rsl);
    }

    @Test
    public void whenPasswordNotLower() {
        String password = "EEEEEEEE";
        String expect = "The password does not contain at least one lowercase character.";
        String rsl = PasswordValidator.validate(password);
        assertEquals(expect, rsl);
    }

    @Test
    public void whenPasswordNotDigit() {
        String password = "EEEEeeee";
        String expect = "The password does not contain at least one digit.";
        String rsl = PasswordValidator.validate(password);
        assertEquals(expect, rsl);
    }

    @Test
    public void whenPasswordNotSpecSymbol() {
        String password = "EEEEeeee1";
        String expect = "The password does not contain at least one special character (not a number"
                + " or a letter).";
        String rsl = PasswordValidator.validate(password);
        assertEquals(expect, rsl);
    }

    @Test
    public void whenPasswordSuccessful() {
        String password = "EEEE!eeee1";
        String expect = "Validation was successful.";
        String rsl = PasswordValidator.validate(password);
        assertEquals(expect, rsl);
    }

    @Test
    public void whenPasswordContainWord() {
        String password = "EEEE!qwErtyeeee1";
        String expect = "The password contains forbidden substrings.";
        String rsl = PasswordValidator.validate(password);
        assertEquals(expect, rsl);
    }
}