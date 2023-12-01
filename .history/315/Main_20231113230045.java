public class Main {
    public static void main(String[] args) {
        ReviewManagement rev = new ReviewManagement();
        DevManagement dev = new DevManagement();
        GameManagement gC = new GameManagement();
        GamerManagement Gc = new GamerManagement();

        Gamer one = new Gamer("Jack");
        Gamer two = new Gamer("Jill");
        Game game1 = new Game(1, "Game 1");
        Game game2 = new Game(2, "Game 2");
        Dev developer1 = new Dev("Developer One");

        Gc.addGamer(one);
        Gc.addGamer(two);
        dev.addDev(developer1);
        gC.addGame(game1);
        gC.addGame(game2);
        Gc.linkGameToGamer(one, game1);
        Gc.linkGameToGamer(two, game2);

        rev.createReview(one, game1, "Great game!", 5);
        rev.createReview(two, game2, "Good Game!.", 4);
        rev.createReview(one, game1, "Decent Game!", 3);
        displaySystemState(Gc, gC, rev, dev);
    }

    private static void displaySystemState(
            GamerManagement gamerControl,
            GameManagement gameControl,
            ReviewManagement rev,
            DevManagement dev) {
    }
}
