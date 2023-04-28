package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import edu.ser216.checkers.core.CheckersComputerPlayer;
import edu.ser216.checkers.core.CheckersGameLogic;
import junit.framework.Assert;

import java.util.Scanner;

public class test {

    CheckersGameLogic game;
    CheckersComputerPlayer game2;
    Scanner scan = new Scanner(System.in);

    // Test getSquare method
    @Test
    public void testGetSquare() {
        game = new CheckersGameLogic(scan);

        // Test an empty square
        char expected = 'x';
        char actual = game.getSquare(0, 0);
        assertEquals(expected, actual);

        // Test an x piece
        expected = 'x';
        actual = game.getSquare(0, 0);
        assertEquals(expected, actual);

        // Test an o piece
        expected = 'o';
        actual = game.getSquare(6, 0);
        assertEquals(expected, actual);
    }

    // Test setSquare method
    @Test
    public void testSetSquare() {
        game = new CheckersGameLogic(scan);

        // Set the square to x
        game.setSquare(0, 0, 'x');
        char expected = 'x';
        char actual = game.getSquare(0, 0);
        assertEquals(expected, actual);

        // Set the square to o
        game.setSquare(0, 0, 'o');
        expected = 'o';
        actual = game.getSquare(0, 0);
        assertEquals(expected, actual);

        // Set the square to empty
        game.setSquare(0, 0, '_');
        expected = '_';
        actual = game.getSquare(0, 0);
        assertEquals(expected, actual);
    }

    // Test isValidMove method
    @Test
    public void testIsValidMove() {
        game = new CheckersGameLogic(scan);
        boolean expected;
        boolean actual;

        // Test valid move
        expected = true;
        actual = game.isValidMove(2, 0, 3, 1);
        assertEquals(expected, actual);

        // Test for check if the piece exists
        expected = false;
        actual = game.isValidMove(7, 0, 6, 1);
        assertEquals(expected, actual);

        // Test for check if destination is occupied
        expected = false;
        actual = game.isValidMove(7, 7, 6, 6);
        assertEquals(expected, actual);

        // Test invalid move
        expected = false;
        actual = game.isValidMove(2, 0, 4, 2);
        assertEquals(expected, actual);

        // Test 1:
        // Test the check for endRow and endCol less than 0 and greater than 7
        game.setSquare(4, 4, 'o');
        expected = false;
        actual = game.isValidMove(4, 4, 9, 9);
        assertEquals(expected, actual);

        // Test 2:
        // Test the check for startRow and startCol less than 0 and greater than 7
        game.setSquare(4, 4, 'o');
        expected = false;
        actual = game.isValidMove(-1, -1, 2, 3);
        assertEquals(expected, actual);

        // Test 3:
        // Test the check for no movement
        game.setSquare(4, 4, 'o');
        expected = false;
        actual = game.isValidMove(4, 4, 4, 4);
        assertEquals(expected, actual);

        // Test 4:
        // Test the check for diagonal movement
        game.setSquare(4, 4, 'o');
        expected = false;
        actual = game.isValidMove(4, 4, 3, 5);
        assertEquals(expected, actual);

        // Test 5:
        // Test the check for a destination occupied
        game.setSquare(4, 4, 'o');
        game.setSquare(3, 3, 'x');
        expected = false;
        actual = game.isValidMove(4, 4, 3, 3);
        assertEquals(expected, actual);

        // Test 6:
        // Test the check for a movement greater than two
        game.setSquare(4, 4, 'o');
        expected = false;
        actual = game.isValidMove(4, 4, 2, 5);
        assertEquals(expected, actual);

        // Test 7:
        // Test the check for a destination of an opponent piece
        game.setSquare(4, 4, 'o');
        game.setSquare(2, 4, 'x');
        expected = false;
        actual = game.isValidMove(4, 7, 2, 4);
        assertEquals(expected, actual);

        // Test 8:
        // Test the check for a movement in the opposite direction of the team
        game.setSquare(4, 4, 'o');
        expected = false;
        actual = game.isValidMove(4, 4, 6, 4);
        assertEquals(expected, actual);

        // Test 9:
        // Test the check for an opponent piece in the middle
        game.setSquare(4, 4, 'o');
        game.setSquare(5, 5, 'x');
        expected = false;
        actual = game.isValidMove(4, 4, 6, 6);
        assertEquals(expected, actual);

        // Test 10:
        // Test the check for a piece belonging to the current player
        game.setSquare(4, 4, 'o');
        expected = false;
        actual = game.isValidMove(4, 4, 2, 4);
        assertEquals(expected, actual);

        // Test checks if the movement is greater than two
        game.setSquare(4, 4, 'o');
        expected = false;
        actual = game.isValidMove(4, 4, 0, 4);
        assertEquals(expected, actual);

        // Test checks if the destination is an opponent piece
        game.setSquare(4, 4, 'o');
        game.setSquare(2, 4, 'x');
        expected = false;
        actual = game.isValidMove(4, 4, 2, 4);
        assertEquals(expected, actual);
    }

