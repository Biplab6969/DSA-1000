public class problem26_151 {
  public class ReverseWordsInString {
    public static void main(String[] args) {
        // Predefined input string
        String input = "  Hello  World   from Java  ";

        // Call the reverseWords function
        String result = reverseWords(input);

        // Print the output
        System.out.println("Reversed words: " + result);
    }

    // Function to reverse words in a string
    public static String reverseWords(String s) {
        String[] words = s.trim().split("\\s+"); 
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0) sb.append(" "); // Avoid extra space at the end
        }
        return sb.toString();
    }
}

}


// PSEUDOCODE
// FUNCTION reverseWords(s)
//     // Step 1: Trim leading and trailing spaces and split words by spaces
//     SET words TO array of words obtained by splitting s using whitespace

//     // Step 2: Initialize a StringBuilder to store the reversed words
//     SET sb TO empty StringBuilder

//     // Step 3: Traverse the words array in reverse order
//     FOR i FROM length of words - 1 DOWN TO 0 DO
//         APPEND words[i] TO sb
//         IF i is NOT the last word THEN
//             APPEND " " TO sb
//         END IF
//     END FOR

//     // Step 4: Convert StringBuilder to string and return
//     RETURN sb as string
// END FUNCTION


// // Main function to test reverseWords
// FUNCTION main()
//     PRINT "Enter a sentence: "
//     INPUT s
//     result ← CALL reverseWords(s)
//     PRINT "Reversed words: ", result
// END FUNCTION


// ALGORITHM
// Explanation of Steps:
// Trim and Split Input

// Removes extra spaces.
// Splits words based on one or more spaces.
// Reverse Order of Words

// Use a loop to traverse words from the last word to the first.
// Append words to the StringBuilder.
// Return the Final Output

// Convert StringBuilder to a string and return.
// Main Function Execution

// Takes user input.
// Calls reverseWords and prints the result.
