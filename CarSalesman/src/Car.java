public class Car {
    private String model;
    private Engine engine;
    private String weight;
    private String color;

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public String getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public Car(String model, Engine engine, String weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        return this.model + ":" + "\n" + String.format("%s%n" +
                " Weight: %s%n" +
                " Color: %s", this.engine, this.weight, this.color);
    }
}
