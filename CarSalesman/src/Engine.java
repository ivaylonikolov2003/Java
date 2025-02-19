public class Engine {
    private String engineModel;
    private String power;
    private String displacement;
    private String efficiency;

    public Engine(String engineModel, String power, String displacement, String efficiency) {
        this.engineModel = engineModel;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String getEngineModel() {
        return engineModel;
    }

    public String getPower() {
        return power;
    }

    public String getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    @Override
    public String toString() {
        return "  " + this.engineModel + ":" + "\n" + String.format(
                "    Power: %s%n" +
                        "    Displacement: %s%n" +
                        "    Efficiency: %s%n", this.power, this.displacement, this.efficiency);
    }
}
