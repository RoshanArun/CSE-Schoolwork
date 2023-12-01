// HandleDevs class
public class HandleDevs {
    // Add game method which is the entry point for adding a game
    public void addGame(String username, String gameName, boolean multiplayer) {
        if (checkCredits(username)) {
            HandleGames handleGames = new HandleGames();
            if (handleGames.checkGameName(gameName)) {
                Game game = createGame(gameName, multiplayer);
                notifyAdmin(game);
            } else {
                notifyDeveloper("Game name is already in use.");
            }
        } else {
            notifyDeveloper("Not enough credits.");
        }
    }

    // Checks the available credits for the developer
    private boolean checkCredits(String username) {
        // Logic to check credits
        return true; // Placeholder return
    }

    // Creates a new game entry if conditions are met
    private Game createGame(String gameName, boolean multiplayer) {
        return new Game(gameName, multiplayer);
    }

    // Notify the developer about the status of game addition
    private void notifyDeveloper(String message) {
        // Logic to notify developer
    }

    // Notify the admin about a new game for review
    private void notifyAdmin(Game game) {
        Admin admin = new Admin();
        admin.reviewNewGame(game);
    }
}