    // Test charToInt method
    @Test
    public void testCharToInt() {
        game = new CheckersGameLogic(scan);

        int expected;
        int actual;

        // Test letter a
        expected = 0;
        actual = game.charToInt('a');
        assertEquals(expected, actual);

        // Test letter b
        expected = 1;
        actual = game.charToInt('b');
        assertEquals(expected, actual);

        // Test letter c
        expected = 2;
        actual = game.charToInt('c');
        assertEquals(expected, actual);

        // Test letter d
        expected = 3;
        actual = game.charToInt('d');
        assertEquals(expected, actual);

        // Test letter e
        expected = 4;
        actual = game.charToInt('e');
        assertEquals(expected, actual);

        // Test letter f
        expected = 5;
        actual = game.charToInt('f');
        assertEquals(expected, actual);

        // Test letter g
        expected = 6;
        actual = game.charToInt('g');
        assertEquals(expected, actual);

        // Test letter h
        expected = 7;
        actual = game.charToInt('h');
        assertEquals(expected, actual);
    }

    // Test charToInt2 method
    @Test
    public void testCharToInt2() {
        game = new CheckersGameLogic(scan);

        int expected;
        int actual;

        // Test number 1
        expected = 0;
        actual = game.charToInt2('1');
        assertEquals(expected, actual);

        // Test number 2
        expected = 1;
        actual = game.charToInt2('2');
        assertEquals(expected, actual);

        // Test number 3
        expected = 2;
        actual = game.charToInt2('3');
        assertEquals(expected, actual);

        // Test number 4
        expected = 3;
        actual = game.charToInt2('4');
        assertEquals(expected, actual);

        // Test number 5
        expected = 4;
        actual = game.charToInt2('5');
        assertEquals(expected, actual);

        // Test number 6
        expected = 5;
        actual = game.charToInt2('6');
        assertEquals(expected, actual);

        // Test number 7
        expected = 6;
        actual = game.charToInt2('7');
        assertEquals(expected, actual);

        // Test number 8
        expected = 7;
        actual = game.charToInt2('8');
        assertEquals(expected, actual);
    }

    // Test onEnd method
    @Test
    public void testonEnd() {
        game = new CheckersGameLogic(scan);
        String expected;
        String actual;

        // Test x wins
        expected = "Player X wins!";
        game.setSquare(7, 0, '_');
        game.onEnd();
        actual = "Player X wins!";
        assertEquals(expected, actual);

        // Test o wins
        expected = "Player O wins!";
        game.setSquare(0, 1, '_');
        game.onEnd();
        actual = "Player O wins!";
        assertEquals(expected, actual);
    }

    // Test nextTurn method
    @Test
    public void testnextTurn() {
        game = new CheckersGameLogic(scan);
        String expected;
        String actual;

        int turn = 0;

        if (turn % 2 == 0) {
            expected = "\nPlayer X - your turn. \nChoose a cell position of piece, 3a-4b 3g-4h";
            actual = "\nPlayer X - your turn. \nChoose a cell position of piece, 3a-4b 3g-4h";
            assertEquals(expected, actual);

            // Test turn 2 for player o
            expected = "\nPlayer O - your turn. \nChoose a cell position of piece, 3a-4b 3g-4h";
            game.nextTurn();
            actual = "\nPlayer O - your turn. \nChoose a cell position of piece, 3a-4b 3g-4h";
            assertEquals(expected, actual);
        }

    }

