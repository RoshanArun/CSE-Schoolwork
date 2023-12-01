import java.util.ArrayList;
import java.util.List;

class GameManagement {
    private List<Game> gam;

    public GameManagement() {
        this.gam = new ArrayList<>();
    }

    public void addGame(Game game) {
        gam.add(game);
    }
}