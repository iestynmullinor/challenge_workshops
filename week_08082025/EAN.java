package week_08082025;

public class EAN {


    public static boolean checkSum(String eanCode) {

        String sequence = eanCode.substring(0,12);
        int checkDigit = eanCode.charAt(12) - '0';

        int sum = 0;

        for (int i = 0; i < sequence.length(); i++) {
            if ((i+1)%2==0) {
                sum += (sequence.charAt(i) - '0') * 3;
            }
            else {
                sum += sequence.charAt(i) - '0';
            }
        }

        return (sum % 10 == 0) ? checkDigit == 0 : checkDigit == 10 - (sum % 10);


    }
    public static void main(String[] args) {
        System.out.println(checkSum("4003301018398"));
        System.out.println(checkSum("4003301018392"));
        System.out.println(checkSum("9783815820865"));
    }
}
