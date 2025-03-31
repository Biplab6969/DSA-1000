
// 31. Next Permutation
// A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

// For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
// The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

// For example, the next permutation of arr = [1,2,3] is [1,3,2].
// Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
// While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
// Given an array of integers nums, find the next permutation of nums.

// The replacement must be in place and use only constant extra memory.

 

// Example 1:

// Input: nums = [1,2,3]
// Output: [1,3,2]
// Example 2:

// Input: nums = [3,2,1]
// Output: [1,2,3]
// Example 3:

// Input: nums = [1,1,5]
// Output: [1,5,1]



import java.util.Arrays;

public class problem32_nextPermutation {

  public void nextPermutation(int[] nums) {
    int ind1 = -1, ind2 = -1;
    int n = nums.length;

    // Step 1: Find the first decreasing element from the end
    for (int i = n - 2; i >= 0; i--) {
      if (nums[i] < nums[i + 1]) {
        ind1 = i;
        break;
      }
    }

    // Step 2: If no such element is found, reverse the entire array
    if (ind1 == -1) {
      reverse(nums, 0);
      return;
    }

    // Step 3: Find the next larger element from the right
    for (int i = n - 1; i > ind1; i--) {
      if (nums[i] > nums[ind1]) {
        ind2 = i;
        break;
      }
    }

    // Step 4: Swap elements at ind1 and ind2
    swap(nums, ind1, ind2);

    // Step 5: Reverse the elements from ind1+1 to the end
    reverse(nums, ind1 + 1);
  }

  // Swap helper function
  void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  // Reverse helper function
  void reverse(int[] nums, int start) {
    int i = start, j = nums.length - 1;
    while (i < j) {
      swap(nums, i, j);
      i++;
      j--;
    }
  }

  // Main function to test the code
  public static void main(String[] args) {
    problem32_nextPermutation solution = new problem32_nextPermutation();

    int[] nums = { 3, 2, 1 }; // Example test case
    System.out.println("Original array: " + Arrays.toString(nums));

    solution.nextPermutation(nums);

    System.out.println("Next permutation: " + Arrays.toString(nums));
  }
}



// ALGORITHM

// FUNCTION nextPermutation(nums):
//     SET ind1 = -1
//     SET ind2 = -1
//     SET n = length of nums

//     // Step 1: Find the first decreasing element from the right
//     FOR i FROM (n - 2) TO 0 (inclusive) DECREMENT BY 1:
//         IF nums[i] < nums[i + 1]:
//             SET ind1 = i
//             BREAK

//     // Step 2: If no such element is found, reverse the entire array
//     IF ind1 == -1:
//         CALL reverse(nums, 0)
//         RETURN

//     // Step 3: Find the next larger element from the right
//     FOR i FROM (n - 1) TO ind1 (exclusive) DECREMENT BY 1:
//         IF nums[i] > nums[ind1]:
//             SET ind2 = i
//             BREAK

//     // Step 4: Swap elements at ind1 and ind2
//     CALL swap(nums, ind1, ind2)

//     // Step 5: Reverse the elements from ind1+1 to the end
//     CALL reverse(nums, ind1 + 1)


//     AlgorithmConstraints
//     Explanation of Steps
// Find the first decreasing element from the right

// Traverse the array from right to left.

// Find the first index ind1 where nums[ind1] < nums[ind1 + 1].

// If no such index is found, reverse the array

// This means the array is the largest permutation (e.g., [3, 2, 1]).

// Reverse it to get the smallest permutation (sorted order).

// Find the next greater element to swap

// From the rightmost side, find ind2 where nums[ind2] > nums[ind1].

// Swap nums[ind1] and nums[ind2]

// This ensures the next permutation is larger than the current one.

// Reverse the elements after ind1

// This ensures we get the smallest possible permutation after the swap.


