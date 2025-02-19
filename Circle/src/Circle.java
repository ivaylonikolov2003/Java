import java.io.Serializable;

public class Circle implements Serializable {
    private String radius;
    private String color;

    public Circle(String radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Circle: " + this.radius + " " + this.color;
    }
}
