public class Repayment {
    private String paymentID;
    private Loan loan;
    private double amountPaid;
    private String paymentDate;
    private double remainingBalance;

    public Repayment(String paymentID, Loan loan, double amountPaid, String paymentDate, double remainingBalance) {
        this.paymentID = paymentID;
        this.loan = loan;
        this.amountPaid = amountPaid;
        this.paymentDate = paymentDate;
        this.remainingBalance = remainingBalance;
    }

    public void updateRemainingBalance(double newBalance) {
        this.remainingBalance = newBalance;
    }

    @Override
    public String toString() {
        return "Payment ID: " + paymentID +
                "\nLoan ID: " + loan.getLoanID() +
                "\nAmount Paid: $" + String.format("%.2f", amountPaid) +
                "\nDate: " + paymentDate +
                "\nRemaining Balance: $" + String.format("%.2f", remainingBalance);
    }
}
