package Junit.src.test.java;

import Junit.src.main.java.org.example.StringUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilsTest {

    @Test
    public void reverseTest() {
        assertEquals("cba", StringUtils.reverseString("abc"));
        assertEquals("", StringUtils.reverseString(""));
        assertNull(StringUtils.reverseString(null));
    }

    @Test
    public void isPalindromeTest() {
        assertTrue(StringUtils.isPalindrome("madam"));
        assertFalse(StringUtils.isPalindrome("hello"));
        assertFalse(StringUtils.isPalindrome(null));
    }

    @Test
    public void toUppercaseTest() {
        assertEquals("HELLO", StringUtils.toUppercase("heLlO"));
        assertEquals("WELCOME", StringUtils.toUppercase("WelcOMe"));
        assertEquals("", StringUtils.toUppercase(""));
        assertNull(null);
    }
}
