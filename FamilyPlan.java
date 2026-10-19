public class FamilyPlan extends MembershipPlan {

    private static final double FEE_PER_ADDITIONAL_MEMBER = 150.0;

    private int additionalFamilyMembers;

    public FamilyPlan(double baseFee, int additionalFamilyMembers) {
        super(baseFee);
        setAdditionalFamilyMembers(additionalFamilyMembers);
    }

    public int getAdditionalFamilyMembers() {
        return additionalFamilyMembers;
    }

    public void setAdditionalFamilyMembers(int additionalFamilyMembers) {
        if (additionalFamilyMembers < 0) {
            throw new IllegalArgumentException(
                    "Number of additional family members cannot be negative.");
        }
        this.additionalFamilyMembers = additionalFamilyMembers;
    }

    @Override
    public double calculateMonthlyFee() {
        return baseFee + (FEE_PER_ADDITIONAL_MEMBER * additionalFamilyMembers);
    }

    @Override
    public String getPlanName() {
        return "Family Plan";
    }

    @Override
    public String toString() {
        return String.format("%s (base fee: %.2f baht, +%d additional member(s))",
                getPlanName(), baseFee, additionalFamilyMembers);
    }
}
