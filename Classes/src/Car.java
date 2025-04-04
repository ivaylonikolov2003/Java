public class Car {
    private String brand;
    private String model;
    private int horsePower;

    public Car() {
    }

    public Car(String brand) {
        this.brand = brand;
    }

    public Car(String brand, String model) {
        this(brand, model, -1);
    }

    public Car(String brand, String model, int horsePower){
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public String getModel(){
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsePower(){
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
    @Override
    public String toString(){
        if (horsePower == -1) {
            return String.format("%s:%s", this.brand, this.model);
        }
        else {
            return String.format("%s:%s:%d", this.brand, this.model, this.horsePower);
        }
    }
}
