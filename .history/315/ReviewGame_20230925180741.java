public class ReviewGame {
    private String name = "";

    private int ID = 0;

    private int numStars = 0;

    private String Description = "";

    private int flagged = 0;

    public void Review(String name, int ID, int numStars, String Description, int flagged) {
        this.name = name;
        this.ID = ID;
        this.numStars = numStars;
        this.Description = Description;
        this.flagged = flagged;

        System.out.println(name);
        System.out.println(ID);
        System.out.println(numStars);
        System.out.println(Description);
        System.out.println(flagged);

    }

}