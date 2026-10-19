public class PremiumPlan extends MembershipPlan {

    private static final double PREMIUM_SURCHARGE = 300.0;

    public PremiumPlan(double baseFee) {
        super(baseFee);
    }

    @Override
    public double calculateMonthlyFee() {
        return baseFee + PREMIUM_SURCHARGE;
    }

    @Override
    public String getPlanName() {
        return "Premium Plan";
    }
}
