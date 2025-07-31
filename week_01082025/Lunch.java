package week_01082025;

public class Lunch {

    public static int countStudents(int[] students, int[] sandwiches) {
        int[] numWantingSandwich = {0,0};
        for (int student : students) {
            numWantingSandwich[student]++;
        }

        for (int i = 0; i < sandwiches.length; i++) {
        
            int currentSandwich = sandwiches[i];
            if (numWantingSandwich[currentSandwich]==0) 
                return (currentSandwich == 0) ? numWantingSandwich[1] : numWantingSandwich[0];
            else
                numWantingSandwich[currentSandwich]--;
        }

        return 0;
    }

}
