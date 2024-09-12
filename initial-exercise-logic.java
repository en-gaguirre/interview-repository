import java.util.HashSet;

public class PairSum {

   
    public static void findPairs(int[] arr, int target) {
        HashSet<Integer> seenNumbers = new HashSet<>(); // To store visited numbers
        HashSet<String> foundPairs = new HashSet<>();   // To store unique pairs

        for (int num : arr) {
            int complement = target - num;  // Calculate complement (target - num)

            
            if (seenNumbers.contains(complement)) {
                // Create a pair with smaller number first for uniqueness
                int smaller = Math.min(num, complement);
                int larger = Math.max(num, complement);

                String pair = "(" + smaller + ", " + larger + ")";
                foundPairs.add(pair); // Add the unique pair to the set
            }

            // Add the current number to the set of seen numbers
            seenNumbers.add(num);
        }

        // Print all unique pairs
        if (foundPairs.isEmpty()) {
            System.out.println("No pairs found with the given sum.");
        } else {
            System.out.println("Pairs with sum " + target + ": " + foundPairs);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 7, -1, 5};
        int target = 6;

        findPairs(arr, target);
    }
}
Sample Output
