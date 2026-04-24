public class InputValidator {

    public static void validateNotEmpty(String value, String field) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(field + " cannot be empty.");
        }
    }

    public static void validatePositive(double value, String field) {
        if (value <= 0) {
            throw new IllegalArgumentException(field + " must be greater than zero.");
        }
    }

    public static void validatePositive(int value, String field) {
        if (value <= 0) {
            throw new IllegalArgumentException(field + " must be greater than zero.");
        }
    }

    public static void validateLoanType(String type) {
        String[] validTypes = {"personal", "home", "car", "business", "student", "agricultural"};
        for (String t : validTypes) {
            if (t.equalsIgnoreCase(type)) return;
        }
        throw new IllegalArgumentException("Invalid loan type. Must be one of: Personal, Home, Car, Business, Student, Agricultural.");
    }

    public static void validatePhone(String phone) {
        if (!phone.matches("^0[7-9]\\d{8}$") && !phone.matches("^\\+250[7-9]\\d{8}$")) {
            throw new IllegalArgumentException("Invalid phone number format. Use 07xxxxxxxx or +2507xxxxxxxx.");
        }
    }

    public static void validateNationalID(String id) {
        if (!id.matches("\\d{16}")) {
            throw new IllegalArgumentException("National ID must be exactly 16 digits.");
        }
    }
}
