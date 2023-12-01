import java.util.ArrayList;
import java.util.List;

class ReviewManagement {
    private List<Review> reviews;

    public ReviewManagement() {
        this.reviews = new ArrayList<>();
    }

    public void createReview(Gamer gamer, Game game, String content, int rating) {
        if (gamerOwnsGame(gamer, game) && !gamerAlreadyReviewed(gamer, game)) {
            Review newReview = new Review(content, rating, gamer.getUsername() + "_" + game.getGameId());
            reviews.add(newReview);

            System.out.println("Review: " + newReview);
        }
    }

    private boolean gamerOwnsGame(Gamer gamer, Game game) {
        return false;
    }

    private boolean gamerAlreadyReviewed(Gamer gamer, Game game) {
        return false;
    }
}
