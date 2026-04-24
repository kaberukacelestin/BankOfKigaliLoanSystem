import java.util.Date;

public class LoanManager extends Loan implements Payable {
    private String officerName;
    private String branchLocation;
    private double remainingBalance;
    private double lastPaymentAmount;

    public LoanManager() {
        super();
        this.officerName = "Unknown Officer";
        this.branchLocation = "Kigali Main";
        this.remainingBalance = 0.0;
        this.lastPaymentAmount = 0.0;
    }

    public LoanManager(String loanID, String loanType, double loanAmount,
                       double interestRate, int loanDuration, String loanStatus,
                       String officerName, String branchLocation) {
        super(loanID, loanType, loanAmount, interestRate, loanDuration, loanStatus);
        this.officerName = officerName;
        this.branchLocation = branchLocation;
        this.remainingBalance = loanAmount;
        this.lastPaymentAmount = 0.0;
    }

    public String getOfficerName() { return officerName; }
    public void setOfficerName(String officerName) { this.officerName = officerName; }
    public String getBranchLocation() { return branchLocation; }
    public void setBranchLocation(String branchLocation) { this.branchLocation = branchLocation; }
    public double getRemainingBalance() { return remainingBalance; }

    @Override
    public String toString() {
        return super.toString() +
                "\nOfficer: " + officerName +
                "\nBranch: " + branchLocation +
                "\nRemaining Balance: $" + String.format("%.2f", remainingBalance);
    }

    @Override
    public double calculateInterest() {
        return getLoanAmount() * (getInterestRate() / 100.0) * (getLoanDuration() / 12.0);
    }

    @Override
    public double calculateMonthlyInstallment() {
        double r = getInterestRate() / 100.0 / 12.0;
        int n = getLoanDuration();
        if (r == 0) return getLoanAmount() / n;
        return getLoanAmount() * r * Math.pow(1 + r, n) / (Math.pow(1 + r, n) - 1);
    }

    @Override
    public boolean checkEligibility() {
        return getLoanAmount() > 0 && getLoanDuration() > 0 && getInterestRate() >= 0;
    }

    @Override
    public boolean approveLoan() {
        if (checkEligibility()) {
            setLoanStatus("Approved");
            return true;
        }
        return false;
    }

    @Override
    public boolean rejectLoan() {
        setLoanStatus("Rejected");
        return true;
    }

    @Override
    public double calculateTotalRepayment() {
        return getLoanAmount() + calculateInterest();
    }

    @Override
    public String generateLoanReport() {
        return "=== LOAN REPORT ===\n" + toString() +
                "\nMonthly Installment: $" + String.format("%.2f", calculateMonthlyInstallment()) +
                "\nTotal Repayment: $" + String.format("%.2f", calculateTotalRepayment());
    }

    @Override
    public boolean validateLoanDetails() {
        return getLoanAmount() > 0 && getInterestRate() >= 0 && getLoanDuration() > 0 &&
                getLoanID() != null && !getLoanID().trim().isEmpty();
    }

    @Override
    public void processPayment(double amount) {
        if (amount > 0 && amount <= remainingBalance) {
            remainingBalance -= amount;
            lastPaymentAmount = amount;
        }
    }

    @Override
    public double calculateRemainingBalance() {
        return remainingBalance;
    }

    @Override
    public String generatePaymentReceipt() {
        return "=== PAYMENT RECEIPT ===\n" +
                "Loan ID: " + getLoanID() +
                "\nAmount Paid: $" + String.format("%.2f", lastPaymentAmount) +
                "\nRemaining Balance: $" + String.format("%.2f", remainingBalance) +
                "\nDate: " + new Date();
    }
}
