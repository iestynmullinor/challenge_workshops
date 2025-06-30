import java.util.Arrays;

public class HarmoniousSubsequence_fast {

    public static int findLHS(int[] nums) {
        Arrays.sort(nums);

        int longest_hs = 0;

        int prev_hs = 0;
        int current_hs = 0;
        
        int current_num = nums[0];

        boolean prev_exists = false;

        for (int i = 0; i < nums.length-1; i++) {

            if (current_num == nums[i+1]) {
                current_hs++;
                if (prev_exists)
                    prev_hs++;
            }

            else if(current_num+1 == nums[i+1]) {
                current_hs++;
                current_num++;
                if (prev_hs > longest_hs) longest_hs = prev_hs;
                prev_hs = current_hs;
                current_hs = 0;
                prev_exists = true;
            }

            else {
                if (prev_hs > longest_hs) longest_hs = prev_hs;
                current_hs = 0;
                prev_exists = false;
                prev_hs = 0;
                current_num = nums[i+1];
            }
            

        }

        if (prev_hs > longest_hs) longest_hs = prev_hs;

        if (longest_hs == 0) return longest_hs;
        return longest_hs + 1;

    }

    public static void main(String[] args) {
        System.out.println(findLHS(new int[] { -14, 1, 1, 2, 3, 3, 4, 13}));
        System.out.println(findLHS(new int[] { 1, 3, 2, 2, 5, 2, 3, 7 }));
        System.out.println(findLHS(new int[] { 1, 2, 3, 4 }));
        System.out.println(findLHS(new int[] { 1, 1, 1, 1 }));
        System.out.println(findLHS(new int[] {1,1,1,1,1,2,2,3,4,5}));

    }
    
}
// beats 99