public class problem6_48 {
  //bruteforce approach 

  static int[][] rotate(int[][] matrix) {
    int n = matrix.length;
    int rotated[][] = new int[n][n];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            rotated[j][n - i - 1] = matrix[i][j];
        }
    }
    return rotated;
}

//optimal approach
static void rotate2(int[][] matrix) {
  for (int i = 0; i < matrix.length; i++) {
      for (int j = i; j < matrix[0].length; j++) {
          int temp = 0;
          temp = matrix[i][j];
          matrix[i][j] = matrix[j][i];
          matrix[j][i] = temp;
      }
  }
  for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length / 2; j++) {
          int temp = 0;
          temp = matrix[i][j];
          matrix[i][j] = matrix[i][matrix.length - 1 - j];
          matrix[i][matrix.length - 1 - j] = temp;
      }
  }
}



  public static void main (String args[]){
    int arr[][] = {{1,2,3}, {4,5,6}, {7,8,9}};
    int rotated[][] = rotate(arr);
    for (int i = 0; i < rotated.length; i++) {
      for (int j = 0; j < rotated.length; j++) {
          System.out.print(rotated[i][j] + " ");
      }
      System.out.println();
  }
  }
}



// Algorithm:
// Brute Force Approach (Using Extra Matrix)
// Create a new matrix rotated[][] of size n x n.

// Iterate through each element in matrix[][]:

// Place matrix[i][j] in rotated[j][n - i - 1].

// This shifts elements to their new rotated positions.

// Return the rotated[][] matrix.

// Optimal Approach (In-place Rotation)
// Transpose the Matrix (Swap matrix[i][j] with matrix[j][i]):

// Convert rows into columns.

// Reverse Each Row to get a 90-degree rotation.

// Pseudocode:
// Brute Force Approach (Using Extra Matrix)
// scss
// Copy
// Edit
// FUNCTION rotate(matrix)
//     n ← length of matrix
//     rotated[n][n]  // Create a new matrix

//     FOR i ← 0 to n - 1 DO
//         FOR j ← 0 to n - 1 DO
//             rotated[j][n - i - 1] ← matrix[i][j]  // Rotate element
//         ENDFOR
//     ENDFOR

//     RETURN rotated
// END FUNCTION
// Optimal Approach (In-place Rotation)
// pgsql
// Copy
// Edit
// FUNCTION rotate2(matrix)
//     // Step 1: Transpose the Matrix
//     FOR i ← 0 to length(matrix) - 1 DO
//         FOR j ← i to length(matrix) - 1 DO
//             SWAP matrix[i][j] with matrix[j][i]
//         ENDFOR
//     ENDFOR

//     // Step 2: Reverse Each Row
//     FOR i ← 0 to length(matrix) - 1 DO
//         FOR j ← 0 to (length(matrix) / 2) - 1 DO
//             SWAP matrix[i][j] with matrix[i][length(matrix) - j - 1]
//         ENDFOR
//     ENDFOR
// END FUNCTION
// Time & Space Complexity Analysis:
// Brute Force Approach:
// Time Complexity: 
// 𝑂
// (
// 𝑛
// 2
// )
// O(n 
// 2
//  ) (Traverses each element once).

// Space Complexity: 
// 𝑂
// (
// 𝑛
// 2
// )
// O(n 
// 2
//  ) (Uses an extra matrix).

// Optimal Approach (In-place Rotation):
// Time Complexity: 
// 𝑂
// (
// 𝑛
// 2
// )
// O(n 
// 2
//  ) (Each element is accessed twice).

// Space Complexity: 
// 𝑂
// (
// 1
// )
// O(1) (No extra space used).