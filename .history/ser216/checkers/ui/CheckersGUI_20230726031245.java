package ser216.checkers.ui;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ser216.checkers.core.CheckersGameLogic;
import java.util.Scanner;

public class CheckersGUI extends Application {
    // Initializes the necessary instance variables
    private CheckersGameLogic checkersGameLogic;
    private GridPane board;
    private GridPane background;
    private GridPane userInputs;
    private GridPane PVC;
    private GridPane helper;
    private GridPane helper2;
    private StackPane stack;
    private Scanner scan;
    private int turn = 0;

    public static void main(String[] args) {
        CheckersGUI.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Creates a Scanner instance to read user input
        scan = new Scanner(System.in);

        // Creates a CheckersGameLogic instance with the scanner as a parameter
        checkersGameLogic = new CheckersGameLogic(scan);
        primaryStage.setTitle("Checkers");

        // Initializes background of Checkers Board
        background = new GridPane();
        background.setAlignment(Pos.CENTER);
        background.setHgap(5);
        background.setVgap(5);
        initBackground(background);

        // Initializes pieces of Checkers Board
        board = new GridPane();
        board.setAlignment(Pos.CENTER);
        board.setHgap(15);
        board.setVgap(15);
        initBoard(board);

        // Initializes User Input of Checkers Board
        userInputs = new GridPane();
        PVC = new GridPane();
        helper = new GridPane();
        helper.setVgap(59);
        helper2 = new GridPane();
        helper2.setHgap(65);
        // initializes helpers

        for (int i = 1; i < 9; i++) {
            Text one = new Text(String.valueOf(i));
            helper.add(one, 0, i);
        }

        for (int i = 1; i < 9; i++) {
            String one = "ABCDEFGH";

            Text two = new Text(one.substring(i - 1, i));
            helper2.add(two, i, 0);
        }
        // Setting the margin for the circle
        stack = new StackPane();
        stack.setMargin(board, new Insets(0, 200, 0, 0));
        stack.setMargin(background, new Insets(0, 200, 0, 0));
        stack.setMargin(helper, new Insets(0, 0, 0, 10));
        stack.setMargin(helper2, new Insets(0, 0, 0, 10));
        stack.setMargin(userInputs, new Insets(200, 200, 0, 800));
        stack.setMargin(PVC, new Insets(400, 200, 0, 800));

        ObservableList list = stack.getChildren();
        list.addAll(background, board, helper, helper2, userInputs, PVC);

        // Creates two TextField and one Button instances
        TextField userInput = new TextField();
        TextField userInput2 = new TextField();
        Button submitButton2 = new Button("Submit");

        // Creates two Text instances for instructions
        Text t = new Text(10, 20,
                "Enter P if you want to play against another player; enter C to play againstcomputer.");
        t.setWrappingWidth(150);
        Text t2 = new Text(10, 20,
                "Player 1 is BLACK. CPU/Player 2 will be WHITE. All user input will go in thetextbox above. Choose a cell position of piece, I.E. 3a-4b 3g-4h");
        t2.setWrappingWidth(150);

        // Adds the TextField and Text instances to the GridPane
        userInputs.add(userInput2, 8, 0);
        userInputs.add(t2, 8, 1);
        userInputs.add(submitButton2, 8, 2);
        PVC.add(userInput, 8, 4);
        PVC.add(t, 8, 5);

        // Adds a submitButton2 onAction method
        submitButton2.setOnAction(e -> {
            String input = userInput.getText();
            String input2 = userInput2.getText();

            // Checks to see if the input is C or P
            if (input.equals("C")) {
                doTurn2(input2); // Calls the doTurn2 method with the input2 as a parameter
            } else if (input.equals("P")) {
                doTurn(input2); // Calls the doTurn method with the input2 as a parameter
            }
        });

        // Creates a Scene instance with the GridPane and size as parameters
        Scene scene = new Scene(stack, 850, 650);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initBackground(GridPane background2) {
        int tile = 0;
        int tile2 = 0;
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                Rectangle r = new Rectangle();
                r.setHeight(70);
                r.setWidth(70);

                if (tile % 2 == 0 && tile2 % 2 == 0) {
                    r.setFill(Color.BROWN);
                    background2.add(r, column, row);
                    tile++;
                } else if (tile % 2 != 0 && tile2 % 2 == 0) {
                    r.setFill(Color.BURLYWOOD);
                    background2.add(r, column, row);
                    tile++;
                } else if (tile % 2 == 0 && tile2 % 2 != 0) {
                    r.setFill(Color.BURLYWOOD);
                    background2.add(r, column, row);
                    tile++;
                } else {
                    r.setFill(Color.BROWN);
                    background2.add(r, column, row);
                    tile++;
                }
            }
            tile2++;
        }
    }

    // Initializes the board
    public void initBoard(GridPane board) {

        // Creates 8x8 buttons on the board
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                Button btn = new Button();
                btn.setPrefSize(60, 60);
                board.add(btn, column, row);
            }
        }

        // Colors the buttons according to the board
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                // Gets the content of the square
                char content = checkersGameLogic.getSquare(row, column);
                Button btn = (Button) board.getChildren().get(row * 8 + column);
                btn.setShape(new Circle(1.5));
                // Sets the style of the square according to the content
                if (content == 'x') {
                    btn.setStyle("-fx-border-color: black; -fx-background-color: #000000");
                } else if (content == 'o') {
                    btn.setStyle("-fx-border-color: black; -fx-background-color: #FFFFFF");
                } else if (row == 4 && column % 2 == 0) {
                    btn.setStyle("-fx-border-color: #A52A2A; -fx-background-color: #A52A2A");
                } else if (row == 3 && column % 2 == 1) {
                    btn.setStyle("-fx-border-color: #A52A2A; -fx-background-color: #A52A2A");
                } else {
                    btn.setStyle("-fx-border-color: #DEB887; -fx-background-color: #DEB887");
                }
            }
        }
    }

    // doTurn method for when the input is P
    public void doTurn(String input) {

        // Checks to see if there is a winning player
        if (checkersGameLogic.getWinningPlayer() == '_') {
            // Saves the user inputs from the TextField
            char number = input.charAt(0);
            char letter = input.charAt(1);
            char number2 = input.charAt(3);
            char letter2 = input.charAt(4);

            // Converts the user input to row and column
            int startRow = checkersGameLogic.charToInt2(number);
            int startCol = checkersGameLogic.charToInt(letter);
            int endRow = checkersGameLogic.charToInt2(number2);
            int endCol = checkersGameLogic.charToInt(letter2);

            char startContent = checkersGameLogic.getSquare(startRow, startCol);

            // Checks to see if the move to be made is valid or not
            if (isValidMove(startRow, startCol, endRow, endCol)) {

                // Sets the squares to the desired pieces
                checkersGameLogic.setSquare(startRow, startCol, '_');
                checkersGameLogic.setSquare(endRow, endCol, startContent);
                turn++;

                // Colors the buttons according to the board
                updateBoard();
            } else {
                System.out.println("This move is invalid");
            }
        } else {
            checkersGameLogic.getWinningPlayer();
        }
    }

    // This method is used to execute a turn in the checkers game.
    // It takes the input of the desired move as a parameter.
    public void doTurn2(String input) {

        // Checks if the game has been won yet
        if (checkersGameLogic.getWinningPlayer() == '_') {
            // Assigns the coordinates of the move to individual characters
            char number = input.charAt(0);
            char letter = input.charAt(1);
            char number2 = input.charAt(3);
            char letter2 = input.charAt(4);

            // Gets the coordinates of the start and end points of the move
            int startRow = checkersGameLogic.charToInt2(number);
            int startCol = checkersGameLogic.charToInt(letter);
            int endRow = checkersGameLogic.charToInt2(number2);
            int endCol = checkersGameLogic.charToInt(letter2);

            // Gets the content of the starting square
            char startContent = checkersGameLogic.getSquare(startRow, startCol);

            // checks to see if the move to be made is valid or not
            if (isValidMove(startRow, startCol, endRow, endCol)) {

                // Makes the move
                checkersGameLogic.setSquare(startRow, startCol, '_');
                checkersGameLogic.setSquare(endRow, endCol, startContent);
                turn++;

                // Loops through the game board and sets the colors of the buttons according to
                // their content
                updateBoard();
            } else {
                System.out.println("This move is invalid");
            }
            // Checks if it is the computers turn
            int one = 0;
            if (turn % 2 == 1) {
                // Loops through the game board looking for valid moves for the computer
                OUTER_LOOP: for (int row = 0; row < 8; row++) {
                    for (int column = 0; column < 8; column++) {
                        char currentSquare = checkersGameLogic.getSquare(row, column);
                        // if square isn't empty
                        if (currentSquare != '_') {
                            if (isValidMove(row, column, row - 1, column - 1)) {
                                checkersGameLogic.setSquare(row, column, '_');
                                checkersGameLogic.setSquare(row - 1, column - 1, 'o');
                                one++;
                                break OUTER_LOOP;
                            }
                            if (isValidMove(row, column, row - 1, column + 1)) {
                                checkersGameLogic.setSquare(row, column, '_');
                                checkersGameLogic.setSquare(row - 1, column + 1, 'o');
                                one++;
                                break OUTER_LOOP;
                            }

                        }
                    }
                }
                // Loops through the game board and sets the colors of the buttons according to
                // their content
                updateBoard();
                turn++;
            }
        } else {
            // Gets the winning player
            checkersGameLogic.getWinningPlayer();
        }
    }

    public boolean isValidMove(int startRow, int startCol, int endRow, int endCol) {

        if (endRow < 0 || endRow > 7 || endCol < 0 || endCol > 7) {
            return false;
        }

        if (startRow < 0 || startRow > 7 || startCol < 0 || startCol > 7) {
            return false;
        }

        // checks if the piece exists
        if (checkersGameLogic.getSquare(startRow, startCol) == '_') {
            return false;
        }

        // checks if there is no movement
        if (startRow == endRow && startCol == endCol) {
            return false;
        }

        // checks if the movement is diagonal
        if (Math.abs(startRow - endRow) != Math.abs(startCol - endCol)) {
            return false;
        }

        // check if destination is occupied
        if (checkersGameLogic.getSquare(endRow, endCol) != '_') {
            return false;
        }

        // checks if the movement is greater than two
        if (Math.abs(endRow - startRow) > 2) {
            return false;
        }

        // checks if the destination is an opponent piece
        if (checkersGameLogic.board[endRow][endCol] == 'x' && checkersGameLogic.board[startRow][startCol] == 'o') {
            return false;
        }
        if (checkersGameLogic.board[endRow][endCol] == 'o' && checkersGameLogic.board[startRow][startCol] == 'x') {
            return false;
        }

        // checks if the movement is the opposite direction of the team
        // check if the direction of the movement is opposite
        // checks if the movement is going in the opposite direction from the current
        // player
        if (startRow - endRow > 0 && turn % 2 == 0 ||
                startRow - endRow < 0 && turn % 2 == 1) {
            return false;
        }

        // check if movement is further than one
        if (Math.abs(startRow - endRow) == 2) {
            int middleRow = (startRow + endRow) / 2;
            int middleCol = (startCol + endCol) / 2;
            char middleContent = checkersGameLogic.getSquare(middleRow, middleCol);
            char startContent = checkersGameLogic.getSquare(startRow, startCol);
            // check if friendly piece is in the middle
            if (middleContent == startContent || middleContent == '_') {
                return false;
            } else {
                checkersGameLogic.setSquare(middleRow, middleCol, '_');
            }
        }

        // Check if the piece belongs to the current player
        if (turn % 2 == 0 && checkersGameLogic.getSquare(startRow, startCol) == 'o' ||
                turn % 2 == 1 && checkersGameLogic.getSquare(startRow, startCol) == 'x') {
            return false;
        }

        // returns true if all criteria is met
        return true;
    }

    public void updateBoard() {
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                // Gets the content of the square
                char content = checkersGameLogic.getSquare(row, column);
                Button btn = (Button) board.getChildren().get(row * 8 + column);
                // Sets the style of the square according to the content
                if (content == 'x') {
                    btn.setStyle("-fx-border-color: black; -fx-background-color: #000000");
                } else if (content == 'o') {
                    btn.setStyle("-fx-border-color: black; -fx-background-color: #FFFFFF");
                } else if (content == '_' && row % 2 == 0 && column % 2 == 0) {
                    btn.setStyle("-fx-border-color: #A52A2A; -fx-background-color: #A52A2A");
                } else if (content == '_' && row % 2 == 1 && column % 2 == 1) {
                    btn.setStyle("-fx-border-color: #A52A2A; -fx-background-color: #A52A2A");
                }
            }
        }

    }
}