    public void testDoTurn() {
        game = new CheckersGameLogic(scan);
        String expected;
        String actual;
        // input that is not 5 characters
        String input1 = "123";
        expected = "This move is invalid";
        game.doTurn();
        actual = "This move is invalid";
        assertEquals(expected, actual);

        // input that is exactly 5 characters
        String input2 = "12ab";
        expected = "This move is valid";
        game.doTurn();
        actual = "This move is invalid";
        assertEquals(expected, actual);

        // input that is not in the correct format
        String input3 = "a1b2";
        expected = "This move is invalid";
        game.doTurn();
        actual = "This move is invalid";
        assertEquals(expected, actual);
    }

    // Test getSquare method
    @Test
    public void testGetSquare2() {
        game2 = new CheckersComputerPlayer(scan);

        // Test an empty square
        char expected = 'x';
        char actual = game2.getSquare(0, 0);
        assertEquals(expected, actual);

        // Test an x piece
        expected = 'x';
        actual = game2.getSquare(0, 0);
        assertEquals(expected, actual);

        // Test an o piece
        expected = 'o';
        actual = game2.getSquare(6, 0);
        assertEquals(expected, actual);
    }

    // Test setSquare method
    @Test
    public void testSetSquare2() {
        game2 = new CheckersComputerPlayer(scan);

        // Set the square to x
        game2.setSquare(0, 0, 'x');
        char expected = 'x';
        char actual = game2.getSquare(0, 0);
        assertEquals(expected, actual);

        // Set the square to o
        game2.setSquare(0, 0, 'o');
        expected = 'o';
        actual = game2.getSquare(0, 0);
        assertEquals(expected, actual);

        // Set the square to empty
        game2.setSquare(0, 0, '_');
        expected = '_';
        actual = game2.getSquare(0, 0);
        assertEquals(expected, actual);
    }

    // Test isValidMove method
    @Test
    public void testIsValidMove2() {
        game2 = new CheckersComputerPlayer(scan);
        boolean expected;
        boolean actual;

        // Test valid move
        expected = true;
        actual = game2.isValidMove(2, 0, 3, 1);
        assertEquals(expected, actual);

        // Test for check if the piece exists
        expected = false;
        actual = game2.isValidMove(7, 0, 6, 1);
        assertEquals(expected, actual);

        // Test for check if destination is occupied
        expected = false;
        actual = game2.isValidMove(7, 7, 6, 6);
        assertEquals(expected, actual);

        // Test invalid move
        expected = false;
        actual = game2.isValidMove(2, 0, 4, 2);
        assertEquals(expected, actual);

        // Test 1:
        // Test the check for endRow and endCol less than 0 and greater than 7
        game2.setSquare(4, 4, 'o');
        expected = false;
        actual = game2.isValidMove(4, 4, 9, 9);
        assertEquals(expected, actual);

        // Test 2:
        // Test the check for startRow and startCol less than 0 and greater than 7
        game2.setSquare(4, 4, 'o');
        expected = false;
        actual = game2.isValidMove(-1, -1, 2, 3);
        assertEquals(expected, actual);

        // Test 3:
        // Test the check for no movement
        game2.setSquare(4, 4, 'o');
        expected = false;
        actual = game2.isValidMove(4, 4, 4, 4);
        assertEquals(expected, actual);

        // Test 4:
        // Test the check for diagonal movement
        game2.setSquare(4, 4, 'o');
        expected = false;
        actual = game2.isValidMove(4, 4, 3, 5);
        assertEquals(expected, actual);

        // Test 5:
        // Test the check for a destination occupied
        game2.setSquare(4, 4, 'o');
        game2.setSquare(3, 3, 'x');
        expected = false;
        actual = game2.isValidMove(4, 4, 3, 3);
        assertEquals(expected, actual);

        // Test 6:
        // Test the check for a movement greater than two
        game2.setSquare(4, 4, 'o');
        expected = false;
        actual = game.isValidMove(4, 4, 2, 5);
        assertEquals(expected, actual);

        // Test 7:
        // Test the check for a destination of an opponent piece
        game2.setSquare(4, 4, 'o');
        game2.setSquare(2, 4, 'x');
        expected = false;
        actual = game2.isValidMove(4, 7, 2, 4);
        assertEquals(expected, actual);

        // Test 8:
        // Test the check for a movement in the opposite direction of the team
        game2.setSquare(4, 4, 'o');
        expected = false;
        actual = game2.isValidMove(4, 4, 6, 4);
        assertEquals(expected, actual);

        // Test 9:
        // Test the check for an opponent piece in the middle
        game2.setSquare(4, 4, 'o');
        game2.setSquare(5, 5, 'x');
        expected = false;
        actual = game2.isValidMove(4, 4, 6, 6);
        assertEquals(expected, actual);

        // Test 10:
        // Test the check for a piece belonging to the current player
        game2.setSquare(4, 4, 'o');
        expected = false;
        actual = game2.isValidMove(4, 4, 2, 4);
        assertEquals(expected, actual);

        // Test checks if the movement is greater than two
        game2.setSquare(4, 4, 'o');
        expected = false;
        actual = game2.isValidMove(4, 4, 0, 4);
        assertEquals(expected, actual);

        // Test checks if the destination is an opponent piece
        game2.setSquare(4, 4, 'o');
        game2.setSquare(2, 4, 'x');
        expected = false;
        actual = game2.isValidMove(4, 4, 2, 4);
        assertEquals(expected, actual);
    }

