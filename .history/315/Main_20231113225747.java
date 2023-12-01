import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Control classes
        ReviewManagement rev = new ReviewManagement();
        DevManagement dev = new DevManagement();
        GameManagement gameControl = new GameManagement();
        GamerManagement gamerControl = new GamerManagement();

        Gamer gamer1 = new Gamer("Alice");
        Gamer gamer2 = new Gamer("Bob");
        Game game1 = new Game(1, "Game A");
        Game game2 = new Game(2, "Game B");
        Dev developer1 = new Dev("Developer X");

        gamerControl.addGamer(gamer1);
        gamerControl.addGamer(gamer2);
        dev.addDev(developer1);
        gameControl.addGame(game1);
        gameControl.addGame(game2);

        gamerControl.linkGameToGamer(gamer1, game1);
        gamerControl.linkGameToGamer(gamer2, game2);

        rev.createReview(gamer1, game1, "Great game!", 5);
        rev.createReview(gamer2, game2, "Not bad.", 4);
        rev.createReview(gamer1, game1, "Awesome!", 3);
        displaySystemState(gamerControl, gameControl, rev, dev);
    }

    private static void displaySystemState(
            GamerManagement gamerControl,
            GameManagement gameControl,
            ReviewManagement rev,
            DevManagement dev) {
    }
}
