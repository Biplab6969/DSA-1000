public class problem4_191 {
  public static int hammingWeight(int n) {
    int count = 0;
    while (n > 0) {
      if ((n & 1) != 0) {
        count++;
      }
      n = n >> 1;
    }
    return count;
  }

  public static void main(String args[]){
    System.out.println(hammingWeight(15));
  }
}
/* 

Algorithm:
Initialize count = 0 to keep track of the number of 1s.

Loop until n becomes 0:

Check if the least significant bit (LSB) is 1 by performing bitwise AND (n & 1).

If the LSB is 1, increment count.

Right shift n by 1 (n = n >> 1) to check the next bit.

Return count as the number of 1s in the binary representation of n.

Pseudocode:
pgsql
Copy
Edit
FUNCTION hammingWeight(n)
    count ← 0
    
    WHILE n > 0 DO
        IF (n AND 1) ≠ 0 THEN
            count ← count + 1
        ENDIF
        n ← n >> 1
    ENDWHILE
    
    RETURN count
END FUNCTION

// Main function
BEGIN
    PRINT hammingWeight(15)
END
Time & Space Complexity Analysis:
Time Complexity: 
𝑂
(
log
⁡
𝑛
)
O(logn) (Since n is divided by 2 in each iteration, it runs approximately log₂(n) times).

Space Complexity: 
𝑂
(
1
)
O(1) (Uses only a few integer variables).

Example Walkthrough (n = 15):
Binary of 15: 1111

Iterations:

1111 → Count = 1

111 → Count = 2

11 → Count = 3

1 → Count = 4

0 (Loop terminates)

Final Output: 4
*/