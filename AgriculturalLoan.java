public class AgriculturalLoan extends LoanManager {
    private double farmSize;

    public AgriculturalLoan(String loanID, double loanAmount, double interestRate,
                            int loanDuration, String officerName, String branchLocation,
                            double farmSize) {
        super(loanID, "Agricultural Loan", loanAmount, interestRate, loanDuration, "Pending",
                officerName, branchLocation);
        this.farmSize = farmSize;
    }

    public double getFarmSize() { return farmSize; }
    public void setFarmSize(double farmSize) { this.farmSize = farmSize; }

    @Override
    public boolean checkEligibility() {
        return super.checkEligibility() && farmSize > 1.0;
    }

    @Override
    public String toString() {
        return super.toString() + "\nFarm Size: " + farmSize + " hectares";
    }
}
