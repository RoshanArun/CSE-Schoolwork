// Admin class
public class Admin {
    public void reviewNewGame(Game game) {
        System.out.println("Admin is reviewing the game: " + game.getGameName());
        game.setApproved(true);
        System.out.println("Game " + game.getGameName() + " has been reviewed and approved.");
    }
}