public abstract class MembershipPlan {

    protected double baseFee;

    protected MembershipPlan(double baseFee) {
        if (baseFee <= 0) {
            throw new IllegalArgumentException("Base fee must be greater than zero.");
        }
        this.baseFee = baseFee;
    }

    public double getBaseFee() {
        return baseFee;
    }

    public abstract double calculateMonthlyFee();

    public abstract String getPlanName();

    @Override
    public String toString() {
        return String.format("%s (base fee: %.2f baht)", getPlanName(), baseFee);
    }
}
