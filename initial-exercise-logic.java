import java.util.HashSet;

public class exercises {

   //exercise 1
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;

        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }


//exercise 2
  
    public static void main(String[] args) {
        String str = "A man, a plan, a canal, Panama!";
        boolean isPalindrome = checkPalindrome(str);
        System.out.println("Is the string a palindrome? " + isPalindrome);
    }

    public static boolean checkPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Move left pointer to the next alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // Move right pointer to the previous alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            // Compare characters ignoring case
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

   //exercise 3
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
