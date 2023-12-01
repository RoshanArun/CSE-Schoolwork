public class HandleDevs {

    public void addGame(String username, String gameName, boolean multiplayer) {
        Developer developer = findDeveloperByUsername(username);
        if (developer != null && checkCredits(developer)) {
            HandleGames handleGames = new HandleGames();
            if (handleGames.checkGameName(gameName)) {
                Game game = createGame(gameName, multiplayer);
                notifyDeveloper(developer, "Game added successfully, waiting for approval.");
                notifyAdmin(game);
            } else {
                notifyDeveloper(developer, "Game name is already being used.");
            }
        } else {
            notifyDeveloper(developer, "Not enough credits.");
        }
    }

    private Developer findDeveloperByUsername(String username) {
        return new Developer(username, 100); // Mock developer with sufficient credits
    }

    private boolean checkCredits(Developer developer) {
        return developer.getCredits() > 99;
    }

    private Game createGame(String gameName, boolean multiplayer) {
        return new Game(gameName, multiplayer);
    }

    private void notifyDeveloper(Developer developer, String message) {
        System.out.println("Notification to developer " + developer.getUsername() + ": " + message);
    }

    private void notifyAdmin(Game game) {
        Admin admin = new Admin();
        admin.reviewNewGame(game);
    }
}