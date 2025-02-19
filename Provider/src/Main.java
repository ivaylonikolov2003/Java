import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            ProductLoader productLoader = new ProductLoader("salesproducts.txt");
            Object[] products = productLoader.importDataFromFile();

            for (Object product : products) {
                if (product instanceof Electronics) {
                    Electronics electronics = (Electronics) product;
                    System.out.println("Electronics:");
                    System.out.println("Manufacturer: " + electronics.getProvider().getName());
                    System.out.println("Model: " + electronics.getManufacturer());
                    System.out.println("Promotional price: " + electronics.getPromotionalPrice());
                } else if (product instanceof Book) {
                    Book book = (Book) product;
                    System.out.println("Book:");
                    System.out.println("Author: " + book.getAuthor());
                    System.out.println("Title: " + book.getTitle());
                    System.out.println("Promotional price: " + book.getPromotionalPrice());
                }
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (WrongPhoneNumberException e) {
            e.printStackTrace();
        } catch (NoMoreProductsException e) {
            e.printStackTrace();
        }
    }
}