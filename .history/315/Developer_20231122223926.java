// Developer class
public class Developer {
    private String username;
    private int credits;

    // Constructor
    public Developer(String username, int credits) {
        this.username = username;
        this.credits = credits;
    }

    // Getter and setter methods
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    // Method to initiate the add game process
    public void initiateAddGame(String gameName, boolean multiplayer) {
        HandleDevs handleDevs = new HandleDevs();
        handleDevs.addGame(this.username, gameName, multiplayer);
    }
}