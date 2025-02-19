import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProductLoader implements ImportData {
    private String fileName;

    public ProductLoader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Object[] importDataFromFile() throws IOException, WrongPhoneNumberException, NoMoreProductsException {
        Object[] products = new Object[getNumberOfRows()];

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int index = 0;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split("#");

                int type = Integer.parseInt(data[0]);

                Provider provider = new Provider(data[1], data[2]);

                if (type == 1) {
                    products[index] = new Electronics(
                            Integer.parseInt(data[3]),
                            Double.parseDouble(data[4]),
                            Integer.parseInt(data[5]),
                            provider,
                            data[6],
                            data[7]
                    );
                } else if (type == 2) {
                    products[index] = new Book(
                            Integer.parseInt(data[3]),
                            Double.parseDouble(data[4]),
                            Integer.parseInt(data[5]),
                            provider,
                            data[6],
                            data[7]
                    );
                }

                index++;
            }
        }

        return products;
    }

    public int getNumberOfRows() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int lines = 0;
            while (reader.readLine() != null) {
                lines++;
            }
            return lines;
        }
    }

}