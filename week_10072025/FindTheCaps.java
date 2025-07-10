package week_10072025;

import java.util.ArrayList;

public class FindTheCaps {
    public static int[] capitals(String s) {
        ArrayList<Integer> intList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i)))
                intList.add(i);
        }

        return intList.stream().mapToInt(Integer::intValue).toArray();

    }
}
