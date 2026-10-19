import java.util.Optional;
public class App {

    public static void main(String[] args) {

        MembershipService service = new MembershipService();

        
        Member standardMember = new Member("M001", "Somchai Prasert", new StandardPlan(500));
        Member premiumMember = new Member("M002", "Nattaya Chaiyaporn", new PremiumPlan(500));
        Member familyMember = new Member("M003", "Wichai Boonmee", new FamilyPlan(500, 3));

        
        System.out.println("=== Adding Members ===");
        service.addMember(standardMember);
        service.addMember(premiumMember);
        service.addMember(familyMember);
        System.out.println("3 members added successfully.\n");

        
        System.out.println("=== All Members ===");
        service.displayAllMembers();
        System.out.println();

      
        System.out.println("=== Searching Members ===");
        String existingId = "M002";
        Optional<Member> found = service.findMemberById(existingId);
        System.out.println("Search for '" + existingId + "': "
                + (found.isPresent() ? found.get() : "Not found"));

        String missingId = "M999";
        Optional<Member> notFound = service.findMemberById(missingId);
        System.out.println("Search for '" + missingId + "': "
                + (notFound.isPresent() ? notFound.get() : "Not found"));
        System.out.println();

       
        System.out.println("=== Updating Member M001 ===");
        System.out.println("Before update: " + service.findMemberById("M001").get());
        service.updateMemberName("M001", "Somchai P. Sirikul");
        service.updateMemberPlan("M001", new PremiumPlan(500));
        System.out.println("After update:  " + service.findMemberById("M001").get());
        System.out.println();

        
        System.out.println("=== Removing Member M003 ===");
        boolean removed = service.removeMember("M003");
        System.out.println("Member M003 removed: " + removed);
        service.displayAllMembers();
        System.out.println();

        
        System.out.println("=== Total Monthly Revenue ===");
        System.out.printf("Total expected monthly revenue: %.2f baht%n",
                service.calculateTotalMonthlyRevenue());
        System.out.println();

        
        System.out.println("=== Attempting Invalid Operations ===");

       
        try {
            service.addMember(new Member("M001", "Duplicate Person", new StandardPlan(400)));
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected duplicate ID: " + e.getMessage());
        }

        
        try {
            new Member("   ", "No ID Person", new StandardPlan(400));
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected blank ID: " + e.getMessage());
        }

      
        try {
            new Member("M004", "", new StandardPlan(400));
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected blank name: " + e.getMessage());
        }

        
        try {
            new StandardPlan(0);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected non-positive base fee: " + e.getMessage());
        }

        
        try {
            new FamilyPlan(500, -2);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected negative family member count: " + e.getMessage());
        }

       
        try {
            new Member("M005", "No Plan Person", null);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected member with no plan: " + e.getMessage());
        }

      
        boolean removalResult = service.removeMember("M999");
        System.out.println("Attempted removal of nonexistent member M999: "
                + (removalResult ? "removed" : "not found, nothing removed"));
    }
}
