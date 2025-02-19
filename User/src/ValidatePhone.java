interface ValidatePhone {
    static boolean validatePhoneNumber(String phoneNumber) throws WrongPhoneNumberException {
        if (phoneNumber.matches("[0-9]+")) {
            return true;
        } else {
            throw new WrongPhoneNumberException("Invalid phone number. It should only contain numbers.");
        }
    }
}