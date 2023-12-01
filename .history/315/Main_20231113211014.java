public class Main {
    public static void main(String[] args) {
        // Create gamers, games, and initialize the system state
        Gamer gamer1 = new Gamer("user1");
        Gamer gamer2 = new Gamer("user2");
        Game game1 = new Game(101, "Game A");
        Game game2 = new Game(102, "Game B");
        GameManagement gameManagement = new GameManagement();
        ReviewManagement reviewManagement = new ReviewManagement();

        // Link gamers to games
        gameManagement.addGame(game1);
        gameManagement.addGame(game2);
        gameManagement.linkGameToGamer(gamer1, game1);
        gameManagement.linkGameToGamer(gamer2, game2);

        // Add reviews
        String reviewText = "This game is amazing!";
        int reviewStars = 5;
        String username = "user1";

        String result = addReview(gameManagement, reviewManagement, gamer1, game1, username, reviewStars, reviewText);
        System.out.println(result);
    }

    public static String addReview(
            GameManagement gameManagement,
            ReviewManagement reviewManagement,
            Gamer gamer,
            Game game,
            String username,
            int stars,
            String text) {
        // Check preconditions
        if (!gameManagement.isGamerLinkedToGame(gamer, game)) {
            return "does_not_own_game";
        }

        if (reviewManagement.hasGamerAlreadyReviewed(gamer, game)) {
            return "already_reviewed";
        }

        // Create a new review
        Review newReview = new Review(stars, text, gamer, game);

        // Update system state
        reviewManagement.addReview(newReview);

        // Notify the developer
        Developer.notifyNewReviewAdded(newReview);

        return "review_added";
    }
}