import java.io.Serializable;

public class Event implements Serializable {
    private int id;
    private String town;
    private String description;
    private String date;
    private int availableNumberOfparticipants;

    public Event(int id, String town, String description, String date, int availableNumberOfparticipants){
        this.id = id;
        this.town = town;
        this.description = description;
        this.date = date;
        this.availableNumberOfparticipants = availableNumberOfparticipants;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAvailableNumberOfparticipants() {
        return availableNumberOfparticipants;
    }

    public void setAvailableNumberOfparticipants(int availableNumberOfparticipants) {
        this.availableNumberOfparticipants = availableNumberOfparticipants;
    }
}
