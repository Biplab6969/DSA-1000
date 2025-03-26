// 2033. Minimum Operations to Make a Uni-Value Grid
// You are given a 2D integer grid of size m x n and an integer x. In one operation, you can add x to or subtract x from any element in the grid.

// A uni-value grid is a grid where all the elements of it are equal.

// Return the minimum number of operations to make the grid uni-value. If it is not possible, return -1.

// Example 1:

// Input: grid = [[2,4],[6,8]], x = 2
// Output: 4
// Explanation: We can make every element equal to 4 by doing the following: 
// - Add x to 2 once.
// - Subtract x from 6 once.
// - Subtract x from 8 twice.
// A total of 4 operations were used.
// Example 2:

// Input: grid = [[1,5],[2,3]], x = 1
// Output: 5
// Explanation: We can make every element equal to 3.
// Example 3:

// Input: grid = [[1,2],[3,4]], x = 2
// Output: -1
// Explanation: It is impossible to make every element equal.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class problem31_2033 {
  public int minOperations(int[][] grid, int x) {
    List<Integer> numsArray = new ArrayList<>();
    int result = 0;

    // Flattening the grid into a list
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) { // Fixed j++
        numsArray.add(grid[i][j]);
      }
    }

    // Sorting the list to find the median
    Collections.sort(numsArray);
    int length = numsArray.size();
    int finalCommonNumber = numsArray.get(length / 2);

    // Calculating the minimum operations
    for (int number : numsArray) {
      if ((number - finalCommonNumber) % x != 0) { // Fixed condition
        return -1;
      }
      result += Math.abs(finalCommonNumber - number) / x; // Fixed division
    }

    return result;
  }

  public static void main(String[] args) {
    problem31_2033 solution = new problem31_2033();

    // Example test case
    int[][] grid = {
        { 2, 4 },
        { 6, 8 }
    };
    int x = 2;

    int result = solution.minOperations(grid, x);
    System.out.println("Minimum operations: " + result);
  }
}


//        PSEUDECODE

// FUNCTION minOperations(grid, x):
//     CREATE an empty list numsArray
    
//     // Step 1: Flatten the grid into a 1D list
//     FOR each row i in grid:
//         FOR each column j in grid[i]:
//             ADD grid[i][j] to numsArray
    
//     // Step 2: Check if all elements can be transformed
//     SET reference = numsArray[0]
//     FOR each number in numsArray:
//         IF (number - reference) MOD x ≠ 0:
//             RETURN -1  // Transformation not possible
    
//     // Step 3: Find the median
//     SORT numsArray
//     SET length = size of numsArray
//     SET finalCommonNumber = numsArray[length / 2]  // Median element
    
//     // Step 4: Calculate minimum operations
//     SET result = 0
//     FOR each number in numsArray:
//         SET operations = ABS(finalCommonNumber - number) / x
//         result = result + operations
    
//     RETURN result


//     ALGORITHM
//     Steps:
// Flatten the Grid into a List:

// Initialize an empty list numsArray.

// Iterate over all rows (i) and columns (j) of grid:

// Add grid[i][j] to numsArray.

// Check if Transformation is Possible:

// Pick a reference element (e.g., the first element of numsArray).

// Iterate over numsArray:

// If (numsArray[i] - reference) % x != 0, return -1 (impossible to make all elements equal using x).

// Find the Median Element:

// Sort numsArray.

// Identify finalCommonNumber as the median of numsArray.

// Calculate Minimum Operations:

// Initialize result = 0.

// Iterate over numsArray:

// Compute operations = |finalCommonNumber - number| / x.

// Add operations to result.

// Return result.


