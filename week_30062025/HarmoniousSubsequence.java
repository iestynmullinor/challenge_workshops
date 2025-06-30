import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class HarmoniousSubsequence {

    public static int findLHS(int[] nums) {
        TreeMap<Integer, Integer> counts_map = new TreeMap<>();

        for (int i = 0; i < nums.length; i++) {
            counts_map.put(nums[i], counts_map.getOrDefault(nums[i], 0) + 1);
        }

        int longest = 0;
        List<Map.Entry<Integer, Integer>> counts_list = new ArrayList<>(counts_map.entrySet());

        for (int i = 0; i < counts_list.size() - 1; i++) {
            if (counts_list.get(i).getKey() - counts_list.get(i + 1).getKey() == -1) {
                int length = counts_list.get(i).getValue() + counts_list.get(i + 1).getValue();
                if (length > longest)
                    longest = length;
            }
        }

        return longest;

    }

    public static void main(String[] args) {
        System.out.println(findLHS(new int[] { 1, 3, 2, 2, 5, 2, 3, 7 }));
        System.out.println(findLHS(new int[] { 1, 2, 3, 4 }));
        System.out.println(findLHS(new int[] { 1, 1, 1, 1 }));

    }

}
