// Game class
public class Game {
    private String gameName;
    private boolean isMultiplayer;
    private boolean isApproved;

    // Constructor
    public Game(String gameName, boolean isMultiplayer) {
        this.gameName = gameName;
        this.isMultiplayer = isMultiplayer;
        // New games are not approved by default
        this.isApproved = false;
    }

    // Getter and setter methods as needed
}