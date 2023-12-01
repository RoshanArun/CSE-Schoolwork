public class Main {
    public static void main(String[] args) {
        ReviewManagement revMan = new ReviewManagement();
        DevManagement devMan = new DevManagement();
        GameManagement gC = new GameManagement();
        GamerManagement Gc = new GamerManagement();

        Gamer one = new Gamer("Jack");
        Gamer two = new Gamer("Jill");
        Game game1 = new Game(1, "Game 1");
        Game game2 = new Game(2, "Game 2");
        Dev developer = new Dev("Developer One");

        Gc.addGamer(one);
        Gc.addGamer(two);
        devMan.addDev(developer);
        gC.addGame(game1);
        gC.addGame(game2);
        Gc.linkGameToGamer(one, game1);
        Gc.linkGameToGamer(two, game2);

        revMan.createReview(one, game1, "Great game!", 5);
        revMan.createReview(two, game2, "Good Game!.", 4);
        revMan.createReview(one, game1, "Decent Game!", 3);
        displaySystemState(Gc, gC, revMan, devMan);
    }

    private static void displaySystemState(
            GamerManagement gamerControl,
            GameManagement gameControl,
            ReviewManagement rev,
            DevManagement dev) {
    }
}
