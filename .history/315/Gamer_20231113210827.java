import java.util.ArrayList;
import java.util.List;

class Gamer {
    private String username;
    private List<Game> ownedGames = new ArrayList<>();

    public Gamer(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void linkGame(Game game) {
        ownedGames.add(game);
    }
}