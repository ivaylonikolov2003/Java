import java.util.ArrayList;
import java.util.List;


interface StringBuilderObserver {
    void update(StringBuilderSubject subject);
}


class StringBuilderSubject {
    private List<StringBuilderObserver> observers = new ArrayList<>();
    private StringBuilder stringBuilder = new StringBuilder();

    public void addObserver(StringBuilderObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(StringBuilderObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (StringBuilderObserver observer : observers) {
            observer.update(this);
        }
    }

    public void append(String str) {
        stringBuilder.append(str);
        notifyObservers();
    }

    public int length() {
        return stringBuilder.length();
    }

    public String toString() {
        return stringBuilder.toString();
    }
}
class MyStringBuilderObserver implements StringBuilderObserver {
    @Override
    public void update(StringBuilderSubject subject) {
        System.out.println("StringBuilder state changed: " + subject.toString());
    }
}

public class ObservableStringBuilderExample {
    public static void main(String[] args) {
        StringBuilderSubject observableStringBuilder = new StringBuilderSubject();
        MyStringBuilderObserver observer = new MyStringBuilderObserver();

        observableStringBuilder.addObserver(observer);
        observableStringBuilder.append("Hello, ");
        observableStringBuilder.append("Observer!");
    }
}
