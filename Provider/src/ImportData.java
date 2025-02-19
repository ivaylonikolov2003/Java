import java.io.IOException;

interface ImportData {
    Object[] importDataFromFile() throws IOException, WrongPhoneNumberException, NoMoreProductsException;
}
