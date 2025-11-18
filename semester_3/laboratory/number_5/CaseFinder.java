import java.util.regex.*;

public class CaseFinder {
    public static void main(String[] args) {
        try {
            String text = "helloWorld thisIsTest";
            text = text.replaceAll("([a-z][A-Z])", "!$1!");
            System.out.println("Результат: " + text);
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}