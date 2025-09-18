public class Palindrome {
    public static void main(String[] args) {
        for (String arg : args) {
            String s = arg;
            s = reverseString(s);
            System.out.println(isPalindrome(s));
        }
    }

    public static String reverseString(String s) {
        StringBuilder a = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i -= 1) {
            a.append(s.charAt(i));
        }
        return a.toString();
    }

    public static boolean isPalindrome(String s) {
        String a = reverseString(s);
        return s.equals(a);
    }
}