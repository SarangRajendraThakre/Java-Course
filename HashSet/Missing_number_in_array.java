package HashSet;
import java.util.HashSet;
import java.util.Set;

public class Missing_number_in_array {
    

   public static String findMissing(int[] arr, int n) {
        if (n == 0) {
            return "-1";
        }

        // Determine the maximum value in the array
        int maxVal = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
        }

        // Use a Set to keep track of existing numbers
        Set<Integer> presentNumbers = new HashSet<>();
        for (int num : arr) {
            presentNumbers.add(num);
        }

        // Build the result string
        StringBuilder result = new StringBuilder();
        boolean inRange = false;
        int start = -1;

        // Check all numbers in the range [0, maxVal]
        for (int i = 0; i <= maxVal; i++) {
            if (!presentNumbers.contains(i)) {
                if (!inRange) {
                    inRange = true;
                    start = i;
                }
            } else {
                if (inRange) {
                    if (start == i - 1) {
                        result.append(start).append(" ");
                    } else {
                        result.append(start).append("-").append(i - 1).append(" ");
                    }
                    inRange = false;
                }
            }
        }

        // If there was an ongoing range at the end
        if (inRange) {
            if (start == maxVal) {
                result.append(start).append(" ");
            } else {
                result.append(start).append("-").append(maxVal).append(" ");
            }
        }

        // Remove trailing space
        String resultStr = result.toString().trim();
        return resultStr.isEmpty() ? "-1" : resultStr;
    }

    // public static void main(String[] args) {

    //     int [] arr = {2 ,4,7,8,545,65};
    //     int n = arr.length;

    //     Missing_number_in_array   result = new Missing_number_in_array();

       

    //     System.out.println(result.findMissing(arr,n)); 
    // }

        
    // if you want to use the above method then you have to make the method findMissing()  without static

    public static void main(String[] args) {
        
        int [] arr = {423,54,65,767,3,2,70,6,87876,45,232,434};
        int n = arr.length;

        System.out.println(findMissing(arr,n));
    }
       
}
