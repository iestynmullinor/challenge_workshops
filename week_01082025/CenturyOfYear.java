package week_01082025;

public class CenturyOfYear {

    public static int century(int number) {
        return (number - 1) / 100 + 1;
    }

    public static void main(String[] args) {
        
        System.out.println(century(3452));
        System.out.println(century(1));
        System.out.println(century(200));
    }

}
