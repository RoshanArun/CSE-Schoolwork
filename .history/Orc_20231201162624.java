public class Orc extends Character {
    public Orc() {
        super(new SpellAttack(), new PhysicalDefense());
        this.name = "Orc";
        this.strength = 10;
        this.resilience = 9;
    }
}