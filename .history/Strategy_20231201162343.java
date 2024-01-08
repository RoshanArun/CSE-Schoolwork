public class Strategy {
    public interface AttackStrategy {
        int performAttack(Character character);
    }

    public interface DefenseStrategy {
        int performDefense(Character character);
    }
}
