import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        try {
            PresentStore store = new PresentStore();

            Product1 product1 = new Product1("Type1", 20.0, 1, 50);
            Product2 product2 = new Product2("Type2", 30.0, 1, 30);
            Product3 product3 = new Product3("Type3", 25.0, 2, 40);

            store.addProduct(product1);
            store.addProduct(product2);
            store.addProduct(product3);

            store.addDeliveryAPI(product1);
            store.addDeliveryAPI(product2);
            store.addDeliveryAPI(product3);

            double maxPrice = 25.0;
            ArrayList<GetProductsTo> productsByMaxPrice = store.getProductsByMaxPrice(maxPrice);

            System.out.println("Products with price less than or equal to " + maxPrice + ":");
            for (GetProductsTo product : productsByMaxPrice) {
                System.out.println("Type: " + product.getType() + ", Price: " + product.getPrice());
            }

            int providerId = 1;
            ArrayList<GetProductsTo> productsByProviderId = store.getProductsByProviderId(providerId);

            System.out.println("\nProducts from provider with id " + providerId + ":");
            for (GetProductsTo product : productsByProviderId) {
                System.out.println("Type: " + product.getType() + ", Quantity: " + ((DeliveryAPI) product).getNumber(providerId));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}