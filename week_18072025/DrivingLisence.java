package week_18072025;

import java.util.HashMap;

public class DrivingLisence {

    public static String generateMonthString(String dob, String gender) {
        final HashMap<String, Integer> monthMap = new HashMap<>();
            monthMap.put("Jan", 1);
            monthMap.put("Feb", 2);
            monthMap.put("Mar", 3);
            monthMap.put("Apr", 4);
            monthMap.put("May", 5);
            monthMap.put("Jun", 6);
            monthMap.put("Jul", 7);
            monthMap.put("Aug", 8);
            monthMap.put("Sep", 9);
            monthMap.put("Oct", 10);
            monthMap.put("Nov", 11);
            monthMap.put("Dec", 12);

        String month = dob.substring(3,6);

        int outputInt = (gender.equals("M")) ? monthMap.get(month) : monthMap.get(month) + 50;

        StringBuilder outputString = new StringBuilder();

        outputString.append(String.valueOf(outputInt));

        if (outputString.length() < 2) 
            outputString.insert(0, 0);
        
        return outputString.toString();

    }

    public static String driver(final String[] data) {


        StringBuilder driverNumber = new StringBuilder();

        // first 5 chars

        String surname = data[2].toUpperCase();
        if (surname.length() < 5) {
            driverNumber.append(surname);
            while (driverNumber.length() < 5) 
                driverNumber.append("9");
        } else {
            driverNumber.append(surname.substring(0, 5));
        }

        // 6th char
        String dob = data[3];
        driverNumber.append(dob.charAt(dob.length()-2));

        // 7 -8th chars
        driverNumber.append(generateMonthString(dob, data[4]));

        // 9-10th chars
        driverNumber.append(dob.substring(0, 2));

        // 11th char
        driverNumber.append(dob.charAt(dob.length()-1));

        // 12-13th
        driverNumber.append(data[0].charAt(0));
        if (data[1].equals("")) 
            driverNumber.append("9");
        else
            driverNumber.append(data[1].charAt(0));

        //14-16th
        driverNumber.append("9AA");
        


        return driverNumber.toString(); // Code here
    }

    public static void main(String[] args) {
        String[] data = {"John", "James", "Smith", "01-Jan-2000", "M"};
        System.out.println(driver(data));


    }
    /*
     * data = {"John","James","Smith","01-Jan-2000","M"};
     * 1–5: The first five characters of the surname (padded with 9s if less than 5
     * characters)
     * 
     * 6: The decade digit from the year of birth (e.g. for 1987 it would be 8)
     * 
     * 7–8: The month of birth (7th character incremented by 5 if driver is female
     * i.e. 51–62 instead of 01–12)
     * 
     * 9–10: The date within the month of birth
     * 
     * 11: The year digit from the year of birth (e.g. for 1987 it would be 7)
     * 
     * 12–13: The initial letter of the first name and middle name, padded with a 9
     * if no middle name
     * 
     * 14: Arbitrary digit – usually 9, but decremented to differentiate drivers
     * with the first 13 characters in common. We will always use 9
     * 
     * 15–16: Two computer check digits. We will always use "AA"
     */
}
