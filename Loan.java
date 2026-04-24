public abstract class Loan {
    private String loanID;
    private String loanType;
    private double loanAmount;
    private double interestRate;
    private int loanDuration;
    private String loanStatus;

    public Loan() {
        this.loanID = "UNKNOWN";
        this.loanType = "Unknown";
        this.loanAmount = 0.0;
        this.interestRate = 0.0;
        this.loanDuration = 0;
        this.loanStatus = "Pending";
    }

    public Loan(String loanID, String loanType, double loanAmount,
                double interestRate, int loanDuration, String loanStatus) {
        this.loanID = loanID;
        this.loanType = loanType;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.loanDuration = loanDuration;
        this.loanStatus = loanStatus;
    }

    public String getLoanID() { return loanID; }
    public void setLoanID(String loanID) { this.loanID = loanID; }
    public String getLoanType() { return loanType; }
    public void setLoanType(String loanType) { this.loanType = loanType; }
    public double getLoanAmount() { return loanAmount; }
    public void setLoanAmount(double loanAmount) { this.loanAmount = loanAmount; }
    public double getInterestRate() { return interestRate; }
    public void setInterestRate(double interestRate) { this.interestRate = interestRate; }
    public int getLoanDuration() { return loanDuration; }
    public void setLoanDuration(int loanDuration) { this.loanDuration = loanDuration; }
    public String getLoanStatus() { return loanStatus; }
    public void setLoanStatus(String loanStatus) { this.loanStatus = loanStatus; }

    @Override
    public String toString() {
        return "Loan ID: " + loanID +
                "\nLoan Type: " + loanType +
                "\nLoan Amount: $" + String.format("%.2f", loanAmount) +
                "\nInterest Rate: " + interestRate + "%" +
                "\nDuration: " + loanDuration + " months" +
                "\nStatus: " + loanStatus;
    }

    public abstract double calculateInterest();
    public abstract double calculateMonthlyInstallment();
    public abstract boolean checkEligibility();
    public abstract boolean approveLoan();
    public abstract boolean rejectLoan();
    public abstract double calculateTotalRepayment();
    public abstract String generateLoanReport();
    public abstract boolean validateLoanDetails();
}
