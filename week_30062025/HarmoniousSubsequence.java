import java.util.HashMap;
import java.util.Map;

public class HarmoniousSubsequence {

    public static int findLHS(int[] nums) {
        HashMap<Integer, Integer> counts_map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            counts_map.put(nums[i], counts_map.getOrDefault(nums[i], 0) + 1);
        }

        int longest = 0;

        for (Map.Entry<Integer, Integer> entry : counts_map.entrySet()) {
            if (counts_map.containsKey(entry.getKey()+1)) {
                int length = entry.getValue() + counts_map.get(entry.getKey()+ 1);
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
