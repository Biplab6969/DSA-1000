import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class problem25_13 {
      public static int romanToInt(String s) {
        Map<Character, Integer> m = new HashMap<>();
        
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);
        
        int ans = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && m.get(s.charAt(i)) < m.get(s.charAt(i + 1))) {
                ans -= m.get(s.charAt(i));
            } else {
                ans += m.get(s.charAt(i));
            }
        }
        
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a Roman numeral: ");
        String roman = sc.nextLine().toUpperCase(); // Convert to uppercase for consistency
        
        int result = romanToInt(roman);
        System.out.println("Integer value: " + result);
        
        sc.close();
    }
}

// PSEUDOCODE :-
// FUNCTION romanToInt(s)
//     // Step 1: Create a mapping of Roman numerals to integers
//     DECLARE map m
//     ADD ('I' → 1, 'V' → 5, 'X' → 10, 'L' → 50, 'C' → 100, 'D' → 500, 'M' → 1000) TO m
    
//     // Step 2: Initialize the answer variable
//     SET ans TO 0

//     // Step 3: Loop through each character in the string
//     FOR i FROM 0 TO length of s - 1 DO
//         // Step 4: If the current numeral is smaller than the next one, subtract its value
//         IF i < length of s - 1 AND m[s[i]] < m[s[i + 1]] THEN
//             SET ans TO ans - m[s[i]]
//         ELSE
//             // Otherwise, add its value
//             SET ans TO ans + m[s[i]]
//         END IF
//     END FOR

//     // Step 5: Return the computed integer value
//     RETURN ans
// END FUNCTION

// // Main function to test the conversion
// FUNCTION main()
//     PRINT "Enter a Roman numeral: "
//     INPUT roman_string
//     result ← CALL romanToInt(roman_string)
//     PRINT "Integer value: ", result
// END FUNCTION





// ALGORITHM:-
// Step-by-Step Algorithm:
// Step 1: Create a Mapping of Roman Numerals to Integers
// Initialize a HashMap m that stores the values of Roman numeral symbols:
// 'I' → 1, 'V' → 5, 'X' → 10, 'L' → 50, 'C' → 100, 'D' → 500, 'M' → 1000
// Step 2: Initialize Variables
// Create an integer variable ans = 0 to store the final result.
// Step 3: Traverse the String from Left to Right
// Loop through each character s[i] in the Roman numeral string:
// If the current numeral s[i] is smaller than the next numeral s[i+1], subtract its value from ans.
// Otherwise, add its value to ans.
// Step 4: Return the Final Integer Value
// After processing all characters, return the computed value ans.
// Time and Space Complexity Analysis
// Time Complexity: 
// 𝑂
// (
// 𝑁
// )
// O(N), where 
// 𝑁
// N is the length of the input string (since we traverse it once).
// Space Complexity: 
// 𝑂
// (
// 1
// )
// O(1) (we use a fixed-sized HashMap, not dependent on input length).
