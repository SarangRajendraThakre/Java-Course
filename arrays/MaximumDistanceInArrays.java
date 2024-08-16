import java.util.List;
import java.util.Arrays;

class MaximumDistanceInArrays {
    public int maxDistance(List<List<Integer>> arrays) {
        // Initialize min and max with the first array's first and last elements
        int minValue = arrays.get(0).get(0);
        int maxValue = arrays.get(0).get(arrays.get(0).size() - 1);
        int maxDistance = 0;

        // Iterate through the arrays starting from the second one
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> currentArray = arrays.get(i);
            int currentMin = currentArray.get(0);
            int currentMax = currentArray.get(currentArray.size() - 1);

            // Calculate the possible maximum distances
            maxDistance = Math.max(maxDistance, Math.abs(currentMax - minValue));
            maxDistance = Math.max(maxDistance, Math.abs(maxValue - currentMin));

            // Update the global min and max values
            minValue = Math.min(minValue, currentMin);
            maxValue = Math.max(maxValue, currentMax);
        }

        return maxDistance;
    }

    public static void main(String[] args) {
        // Create a Solution object
        MaximumDistanceInArrays solution = new MaximumDistanceInArrays();

        // Example 1
        List<List<Integer>> arrays1 = Arrays.asList(
                Arrays.asList(2, 3, 10),
                Arrays.asList(4, 5),
                Arrays.asList(1, 2, 3));
        int result1 = solution.maxDistance(arrays1);
        System.out.println("Example 1 Output: " + result1); // Output should be 4

        // Example 2
        List<List<Integer>> arrays2 = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(1));
        int result2 = solution.maxDistance(arrays2);
        System.out.println("Example 2 Output: " + result2); // Output should be 0
    }
}
