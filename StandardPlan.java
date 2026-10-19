public class StandardPlan extends MembershipPlan {

    public StandardPlan(double baseFee) {
        super(baseFee);
    }

    @Override
    public double calculateMonthlyFee() {
        return baseFee;
    }

    @Override
    public String getPlanName() {
        return "Standard Plan";
    }
}
