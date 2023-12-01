import java.util.ArrayList;
import java.util.List;

public class GamerManagement {
    private List<Gamer> gamers;

    public GamerManagement() {
        this.gamers = new ArrayList<>();
    }

    public void addGamer(Gamer gamer) {
        gamers.add(gamer);
    }

    public boolean gamerOwnsGame(Gamer gamer, Game game) {

        return false; // Placeholder
    }

    public void linkGameToGamer(Gamer gamer, Game game) {
        gamer.linkGame(game);
    }

    public boolean gamerAlreadyReviewed(Gamer gamer, Game game) {

        return false; // Placeholder
    }
}
