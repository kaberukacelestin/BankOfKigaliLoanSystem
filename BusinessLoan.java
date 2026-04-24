public class BusinessLoan extends LoanManager {
    private String businessType;

    public BusinessLoan(String loanID, double loanAmount, double interestRate,
                        int loanDuration, String officerName, String branchLocation,
                        String businessType) {
        super(loanID, "Business Loan", loanAmount, interestRate, loanDuration, "Pending",
                officerName, branchLocation);
        this.businessType = businessType;
    }

    public String getBusinessType() { return businessType; }
    public void setBusinessType(String businessType) { this.businessType = businessType; }

    @Override
    public boolean approveLoan() {
        boolean approved = super.approveLoan();
        if (approved) setLoanStatus("Business Approved");
        return approved;
    }

    @Override
    public String toString() {
        return super.toString() + "\nBusiness Type: " + businessType;
    }
}
