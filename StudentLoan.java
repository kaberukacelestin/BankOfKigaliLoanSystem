public class StudentLoan extends LoanManager {
    private String universityName;

    public StudentLoan(String loanID, double loanAmount, double interestRate,
                       int loanDuration, String officerName, String branchLocation,
                       String universityName) {
        super(loanID, "Student Loan", loanAmount, interestRate, loanDuration, "Pending",
                officerName, branchLocation);
        this.universityName = universityName;
    }

    public String getUniversityName() { return universityName; }
    public void setUniversityName(String universityName) { this.universityName = universityName; }

    @Override
    public double calculateInterest() { return super.calculateInterest() * 0.7; }

    @Override
    public String toString() {
        return super.toString() + "\nUniversity: " + universityName;
    }
}
