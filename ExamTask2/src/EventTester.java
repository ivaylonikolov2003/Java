import java.util.ArrayList;
import java.util.List;

public class EventTester {
    public static List<Event> eventList = new ArrayList<>();

    public synchronized static List<Event> ShowAllEvents(String city, String date){
        List<Event> events = new ArrayList<>();

        for (Event event: eventList) {
            if (date.equals(event.getDate())){
                if (city.equals(event.getTown())){
                    events.add(event);
                }
            }
        }
        return events;
    }

    public synchronized static void addNewParticipant(int id){

        for (Event event:eventList) {
            if (id == event.getId()){
                int count = event.getAvailableNumberOfparticipants();
                if (count > 0){
                    event.setAvailableNumberOfparticipants(count - 1);
                }
            }
        }
    }
}
