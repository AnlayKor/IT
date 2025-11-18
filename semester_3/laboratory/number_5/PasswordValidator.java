import java.util.regex.*;

public class PasswordValidator {
    public static void main(String[] args) {
        try {
            String password = "Password123";
            Pattern pattern = Pattern.compile("(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}");
            Matcher matcher = pattern.matcher(password);
            if (matcher.matches()) {
                System.out.println("Пароль корректен!");
            } else {
                System.out.println("Пароль не соответствует требованиям.");
            }
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}