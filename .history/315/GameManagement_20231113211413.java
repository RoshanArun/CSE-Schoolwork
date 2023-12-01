import java.util.ArrayList;
import java.util.List;

class GameManagement {
    private List<Game> gameId;

    public GameManagement() {
        this.gameId = new ArrayList<>();
    }

    public void addGame(Game game) {
        gameId.add(game);
    }
}