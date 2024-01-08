public class Main {
    public static void main(String[] args) {
        Character orc = new Orc();
        Character elf = new Elf();

        int damageDealtByOrc = orc.attackEnemy();
        System.out.println("Orc attacked and dealt " + damageDealtByOrc + " damage");

        int damageTakenByElf = elf.takeHit();
        System.out.println("Elf took a hit and received " + damageTakenByElf + " damage");
    }
}