public class ReviewGame {
    private string name = "";

    private int ID = 0;

    private int numStars = 0;

    private string Description = "";

    private int flagged = 0;

    public Review(int name, int ID, int numStars, string Description, int flagged) {
		this.name = name;
		this.ID = ID;
		this.numStars = numStars;
		this.developers = Description;
        this.flagged = flagged; 

        System.out.println(name);
        System.out.println(ID);
        System.out.println(numStars);
        System.out.println(Description);
        System.out.println(flagged);

	}

}