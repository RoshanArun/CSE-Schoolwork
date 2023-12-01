import java.util.ArrayList;
import java.util.List;

class GameManagement {
    private List<Game> g;

    public GameManagement() {
        this.g = new ArrayList<>();
    }

    public void addGame(Game game) {
        g.add(game);
    }
}