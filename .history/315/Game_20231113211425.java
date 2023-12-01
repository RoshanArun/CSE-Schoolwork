public class Game {
    private int gameId;
    private String title;

    public Game(int gameID, String title) {
        this.gameId = gameID;
        this.title = title;
    }

    public int getGameId() {
        return gameId;
    }
}