public class Game {
    private int gameID;
    private String title;

    public Game(int gameID, String title) {
        this.gameID = gameID;
        this.title = title;
    }

    public int getGameId() {
        return gameID;
    }
}