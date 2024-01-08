
public class SpellAttack implements AttackStrategy {
    @Override
    public int performAttack(Character character) {
        Random random = new Random();
        int spellDamage = random.nextInt(5);
        return character.getStrength() + spellDamage;
    }
}
