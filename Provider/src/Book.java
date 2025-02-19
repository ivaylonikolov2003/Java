
public class Book extends Product{
    private String author;
    private String title;

    Book(int inventoryNumber, double price, int quantity, Provider provider, String author, String title) {
        super(inventoryNumber, price, quantity, provider);
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    double getPromotionalPrice() {
        return getPrice() * 0.5;
    }

    @Override
    boolean sellProduct(int piece) throws NoMoreProductsException {
        if (getQuantity() >= piece) {
            setQuantity(getQuantity() - piece);
            return true;
        } else {
            throw new NoMoreProductsException("Not enough quantity available");
        }
    }
}