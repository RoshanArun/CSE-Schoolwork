package edu.ser216.checkers.core;

import java.util.Scanner;

public class CheckersGameLogic implements CheckersGame {
    private char turn;
    private char winningPlayer;
    private Scanner scan;

    public CheckersGameLogic(Scanner scan) {
        this.scan = scan;
        turn = 'X';
        winningPlayer = '_';
    }

    @Override
    public char getSquare(int row, int column) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setSquare(int row, int column, char content) {
        // TODO Auto-generated method stub

    }

    @Override
    public char getWinningPlayer() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void nextTurn() {
        // TODO Auto-generated method stub

    }

    @Override
    public void doTurn() {
        // TODO Auto-generated method stub

    }

    @Override
    public void onEnd() {
        // TODO Auto-generated method stub

    }

}
