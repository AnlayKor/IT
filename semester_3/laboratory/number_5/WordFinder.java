import java.util.regex.*;

public class WordFinder {
    public static void main(String[] args) {
        try {
            String text = "Java is a powerful programming language. JavaScript is also popular.";
            String letter = "A";
            String regex = "\\b[" + letter.toLowerCase() + letter.toUpperCase() + "]\\w*\\b";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}