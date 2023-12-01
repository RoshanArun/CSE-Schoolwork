public class Review {
    private int stars;
    private String text;
    private Gamer reviewer;
    private Game game;

    public Review(int stars, String text, Gamer reviewer, Game game) {
        this.stars = stars;
        this.text = text;
        this.reviewer = reviewer;
        this.game = game;
    }

    // Getter methods
}