public class Product3 implements GetProductsTo, DeliveryAPI {
    private String type;
    private double price;
    private int idOfProvider;
    private int number;

    public Product3(String type, double price, int idOfProvider, int number) {
        this.type = type;
        this.price = price;
        this.idOfProvider = idOfProvider;
        this.number = number;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int getNumber(int idOfProvider) {
        return (this.idOfProvider == idOfProvider) ? number : 0;
    }

    @Override
    public String getType(int idOfProvider) {
        return (this.idOfProvider == idOfProvider) ? type : null;
    }

    @Override
    public int getIdOfProvider() {
        return idOfProvider;
    }
}