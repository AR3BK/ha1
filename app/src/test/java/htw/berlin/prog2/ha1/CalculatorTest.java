package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Retro calculator")
class CalculatorTest {

    @Test
    @DisplayName("should display result after adding two positive multi-digit numbers")
    void testPositiveAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "40";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after getting the square root of two")
    void testSquareRoot() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("√");

        String expected = "1.41421356";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when dividing by zero")
    void testDivisionByZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when drawing the square root of a negative number")
    void testSquareRootOfNegative() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressNegativeKey();
        calc.pressUnaryOperationKey("√");

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should not allow multiple decimal dots")
    void testMultipleDecimalDots() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDotKey();
        calc.pressDigitKey(7);
        calc.pressDotKey();
        calc.pressDigitKey(8);

        String expected = "1.78";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


    //TODO hier weitere Tests erstellen

    @Test
    @DisplayName("should allow to go negative ")
    void testNegative() {
        Calculator calc = new Calculator();

    calc.pressDigitKey(4);
    calc.pressBinaryOperationKey("-");
    calc.pressDigitKey(8);
    calc.pressEqualsKey();

    String expected = "-4";
    String actual = calc.readScreen();

    assertEquals(expected, actual);
    }
    @Test
    @DisplayName("Negative 0")
    void testfail1() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(0);
        calc.pressNegativeKey();
        calc.pressEqualsKey();

        String expected = "0"; // zeigt -0 an deswegen rot
        String actual = calc.readScreen();
    }
    @Test
    void testfail2() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(7);
        calc.pressNegativeKey();
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();
        String expected = "Error";      // kommt inf oder so raus
        String actual = calc.readScreen();
        assertEquals(expected, actual);
    }
    @Test
    void testfail3() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(7);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(7);
        calc.pressEqualsKey();
        calc.pressClearKey();
        calc.pressDigitKey(9);
        calc.pressEqualsKey();

        String expected = "16";
        String actual = calc.readScreen();
        assertEquals(expected, actual);

    }
}

