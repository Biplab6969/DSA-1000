import java.io.*;
public class problem8_151 {
  
static private String result(String s)
{
	int left = 0;
	int right = s.length() - 1;

	String temp = "";
	String ans = "";

	//Iterate the string and keep on adding to form a word
	//If empty space is encountered then add the current word to the result
	while (left <= right)
	{
		char ch = s.charAt(left);
		if (ch != ' ')
		{
			temp += ch;
		}
		else if (ch == ' ')
		{
			if (!ans.equals(""))
			{
				ans = temp + " " + ans;
			}
			else
			{
				ans = temp;
			}
			temp = "";
		}
		left++;
	}

	//If not empty string then add to the result(Last word is added)
	if (!temp.equals(""))
	{
		if (!ans.equals(""))
		{
			ans = temp + " " + ans;
		}
		else
		{
			ans = temp;
		}
	}

	return ans;
}
public static void main(String[] args)
{
	String st = "TUF is great for interview preparation";
	System.out.println("Before reversing words: ");
    System.out.println(st);
    System.out.println("After reversing words: ");
	System.out.print(result(st));
}
}



// Algorithm:
// Initialize Pointers and Variables:

// Set left = 0, right = s.length() - 1.

// Use temp to store individual words.

// Use ans to store the final result.

// Iterate Over the String to Extract Words:

// If s[left] is not a space, append it to temp (forming a word).

// If s[left] is a space and temp is not empty:

// Add temp to ans in reverse order (i.e., ans = temp + " " + ans).

// Reset temp for the next word.

// Add the Last Word:

// If temp is not empty after the loop, append it to ans.

// Return ans, which contains words in reversed order.

// Pseudocode:
// sql
// Copy
// Edit
// FUNCTION result(s):
//     left ← 0
//     right ← length(s) - 1
//     temp ← ""
//     ans ← ""

//     WHILE left ≤ right:
//         ch ← s[left]
        
//         IF ch is NOT space:
//             temp ← temp + ch
//         ELSE IF ch is space:
//             IF ans is NOT empty:
//                 ans ← temp + " " + ans
//             ELSE:
//                 ans ← temp
//             temp ← ""  // Reset temp for next word

//         left ← left + 1

//     // Add last word if temp is not empty
//     IF temp is NOT empty:
//         IF ans is NOT empty:
//             ans ← temp + " " + ans
//         ELSE:
//             ans ← temp

//     RETURN ans

// // Main Function
// BEGIN
//     st ← "TUF is great for interview preparation"
//     PRINT "Before reversing words: ", st
//     PRINT "After reversing words: ", result(st)
// END
// Time & Space Complexity Analysis:
// Time Complexity: 
// 𝑂
// (
// 𝑛
// )
// O(n)

// Each character is processed once, making it linear.

// Space Complexity: 
// 𝑂
// (
// 𝑛
// )
// O(n)

// The reversed string takes up additional space.
