import java.util.ArrayList;

public class PresentStore {
    private ArrayList<GetProductsTo> products;
    private ArrayList<DeliveryAPI> devApi;

    public PresentStore() {
        this.products = new ArrayList<>();
        this.devApi = new ArrayList<>();
    }

    public void addProduct(GetProductsTo product) {
        products.add(product);
    }

    public void addDeliveryAPI(DeliveryAPI deliveryAPI) {
        devApi.add(deliveryAPI);
    }

    public ArrayList<GetProductsTo> getProductsByMaxPrice(double maxPrice) {
        ArrayList<GetProductsTo> result = new ArrayList<>();
        for (GetProductsTo product : products) {
            if (product.getPrice() <= maxPrice) {
                result.add(product);
            }
        }
        return result;
    }

    public ArrayList<GetProductsTo> getProductsByProviderId(int idOfProvider) {
        ArrayList<GetProductsTo> result = new ArrayList<>();
        for (DeliveryAPI deliveryAPI : devApi) {
            if (deliveryAPI.getIdOfProvider() == idOfProvider) {
                for (GetProductsTo product : products) {
                    if (deliveryAPI.getType(idOfProvider).equals(product.getType())) {
                        result.add(product);
                    }
                }
            }
        }
        return result;
    }
}