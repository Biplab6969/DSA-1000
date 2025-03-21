public class problem24_8 {
  public static void main(String[] args) {
    // Creating an instance of the class
    problem24_8 obj = new problem24_8();

    // Example test cases
    String[] testCases = {
        "42",                  // Normal number
        "   -42",              // Leading spaces and negative sign
        "4193 with words",     // Number followed by words
        "words and 987",       // Words before number
        "-91283472332",        // Number less than Integer.MIN_VALUE
        "91283472332",         // Number greater than Integer.MAX_VALUE
        "+123",                // Positive sign
        "00000123",            // Leading zeros
        "  +0 123",            // Zero with spaces
        "",                    // Empty string
        "   ",                 // Only spaces
        "+-12",                // Invalid sign sequence
        "2147483648",          // Overflow case
        "-2147483649"          // Underflow case
    };

    // Testing myAtoi function on different inputs
    for (String test : testCases) {
        System.out.println("Input: \"" + test + "\" -> Output: " + obj.myAtoi(test));
    }
}

// The myAtoi function implementation
public int myAtoi(String s) {
    if (s == null) {
        return 0;
    }
    s = s.trim();
    if (s.length() == 0) {
        return 0;
    }
    int sign = +1;
    long ans = 0;

    if (s.charAt(0) == '-') {
        sign = -1;
    }
    int max = Integer.MAX_VALUE;
    int min = Integer.MIN_VALUE;
    int i = (s.charAt(0) == '+' || s.charAt(0) == '-') ? 1 : 0;
    while (i < s.length()) {
        if (s.charAt(i) == ' ' || !Character.isDigit(s.charAt(i))) break;
        ans = ans * 10 + s.charAt(i) - '0';
        if (sign == -1 && -1 * ans < min) return min;
        if (sign == 1 && ans > max) return max;
        i++;
    }
    return (int) (sign * ans);
}
}

// PSEUDOCODE

// FUNCTION myAtoi(s)
//     // Step 1: Handle null input
//     IF s IS NULL THEN
//         RETURN 0
//     END IF

//     // Step 2: Remove leading and trailing spaces
//     SET s TO TRIM(s)

//     // Step 3: Check if the string is empty after trimming
//     IF LENGTH(s) = 0 THEN
//         RETURN 0
//     END IF

//     // Step 4: Initialize sign and answer variables
//     SET sign TO 1
//     SET ans TO 0

//     // Step 5: Check for a sign at the beginning
//     IF FIRST_CHARACTER(s) = '-' THEN
//         SET sign TO -1
//     END IF

//     // Step 6: Initialize integer limits
//     SET max TO INTEGER_MAX_VALUE
//     SET min TO INTEGER_MIN_VALUE

//     // Step 7: Start processing from index 1 if there's a sign, otherwise from index 0
//     IF FIRST_CHARACTER(s) = '+' OR '-' THEN
//         SET i TO 1
//     ELSE
//         SET i TO 0
//     END IF

//     // Step 8: Process numerical characters
//     WHILE i < LENGTH(s) DO
//         IF s[i] IS NOT A DIGIT THEN
//             BREAK
//         END IF

//         // Convert character to digit and update ans
//         SET ans TO ans * 10 + (INTEGER_VALUE(s[i]))

//         // Step 9: Handle integer overflow
//         IF sign = -1 AND (-1 * ans < min) THEN
//             RETURN min
//         END IF
//         IF sign = 1 AND ans > max THEN
//             RETURN max
//         END IF

//         INCREMENT i
//     END WHILE

//     // Step 10: Return the final computed value
//     RETURN (sign * ans)
// END FUNCTION



// ALGORITHM

// Step-by-Step Algorithm:
// Step 1: Handle Null or Empty String
// If the input string s is NULL, return 0 immediately.
// Step 2: Trim Leading and Trailing Whitespace
// Remove any leading or trailing spaces using trim().
// If the string is empty after trimming, return 0.
// Step 3: Determine Sign (+ or -)
// Initialize sign = 1 (default is positive).
// If the first character is '-', set sign = -1.
// If the first character is '+', keep sign = 1.
// Step 4: Set Starting Index for Number Processing
// If the first character is a sign (+ or -), set i = 1 to start processing numbers from index 1. Otherwise, set i = 0.
// Step 5: Convert Characters to Integer
// Initialize ans = 0 (to store the numeric value).
// Start iterating from index i to the end of the string:
// If s[i] is not a digit, break the loop.
// Convert s[i] to its integer value (s[i] - '0').
// Update ans = ans * 10 + (integer value of s[i]).
// Step 6: Handle Integer Overflow/Underflow
// If sign = -1 and -ans < Integer.MIN_VALUE, return Integer.MIN_VALUE (-2147483648).
// If sign = 1 and ans > Integer.MAX_VALUE, return Integer.MAX_VALUE (2147483647).
// Step 7: Return Final Result
// Multiply ans by sign and return the result.
// Time Complexity Analysis
// Trimming the string: 
// 𝑂
// (
// 𝑁
// )
// O(N) (in worst case, entire string is whitespace).
// Iterating through the numeric portion: 
// 𝑂
// (
// 𝑁
// )
// O(N) (single pass through characters).
// Overall Complexity: 
// 𝑂
// (
// 𝑁
// )
// O(N) (linear time complexity).
// Space Complexity Analysis
// Uses only a few integer variables (sign, ans, etc.).
// No extra data structures are used.
// Overall Complexity: 
// 𝑂
// (
// 1
// )
// O(1) (constant space)