import java.util.ArrayList;
import java.util.List;

class Gamer {
    private String username;
    private List<Game> owned = new ArrayList<>();

    public Gamer(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void linkGame(Game game) {
        owned.add(game);
    }
}