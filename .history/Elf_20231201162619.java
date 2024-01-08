public class Elf extends Character {
    public Elf() {
        super(new SpellAttack(), new PhysicalDefense());
        this.name = "Elf";
        this.strength = 4;
        this.resilience = 2;
    }
}