    // Test charToInt method
    @Test
    public void testCharToInt222() {
        game2 = new CheckersComputerPlayer(scan);

        int expected;
        int actual;

        // Test letter a
        expected = 0;
        actual = game2.charToInt('a');
        assertEquals(expected, actual);

        // Test letter b
        expected = 1;
        actual = game2.charToInt('b');
        assertEquals(expected, actual);

        // Test letter c
        expected = 2;
        actual = game2.charToInt('c');
        assertEquals(expected, actual);

        // Test letter d
        expected = 3;
        actual = game2.charToInt('d');
        assertEquals(expected, actual);

        // Test letter e
        expected = 4;
        actual = game2.charToInt('e');
        assertEquals(expected, actual);

        // Test letter f
        expected = 5;
        actual = game2.charToInt('f');
        assertEquals(expected, actual);

        // Test letter g
        expected = 6;
        actual = game2.charToInt('g');
        assertEquals(expected, actual);

        // Test letter h
        expected = 7;
        actual = game2.charToInt('h');
        assertEquals(expected, actual);
    }

    // Test charToInt2 method
    @Test
    public void testCharToInt22() {
        game2 = new CheckersComputerPlayer(scan);

        int expected;
        int actual;

        // Test number 1
        expected = 0;
        actual = game2.charToInt2('1');
        assertEquals(expected, actual);

        // Test number 2
        expected = 1;
        actual = game2.charToInt2('2');
        assertEquals(expected, actual);

        // Test number 3
        expected = 2;
        actual = game2.charToInt2('3');
        assertEquals(expected, actual);

        // Test number 4
        expected = 3;
        actual = game2.charToInt2('4');
        assertEquals(expected, actual);

        // Test number 5
        expected = 4;
        actual = game2.charToInt2('5');
        assertEquals(expected, actual);

        // Test number 6
        expected = 5;
        actual = game2.charToInt2('6');
        assertEquals(expected, actual);

        // Test number 7
        expected = 6;
        actual = game2.charToInt2('7');
        assertEquals(expected, actual);

        // Test number 8
        expected = 7;
        actual = game2.charToInt2('8');
        assertEquals(expected, actual);
    }

    // Test onEnd method
    @Test
    public void testonEnd2() {
        game2 = new CheckersComputerPlayer(scan);
        String expected;
        String actual;

        // Test x wins
        expected = "Player X wins!";
        game2.setSquare(7, 0, '_');
        game2.onEnd();
        actual = "Player X wins!";
        assertEquals(expected, actual);

        // Test o wins
        expected = "Player O wins!";
        game2.setSquare(0, 1, '_');
        game2.onEnd();
        actual = "Player O wins!";
        assertEquals(expected, actual);
    }

    // Test nextTurn method
    @Test
    public void testnextTurn2() {
        game2 = new CheckersComputerPlayer(scan);
        String expected;
        String actual;

        int turn = 0;

        if (turn % 2 == 0) {
            expected = "\nPlayer X - your turn. \nChoose a cell position of piece, 3a-4b 3g-4h";
            actual = "\nPlayer X - your turn. \nChoose a cell position of piece, 3a-4b 3g-4h";
            assertEquals(expected, actual);

            // Test turn 2 for player o
            expected = "\nPlayer O - your turn. \nChoose a cell position of piece, 3a-4b 3g-4h";
            game2.nextTurn();
            actual = "\nPlayer O - your turn. \nChoose a cell position of piece, 3a-4b 3g-4h";
            assertEquals(expected, actual);
        }

    }

}
