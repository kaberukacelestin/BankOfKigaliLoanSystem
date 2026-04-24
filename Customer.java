public class Customer {
    private String customerID;
    private String customerName;
    private String nationalID;
    private String phoneNumber;

    public Customer(String customerID, String customerName, String nationalID, String phoneNumber) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.nationalID = nationalID;
        this.phoneNumber = phoneNumber;
    }

    public String getCustomerID() { return customerID; }
    public String getCustomerName() { return customerName; }
    public String getNationalID() { return nationalID; }
    public String getPhoneNumber() { return phoneNumber; }

    @Override
    public String toString() {
        return "Customer ID: " + customerID +
                "\nName: " + customerName +
                "\nNational ID: " + nationalID +
                "\nPhone: " + phoneNumber;
    }
}
