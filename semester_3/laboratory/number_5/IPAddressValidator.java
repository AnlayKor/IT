import java.util.regex.*;

public class IPAddressValidator {
    public static void main(String[] args) {
        try {
            String ipAddress = "225.0.24.255";
            Pattern pattern = Pattern.compile(
                    "((25[0-5]|2[0-4][0-9]|1?[1-9]?[0-9]|10[0-9])\\.){3}(25[0-5]|2[0-4][0-9]|1?[1-9]?[0-9]|10[0-9])"
            );
            Matcher matcher = pattern.matcher(ipAddress);
            if (matcher.matches()) {
                System.out.println("IP-адрес корректен!");
            } else {
                System.out.println("IP-адрес не соответствует требованиям.");
            }
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}