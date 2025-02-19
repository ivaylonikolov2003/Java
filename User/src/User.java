class User implements ValidatePhone {
    private String username;
    private String password;
    private String phoneNumber;

    public User(String username, String password, String phoneNumber) throws WrongUserException, WrongPhoneNumberException {
        setUsername(username);
        setPassword(password);
        setPhoneNumber(phoneNumber);
    }

    public void setUsername(String username) throws WrongUserException {
        if (!UsernameValidator.isValidUsername(username)) {
            throw new WrongUserException("Invalid username.");
        }
        this.username = username;
    }

    public void setPassword(String password) throws WrongUserException {
        if (!PasswordValidator.isValidPassword(password)) {
            throw new WrongUserException("Invalid password.");
        }
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) throws WrongPhoneNumberException {
        if (!ValidatePhone.validatePhoneNumber(phoneNumber)) {
            throw new WrongPhoneNumberException("Invalid phone number.");
        }
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}