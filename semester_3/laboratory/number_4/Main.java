class CustomEmailFormatException extends Exception {
    public CustomEmailFormatException(String message) {
        super(message);
    }
}

class EmailValidator {
    public static void validateEmail(String email) throws CustomEmailFormatException {
        if (email == null || email.trim().isEmpty()) {
            throw new CustomEmailFormatException("Email адрес не может быть пустым");
        }
        if (!email.contains("@")) {
            throw new CustomEmailFormatException("Email адрес должен содержать символ '@'");
        }
        int atIndex = email.indexOf("@");
        if (!email.substring(atIndex).contains(".")) {
            throw new CustomEmailFormatException("Email адрес должен содержать домен с точкой после '@'");
        }
        if (atIndex == 0) {
            throw new CustomEmailFormatException("Email адрес должен содержать имя пользователя перед '@'");
        }
        int lastDotIndex = email.lastIndexOf(".");
        if (lastDotIndex == email.length() - 1 || email.length() - lastDotIndex < 3) {
            throw new CustomEmailFormatException("Домен должен содержать минимум 2 символа после последней точки");
        }
        System.out.println("Email адрес '" + email + "' имеет правильный формат");
    }
}

public class Main {
    public static void main(String[] args) {
        String[] testEmails = {
                "user@example.com",
                "invalid-email",
                "another.user@domain.co.uk",
                "@domain.com",
                "user@domain",
                "user@.com",
                "user@domain.c",
                "",
                null,
                "correct.email@test.org"
        };
        for (String email : testEmails) {
            try {
                EmailValidator.validateEmail(email);
            } catch (CustomEmailFormatException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }
}