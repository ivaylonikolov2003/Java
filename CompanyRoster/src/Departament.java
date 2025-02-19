public class Departament {
    String depName;
    double avgSalary;

    public Departament(String depName, double avgSalary) {
        this.depName = depName;
        this.avgSalary = avgSalary;
    }

    public double getAvgSalary(){
        return avgSalary;
    }
}
