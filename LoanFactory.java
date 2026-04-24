public class LoanFactory {
    public static LoanManager createLoan(String loanType, String loanID, double loanAmount,
                                         double interestRate, int loanDuration,
                                         String officerName, String branchLocation,
                                         Object specificValue) {
        InputValidator.validateLoanType(loanType);

        switch (loanType.toLowerCase()) {
            case "personal":
                return new PersonalLoan(loanID, loanAmount, interestRate, loanDuration,
                        officerName, branchLocation, (String) specificValue);
            case "home":
                return new HomeLoan(loanID, loanAmount, interestRate, loanDuration,
                        officerName, branchLocation, (Double) specificValue);
            case "car":
                return new CarLoan(loanID, loanAmount, interestRate, loanDuration,
                        officerName, branchLocation, (String) specificValue);
            case "business":
                return new BusinessLoan(loanID, loanAmount, interestRate, loanDuration,
                        officerName, branchLocation, (String) specificValue);
            case "student":
                return new StudentLoan(loanID, loanAmount, interestRate, loanDuration,
                        officerName, branchLocation, (String) specificValue);
            case "agricultural":
                return new AgriculturalLoan(loanID, loanAmount, interestRate, loanDuration,
                        officerName, branchLocation, (Double) specificValue);
            default:
                throw new IllegalArgumentException("Unknown loan type");
        }
    }
}
