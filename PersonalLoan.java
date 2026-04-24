public class PersonalLoan extends LoanManager {
    private String purpose;

    public PersonalLoan(String loanID, double loanAmount, double interestRate,
                        int loanDuration, String officerName, String branchLocation,
                        String purpose) {
        super(loanID, "Personal Loan", loanAmount, interestRate, loanDuration, "Pending",
                officerName, branchLocation);
        this.purpose = purpose;
    }

    public String getPurpose() { return purpose; }
    public void setPurpose(String purpose) { this.purpose = purpose; }

    @Override
    public double calculateInterest() {
        return super.calculateInterest() * 1.05;
    }

    @Override
    public boolean checkEligibility() {
        return super.checkEligibility() && getLoanAmount() <= 50000;
    }

    @Override
    public String toString() {
        return super.toString() + "\nPurpose: " + purpose;
    }
}
