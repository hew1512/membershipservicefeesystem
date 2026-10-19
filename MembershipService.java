import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MembershipService {

    private final List<Member> members = new ArrayList<>();

    
    public void addMember(Member member) {
        if (member == null) {
            throw new IllegalArgumentException("Member cannot be null.");
        }
        if (findMemberById(member.getMemberId()).isPresent()) {
            throw new IllegalArgumentException(
                    "A member with ID '" + member.getMemberId() + "' already exists.");
        }
        members.add(member);
    }

    
    public Optional<Member> findMemberById(String memberId) {
        if (memberId == null) {
            return Optional.empty();
        }
        return members.stream()
                .filter(m -> m.getMemberId().equalsIgnoreCase(memberId.trim()))
                .findFirst();
    }

    public void updateMemberName(String memberId, String newName) {
        Member member = findMemberById(memberId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "No member found with ID '" + memberId + "'."));
        member.setName(newName);
    }

   
    public void updateMemberPlan(String memberId, MembershipPlan newPlan) {
        Member member = findMemberById(memberId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "No member found with ID '" + memberId + "'."));
        member.setPlan(newPlan);
    }

    public boolean removeMember(String memberId) {
        Optional<Member> member = findMemberById(memberId);
        member.ifPresent(members::remove);
        return member.isPresent();
    }

    public List<Member> getAllMembers() {
        return new ArrayList<>(members);
    }

    
    public void displayAllMembers() {
        if (members.isEmpty()) {
            System.out.println("No members registered.");
            return;
        }
        System.out.println("---- Member List ----");
        for (Member member : members) {
            System.out.println(member);
        }
        System.out.println("----------------------");
    }

    
    public double calculateTotalMonthlyRevenue() {
        double total = 0;
        for (Member member : members) {
            total += member.getMonthlyFee();
        }
        return total;
    }
}
