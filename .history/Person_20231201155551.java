// Refactored Person class
class Person implements FamilyMember {
    String name;

    public Person(int num) {
        name = "person" + num;
    }

    public void print() {
        System.out.println(name);
    }
}