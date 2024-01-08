public class Main {
    public static void main(String[] args) {
        // Create a family tree
        FamilyMember p1 = new Person(1);
        FamilyMember p2 = new Person(2);
        FamilyMember p3 = new Person(3);
        FamilyMember p4 = new Person(4);

        FamilyMember t1 = new Tree(p1);
        FamilyMember t2 = new Tree(p2, p3);
        FamilyMember t3 = new Tree(t1, p4);
        FamilyMember t4 = new Tree(t3, t2);

        // Print the family tree
        t4.print();
    }
}