import java.util.Random;

public class PhysicalDefense implements DefenseStrategy {
    @Override
    public int performDefense(Character character) {
        Random random = new Random();
        int damageTaken = random.nextInt(15) - character.getResilience();
        return Math.max(damageTaken, 0);
    }
}