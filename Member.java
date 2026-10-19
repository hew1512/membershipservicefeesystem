public class Member {

    private final String memberId;
    private String name;
    private MembershipPlan plan;

    public Member(String memberId, String name, MembershipPlan plan) {
        if (memberId == null || memberId.trim().isEmpty()) {
            throw new IllegalArgumentException("Member ID cannot be blank.");
        }
        setName(name);
        setPlan(plan);
        this.memberId = memberId.trim();
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Member name cannot be blank.");
        }
        this.name = name.trim();
    }

    public MembershipPlan getPlan() {
        return plan;
    }

    public void setPlan(MembershipPlan plan) {
        if (plan == null) {
            throw new IllegalArgumentException("A member must have a membership plan.");
        }
        this.plan = plan;
    }

    public double getMonthlyFee() {
        return plan.calculateMonthlyFee();
    }

    @Override
    public String toString() {
        return String.format("ID: %-6s | Name: %-15s | Plan: %-45s | Monthly Fee: %.2f baht",
                memberId, name, plan.toString(), getMonthlyFee());
    }
}
