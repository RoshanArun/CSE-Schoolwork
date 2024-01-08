import java.util.Random;

public abstract class Character {
    protected String name;
    protected int strength;
    protected int resilience;
    private AttackStrategy attackStrategy;
    private DefenseStrategy defenseStrategy;

    public Character(AttackStrategy attackStrategy, DefenseStrategy defenseStrategy) {
        this.attackStrategy = attackStrategy;
        this.defenseStrategy = defenseStrategy;
    }

    public int attackEnemy() {
        return attackStrategy.performAttack(this);
    }

    public int takeHit() {
        return defenseStrategy.performDefense(this);
    }

    // Getters and setters for strength and resilience
    public int getStrength() {
        return strength;
    }

    public int getResilience() {
        return resilience;
    }
}
