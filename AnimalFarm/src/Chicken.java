public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) throws Exception {
        if (name != null && !name.equals(" ")){
            this.name = name;
        }else {
            throw new Exception("Name cannot be empty!");
        }
        if (age >= 0 && age <= 15){
            this.age = age;
        }else {
            System.out.println("Age should be between 0 and 15");
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double productPerDay() {
        double product;
        if (age >= 0 && age <= 5) {
            product = 2;
        } else if (age >= 6 && age <= 11) {
            product = 1;
        } else {
            product = 0.75;
        }
        return product;
    }
    public double calculate(){
        double sum = 0;
        sum = productPerDay();
        return sum;
    }
    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day", name, age, calculate());
    }
}
