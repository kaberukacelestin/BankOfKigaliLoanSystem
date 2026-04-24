import java.util.Scanner;

public class LoanSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Bank of Kigali Loan Management System ===\n");

        System.out.print("Enter Customer ID: ");
        String custID = scanner.nextLine();
        InputValidator.validateNotEmpty(custID, "Customer ID");

        System.out.print("Enter Customer Name: ");
        String custName = scanner.nextLine();
        InputValidator.validateNotEmpty(custName, "Customer Name");

        System.out.print("Enter National ID (16 digits): ");
        String natID = scanner.nextLine();
        InputValidator.validateNationalID(natID);

        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine();
        InputValidator.validatePhone(phone);

        Customer customer = new Customer(custID, custName, natID, phone);
        System.out.println("\nCustomer created successfully!\n" + customer);

        String loanID, loanType, officer, branch, specificStr;
        double amount = 0, rate = 0;
        int duration = 0;
        Object specificValue = null;

        while (true) {
            try {
                System.out.print("\nEnter Loan ID: ");
                loanID = scanner.nextLine();
                InputValidator.validateNotEmpty(loanID, "Loan ID");

                System.out.print("\nCHOOSE LOAN TYPE Personal, Home, Car, Business, Student, Agricultural: ");
                loanType = scanner.nextLine();
                InputValidator.validateLoanType(loanType);

                System.out.print("Enter Loan Amount: ");
                amount = Double.parseDouble(scanner.nextLine());
                InputValidator.validatePositive(amount, "Loan Amount");

                System.out.print("Enter Interest Rate (%): ");
                rate = Double.parseDouble(scanner.nextLine());
                InputValidator.validatePositive(rate, "Interest Rate");

                System.out.print("Enter Duration (months): ");
                duration = Integer.parseInt(scanner.nextLine());
                InputValidator.validatePositive(duration, "Duration");

                System.out.print("Enter Officer Name: ");
                officer = scanner.nextLine();
                InputValidator.validateNotEmpty(officer, "Officer Name");

                System.out.print("Enter Branch Location: ");
                branch = scanner.nextLine();
                InputValidator.validateNotEmpty(branch, "Branch Location");

                if (loanType.equalsIgnoreCase("personal") || loanType.equalsIgnoreCase("car") ||
                        loanType.equalsIgnoreCase("business") || loanType.equalsIgnoreCase("student")) {
                    System.out.print("Enter specific value (purpose/model/type/university): ");
                    specificStr = scanner.nextLine();
                    specificValue = specificStr;
                } else if (loanType.equalsIgnoreCase("home") || loanType.equalsIgnoreCase("agricultural")) {
                    System.out.print("Enter numeric specific value (property value / farm size): ");
                    specificValue = Double.parseDouble(scanner.nextLine());
                }

                break;
            } catch (Exception e) {
                System.out.println(" " + e.getMessage() + " Please try again.\n");
            }
        }

        LoanManager loan = LoanFactory.createLoan(loanType, loanID, amount, rate, duration, officer, branch, specificValue);

        if (loan.approveLoan()) {
            System.out.println("\n Loan APPROVED (inguzanyo yemejwe)!\n" + loan.generateLoanReport());
        } else {
            System.out.println("\n Loan REJECTED! (inguzanyo yanzwe)");
            return;
        }

        System.out.print("\nEnter Payment Amount: ");
        double paymentAmount = Double.parseDouble(scanner.nextLine());
        InputValidator.validatePositive(paymentAmount, "Payment Amount");

        loan.processPayment(paymentAmount);
        System.out.println("\n" + loan.generatePaymentReceipt());

        Repayment repayment = new Repayment("PAY-" + loanID, loan, paymentAmount,
                new java.util.Date().toString(), loan.calculateRemainingBalance());
        repayment.updateRemainingBalance(loan.calculateRemainingBalance());

        System.out.println("\n" + repayment);

        System.out.println("\n=== MURAKOZE KUTUGANA ===");
        scanner.close();
    }
}
