interface ValidatePhone {
    static boolean validatePhoneNumber(String phoneNumber) throws WrongPhoneNumberException {
        if (!phoneNumber.matches("\\d+")) {
            throw new WrongPhoneNumberException("Invalid phone number");
        }
        return true;
    }
}