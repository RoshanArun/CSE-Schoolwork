import java.util.ArrayList;
import java.util.List;

    // Refactored Tree class
    class Tree implements FamilyMember {
        private String name;
        private List<FamilyMember> members = new ArrayList<>();

        public Tree(FamilyMember... members) {
            for (FamilyMember member : members) {
                this.members.add(member);
            }
            name = "tree" + members.hashCode();
        }

        public void print() {
            System.out.println(name);
            for (FamilyMember member : members) {
                member.print();
            }
        }
    }
}