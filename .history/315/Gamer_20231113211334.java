import java.util.ArrayList;
import java.util.List;

class Gamer {
    private String name;
    private List<Game> ownedGames = new ArrayList<>();

    public Gamer(String username) {
        this.name = username;
    }

    public String getUsername() {
        return name;
    }

    public void linkGame(Game game) {
        ownedGames.add(game);
    }
}