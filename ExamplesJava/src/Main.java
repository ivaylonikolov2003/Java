import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Person> players = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            players.add(new Person(input[0], input[1], Integer.parseInt(input[2])));
        }

        /*Collections.sort(people, (firstPerson, secondPerson) -> {
            int sComp = firstPerson.getFirstName().compareTo(secondPerson.getFirstName());
            if (sComp != 0){
                return sComp;
            }else {
                return Integer.compare(firstPerson.getAge(), secondPerson.getAge());
            }
        });*/
        Team team = new Team("Liverpool");

        for (Person person:players) {
            team.addPlayer(person);
        }
        System.out.println("First team have: " + team.getFirstTeam().size() + " players");
        System.out.println("Second team have: " + team.getSecondTeam().size() + " players");
    }
}
