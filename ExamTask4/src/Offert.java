import java.util.ArrayList;

public class Offert {
    public int offertId;
    public String destination;
    public String nameOfHotel;
    public double price;
    public double rating;
    public ArrayList<Integer> evaluation;

    public Offert(int offertId, String destination, String nameOfHotel, double price, double rating, ArrayList<Integer> evaluation) {
        this.offertId = offertId;
        this.destination = destination;
        this.nameOfHotel = nameOfHotel;
        this.price = price;
        this.rating = 0.0;
        this.evaluation = new ArrayList<>();
    }

    public int getOffertId() {
        return offertId;
    }

    public void setOffertId(int offertId) {
        this.offertId = offertId;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getNameOfHotel() {
        return nameOfHotel;
    }

    public void setNameOfHotel(String nameOfHotel) {
        this.nameOfHotel = nameOfHotel;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public ArrayList<Integer> getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(ArrayList<Integer> evaluation) {
        this.evaluation = evaluation;
    }
}
