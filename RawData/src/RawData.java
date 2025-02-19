import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class RawData {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tires tire1;
    private Tires tire2;
    private Tires tire3;
    private Tires tire4;


    public RawData(String model, Engine engine, Cargo cargo, Tires tire1, Tires tire2, Tires tire3, Tires tire4) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tire1 = tire1;
        this.tire2 = tire2;
        this.tire3 = tire3;
        this.tire4 = tire4;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public List<Tires> getTires() {
        List<Tires> tires = new ArrayList<>(Arrays.asList(tire1, tire2, tire3, tire4));
        tires.sort((a, b) -> Double.compare(a.getTirePressure(), b.getTirePressure()));
        return tires;
    }

    @Override
    public String toString() {
        return model;
    }
}
