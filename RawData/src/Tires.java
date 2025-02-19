public class Tires {
    private double tirePressure;
    private int tireAge;


    public Tires(double tirePressure, int tireAge) {
        this.tirePressure = tirePressure;
        this.tireAge = tireAge;
    }

    public int getTireAge() {
        return tireAge;
    }

    public void setTireAge(int tireAge) {
        this.tireAge = tireAge;
    }

    public double getTirePressure() {
        return tirePressure;
    }

    public void setTirePressure(double tirePressure) {
        this.tirePressure = tirePressure;
    }
}
