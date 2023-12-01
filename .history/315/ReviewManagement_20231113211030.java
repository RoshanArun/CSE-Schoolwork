import java.util.ArrayList;
import java.util.List;

class ReviewManagement {
    private List<Review> reviews;

    public ReviewManagement() {
        this.reviews = new ArrayList<>();
    }

    public void createReview(Gamer gamer, Game game, String content, int rating) {
        // Check if the gamer owns the game and hasn't already reviewed it
        if (gamerOwnsGame(gamer, game) && !gamerAlreadyReviewed(gamer, game)) {
            // Add the new review to the reviews list
            Review newReview = new Review(content, rating, gamer.getUsername() + "_" + game.getGameId());
            reviews.add(newReview);

            // Print some output or log the action
            System.out.println("Review created: " + newReview);
        } else {
            // Handle cases where the gamer doesn't own the game or has already reviewed it

        }
    }

    private boolean gamerOwnsGame(Gamer gamer, Game game) {
        // Implement logic to check if the gamer owns the game

        return false; // Placeholder
    }

    private boolean gamerAlreadyReviewed(Gamer gamer, Game game) {
        // Implement logic to check if the gamer has already reviewed the game

        return false; // Placeholder
    }
    // remaining functions abstracted, just using what's necessary for assignment
}
