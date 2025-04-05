import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class problem39_41 {

      // Algorithm:
    // 1. Filter out positive numbers from the input array.
    // 2. Sort the filtered numbers.
    // 3. Initialize `missing` to 1 and iterate through the sorted list.
    // 4. If the current number equals `missing`, increment `missing`.
    // 5. If the current number is greater than `missing`, stop the loop.
    // 6. Return `missing` as the first missing positive integer.


      public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> positiveNumbers = new ArrayList<>();
        for (int num : nums) {
            if (num > 0) {
                positiveNumbers.add(num);
            }
        }
        Collections.sort(positiveNumbers);
        int missing = 1;
        for (int num : positiveNumbers) {
            if (num == missing) {
                missing++;
            } else if (num > missing) {
                break;
            }
        }
        return missing;
    }

    public static void main(String[] args) {

         // Pseudocode:
        // 1. Read the number of elements (n)
        // 2. Initialize an array nums of size n
        // 3. Read n elements into nums
        // 4. Create an instance of Solution class
        // 5. Call firstMissingPositive(nums) and store the result
        // 6. Print the result
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        scanner.close();
        
        problem39_41 solution = new problem39_41();
        int result = solution.firstMissingPositive(nums);
        System.out.println("The first missing positive number is: " + result);
    }
}
