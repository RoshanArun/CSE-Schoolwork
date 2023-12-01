// Developer class
public class Developer {
    private String username;
    private int credits;

    // Constructor
    public Developer(String username, int credits) {
        this.username = username;
        this.credits = credits;
    }

    // Method to initiate the add game process
    public void initiateAddGame(String gameName, boolean multiplayer) {
        HandleDevs handleDevs = new HandleDevs();
        handleDevs.addGame(this.username, gameName, multiplayer);
    }
}