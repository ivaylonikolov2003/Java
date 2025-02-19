import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTester {
    static List<Boolean> test(Regex regex, String[] strings){
        Pattern pattern = Pattern.compile(regex.getPattern());
        List<Boolean> result = new ArrayList<>();

        for (String s : strings) {
            Matcher matcher = pattern.matcher(s);
            boolean isMatched = matcher.matches();
            result.add(isMatched);
        }
        return result;
    }

}
