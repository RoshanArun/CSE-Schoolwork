
class Review {
    private String con;
    private int rating;
    private String id;

    public Review(String content, int rating, String id) {
        this.con = content;
        this.rating = rating;
        this.id = id;
    }

    public String getId() {
        return id;
    }

}
