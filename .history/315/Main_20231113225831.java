public class Main {
    public static void main(String[] args) {
        ReviewManagement rev = new ReviewManagement();
        DevManagement dev = new DevManagement();
        GameManagement gameControl = new GameManagement();
        GamerManagement gamerControl = new GamerManagement();

        Gamer one = new Gamer("Jack");
        Gamer two = new Gamer("Jill");
        Game game1 = new Game(1, "Game 1");
        Game game2 = new Game(2, "Game 2");
        Dev developer1 = new Dev("Developer One");

        gamerControl.addGamer(one);
        gamerControl.addGamer(two);
        dev.addDev(developer1);
        gameControl.addGame(game1);
        gameControl.addGame(game2);
        gamerControl.linkGameToGamer(one, game1);
        gamerControl.linkGameToGamer(two, game2);

        rev.createReview(one, game1, "Great game!", 5);
        rev.createReview(two, game2, "Not bad.", 4);
        rev.createReview(one, game1, "Awesome!", 3);
        displaySystemState(gamerControl, gameControl, rev, dev);
    }

    private static void displaySystemState(
            GamerManagement gamerControl,
            GameManagement gameControl,
            ReviewManagement rev,
            DevManagement dev) {
    }
}
