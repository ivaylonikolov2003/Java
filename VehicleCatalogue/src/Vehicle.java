public class Vehicle {
    private String typeOfVehicle;
    private String model;
    private String color;
    private int horsePower;

    public Vehicle(String typeOfVehicle, String model, String color, int horsePower) {
        this.typeOfVehicle = typeOfVehicle;
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
    }

    public String getTypeOfVehicle() {
        return typeOfVehicle;
    }

    public void setTypeOfVehicle(String typeOfVehicle) {
        this.typeOfVehicle = typeOfVehicle;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return String.format("Type: %s\n"
                + "Model: %s\n"
                + "Color: %s\n"
                + "HorsePower: %d\n", getTypeOfVehicle().toUpperCase().charAt(0) + this.getTypeOfVehicle().substring(1),
                getModel(),
                getColor(),
                getHorsePower());
    }
}
