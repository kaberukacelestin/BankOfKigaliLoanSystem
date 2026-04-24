public class CarLoan extends LoanManager {
    private String carModel;

    public CarLoan(String loanID, double loanAmount, double interestRate,
                   int loanDuration, String officerName, String branchLocation,
                   String carModel) {
        super(loanID, "Car Loan", loanAmount, interestRate, loanDuration, "Pending",
                officerName, branchLocation);
        this.carModel = carModel;
    }

    public String getCarModel() { return carModel; }
    public void setCarModel(String carModel) { this.carModel = carModel; }

    @Override
    public double calculateInterest() { return super.calculateInterest() * 0.9; }

    @Override
    public boolean checkEligibility() { return super.checkEligibility() && getLoanAmount() <= 30000; }

    @Override
    public String toString() {
        return super.toString() + "\nCar Model: " + carModel;
    }
}
