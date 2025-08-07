package week_08082025;

public class PalindromeNumber {


    public static boolean isPalindrome(int x) {
        String sequence = String.valueOf(x);

        int left_pointer = 0;
        int right_pointer = sequence.length() - 1;

        while (right_pointer > left_pointer) {
            if (sequence.charAt(left_pointer) != sequence.charAt(right_pointer)) return false;
            left_pointer++;
            right_pointer--;
        }

        return true;
    }

    public static void main(String[] args) {

        System.out.println(isPalindrome(34543));
        System.out.println(isPalindrome(1804610));
        
    }

}
