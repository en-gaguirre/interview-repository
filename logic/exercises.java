import java.util.HashSet;

public class exercises {

    public static void exercise() {
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
        System.out.println();
    }

    public static void exerciseII() {
        String str = "A man, a plan, a canal, Panama!";
        boolean isPalindrome = checkPalindrome(str);
        System.out.println("Is the string a palindrome? " + isPalindrome);
    }

    public static boolean exerciseIII(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void exerciseIV() {
        int[] arr = {1, 5, 7, -1, 5};
        int target = 6;
        findPairs(arr, target);
    }

    public static void exerciseFive(int[] arr, int target) {
        HashSet<Integer> seenNumbers = new HashSet<>();
        HashSet<String> foundPairs = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;
            if (seenNumbers.contains(complement)) {
                int smaller = Math.min(num, complement);
                int larger = Math.max(num, complement);
                foundPairs.add("(" + smaller + ", " + larger + ")");
            }
            seenNumbers.add(num);
        }

        if (foundPairs.isEmpty()) {
            System.out.println("No pairs found with the given sum.");
        } else {
            System.out.println("Pairs with sum " + target + ": " + foundPairs);
        }
    }
}
