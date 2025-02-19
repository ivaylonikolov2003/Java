import java.io.IOException;

public class BlackFriday {
    private static Electronics[] electronicsArray;
    private static Book[] bookArray;

    public static void processSales() {
        try {
            ProductLoader productLoader = new ProductLoader("salesproducts.txt");
            Object[] products = productLoader.importDataFromFile();

            int electronicsCount = 0;
            int bookCount = 0;
            for (Object product : products) {
                if (product instanceof Electronics) {
                    electronicsCount++;
                } else if (product instanceof Book) {
                    bookCount++;
                }
            }
            electronicsArray = new Electronics[electronicsCount];
            bookArray = new Book[bookCount];

            int electronicsIndex = 0;
            int bookIndex = 0;
            for (Object product : products) {
                if (product instanceof Electronics) {
                    electronicsArray[electronicsIndex] = (Electronics) product;
                    electronicsIndex++;
                } else if (product instanceof Book) {
                    bookArray[bookIndex] = (Book) product;
                    bookIndex++;
                }
            }
            System.out.println("Electronics for sale:");
            for (Electronics electronics : electronicsArray) {
                System.out.println("Manufacturer: " + electronics.getProvider().getName());
                System.out.println("Model: " + electronics.getManufacturer());
                System.out.println("Promotional price: " + electronics.getPromotionalPrice());
                System.out.println();
            }

            System.out.println("Books for sale:");
            for (Book book : bookArray) {
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Promotional price: " + book.getPromotionalPrice());
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

    public static void main(String[] args) {
        processSales();
    }
}
