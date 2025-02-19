
public class Electronics extends Product {
    private String manufacturer;
    private String model;

    public Electronics(int inventoryNumber, double price, int quantity, Provider provider, String manufacturer, String model) throws NoMoreProductsException, WrongPhoneNumberException {
        super(inventoryNumber, price, quantity, provider);
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    @Override
    public double getPromotionalPrice() {
        return getPrice() * 0.9;
    }

    @Override
    public boolean sellProduct(int piece) throws NoMoreProductsException {
        if (getQuantity() >= piece) {
            setQuantity(getQuantity() - piece);
            return true;
        } else {
            throw new NoMoreProductsException("Няма достатъчно количество от продукта.");
        }
    }
}