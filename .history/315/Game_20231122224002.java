public class Game {
    private String gameName;
    private boolean isMultiplayer;
    private boolean isApproved;

    // Constructor
    public Game(String gameName, boolean isMultiplayer) {
        this.gameName = gameName;
        this.isMultiplayer = isMultiplayer;
        this.isApproved = false; // New games are not approved by default
    }

    // Getter and setter methods
    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public boolean isMultiplayer() {
        return isMultiplayer;
    }

    public void setMultiplayer(boolean multiplayer) {
        isMultiplayer = multiplayer;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }
}