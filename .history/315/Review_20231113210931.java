package org.example;

class Review {
    private String content;
    private int rating;
    private String id;

    public Review(String content, int rating, String id) {
        this.content = content;
        this.rating = rating;
        this.id = id;
    }

    public String getId() {
        return id;
    }

}
