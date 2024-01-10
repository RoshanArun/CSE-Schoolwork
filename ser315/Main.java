public class Main {
    public static void main(String[] args) {
        // Create an instance of the developer who will add the game
        Developer developer = new Developer("devUsername", 150); // Assuming the developer starts with 150 credits

        // Simulate the developer initiating the add game process
        developer.initiateAddGame("New Awesome Game", true);

        // Output to show the process is complete
        System.out.println("Game addition process initiated.");
    }
}