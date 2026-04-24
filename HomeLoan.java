public class HomeLoan extends LoanManager {
    private double propertyValue;

    public HomeLoan(String loanID, double loanAmount, double interestRate,
                    int loanDuration, String officerName, String branchLocation,
                    double propertyValue) {
        super(loanID, "Home Loan", loanAmount, interestRate, loanDuration, "Pending",
                officerName, branchLocation);
        this.propertyValue = propertyValue;
    }

    public double getPropertyValue() { return propertyValue; }
    public void setPropertyValue(double propertyValue) { this.propertyValue = propertyValue; }

    @Override
    public boolean checkEligibility() {
        return super.checkEligibility() && propertyValue >= getLoanAmount() * 1.2;
    }

    @Override
    public double calculateMonthlyInstallment() {
        return super.calculateMonthlyInstallment() * 0.95;
    }

    @Override
    public String toString() {
        return super.toString() + "\nProperty Value: $" + String.format("%.2f", propertyValue);
    }
}
