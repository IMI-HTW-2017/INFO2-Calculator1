import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class CalcEngineHexTest {

    private CalcEngineHex calc;
    private Random random;

    private int firstNumber;
    private int secondNumber;

    @Before
    public void setUp() {
        calc = new CalcEngineHex();
        random = new Random();
    }

    @Test
    public void display() {
        firstNumber = random.nextInt(10);
        calc.numberPressed(firstNumber);

        assertEquals(firstNumber, calc.getDisplayValue());

        calc.clear();

        assertEquals(0, calc.getDisplayValue());
    }

    @Test
    public void displayHex() {
        firstNumber = random.nextInt(16);
        calc.numberPressedHex(firstNumber);

        assertEquals(Integer.toHexString(firstNumber), calc.getDisplayValueHex());
    }

    @Test
    public void addition() {
        firstNumber = random.nextInt(10);
        secondNumber = random.nextInt(10);

        calc.numberPressed(firstNumber);
        calc.plus();
        calc.numberPressed(secondNumber);
        calc.equals();

        assertEquals(firstNumber + secondNumber, calc.getDisplayValue());
    }

    @Test
    public void subtraction() {
        firstNumber = random.nextInt(10);
        secondNumber = random.nextInt(10);

        calc.numberPressed(firstNumber);
        calc.minus();
        calc.numberPressed(secondNumber);
        calc.equals();

        assertEquals(firstNumber - secondNumber, calc.getDisplayValue());
    }

    @Test
    public void multiplication() {
        firstNumber = random.nextInt(10);
        secondNumber = random.nextInt(10);

        calc.numberPressed(firstNumber);
        calc.multiply();
        calc.numberPressed(secondNumber);
        calc.equals();

        assertEquals(firstNumber * secondNumber, calc.getDisplayValue());
    }

    @Test
    public void division() {
        firstNumber = random.nextInt(10);
        secondNumber = random.nextInt(9) + 1;

        calc.numberPressed(firstNumber);
        calc.divide();
        calc.numberPressed(secondNumber);
        calc.equals();

        assertEquals(firstNumber / secondNumber, calc.getDisplayValue());
    }

    @Test
    public void negativeNumbers() {
        firstNumber = random.nextInt(10);
        secondNumber = random.nextInt(10);

        calc.minus();
        calc.numberPressed(firstNumber);
        calc.plus();
        calc.numberPressed(secondNumber);
        calc.equals();

        assertEquals(-firstNumber + secondNumber, calc.getDisplayValue());

        calc.clear();

        calc.numberPressed(firstNumber);
        calc.plus();
        calc.minus();
        calc.numberPressed(secondNumber);
        calc.equals();

        assertEquals(firstNumber + -secondNumber, calc.getDisplayValue());

        calc.clear();

        calc.minus();
        calc.numberPressed(firstNumber);
        calc.plus();
        calc.minus();
        calc.numberPressed(secondNumber);
        calc.equals();

        assertEquals(-firstNumber + -secondNumber, calc.getDisplayValue());
    }

    @Test
    public void additionHex() {
        firstNumber = random.nextInt(16);
        secondNumber = random.nextInt(16);

        calc.numberPressedHex(firstNumber);
        calc.plus();
        calc.numberPressedHex(secondNumber);
        calc.equals();

        assertEquals(Integer.toHexString(firstNumber + secondNumber), calc.getDisplayValueHex());
    }

    @Test
    public void subtractionHex() {
        firstNumber = random.nextInt(16);
        secondNumber = random.nextInt(16);

        calc.numberPressedHex(firstNumber);
        calc.minus();
        calc.numberPressedHex(secondNumber);
        calc.equals();

        assertEquals(Integer.toHexString(firstNumber - secondNumber), calc.getDisplayValueHex());
    }

    @Test
    public void multiplicationHex() {
        firstNumber = random.nextInt(16);
        secondNumber = random.nextInt(16);

        calc.numberPressedHex(firstNumber);
        calc.multiply();
        calc.numberPressedHex(secondNumber);
        calc.equals();

        assertEquals(Integer.toHexString(firstNumber * secondNumber), calc.getDisplayValueHex());
    }

    @Test
    public void divisionHex() {
        firstNumber = random.nextInt(16);
        secondNumber = random.nextInt(15) + 1;

        calc.numberPressedHex(firstNumber);
        calc.divide();
        calc.numberPressedHex(secondNumber);
        calc.equals();

        assertEquals(Integer.toHexString(firstNumber / secondNumber), calc.getDisplayValueHex());
    }

    @Test
    public void negativeNumbersHex() {
        firstNumber = random.nextInt(16);
        secondNumber = random.nextInt(16);

        calc.minus();
        calc.numberPressedHex(firstNumber);
        calc.plus();
        calc.numberPressedHex(secondNumber);
        calc.equals();

        assertEquals(Integer.toHexString(-firstNumber + secondNumber), calc.getDisplayValueHex());

        calc.clear();

        calc.numberPressedHex(firstNumber);
        calc.plus();
        calc.minus();
        calc.numberPressedHex(secondNumber);
        calc.equals();

        assertEquals(Integer.toHexString(firstNumber + -secondNumber), calc.getDisplayValueHex());

        calc.clear();

        calc.minus();
        calc.numberPressedHex(firstNumber);
        calc.plus();
        calc.minus();
        calc.numberPressedHex(secondNumber);
        calc.equals();

        assertEquals(Integer.toHexString(-firstNumber + -secondNumber), calc.getDisplayValueHex());
    }
}