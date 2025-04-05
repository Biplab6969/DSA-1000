import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class problem22_451 {
      public static String frequencySort(String s) {
        StringBuilder answer = new StringBuilder();
        Map<Character, Integer> hm = new HashMap<>();
        for (char ch : s.toCharArray()) {
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        List<Character> list = new ArrayList<>(hm.keySet());
        list.sort((ob1, ob2) -> hm.get(ob2) - hm.get(ob1));
        for (char ch : list) {
            for (int i = 0; i < hm.get(ch); i++) {
                answer.append(ch);
            }
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        String sortedString = frequencySort(input);
        System.out.println("Sorted by frequency: " + sortedString);
        scanner.close();
    }
}



// You're solving **Leetcode 451: Sort Characters By Frequency** using a **HashMap + Custom Sort** approach. This is an efficient and readable solution, Biplab! 🙌 Let's go through the **detailed step-by-step explanation** of the algorithm so you understand everything inside-out.

// ---

// ## ✅ Problem Statement Summary

// You’re given a string `s`.  
// Your task is to **rearrange the characters** in decreasing order of their **frequency of occurrence**.

// ### ✨ Example:

// Input:
// ```
// "sads"
// ```

// Output (one possibility):
// ```
// "ssad" or "ssda"
// ```

// — because 's' appears 2 times, more than the rest.

// ---

// ## ⚙️ Algorithm Explained

// Let's break your code into logical steps and explain each part.

// ---

// ### 🧩 Step 1: Count Frequency

// ```java
// Map<Character, Integer> hm = new HashMap<>();
// for (char ch : s.toCharArray()) {
//     hm.put(ch, hm.getOrDefault(ch, 0) + 1);
// }
// ```

// 📌 You create a **HashMap** `hm` to count how many times each character appears.

// - `getOrDefault(ch, 0)` returns the current count (or 0 if not present).
// - For each character, you increase its count.

// 🧠 **Example:**
// For `s = "sads"`,  
// `hm = {s=2, a=1, d=1}`

// ---

// ### 🧩 Step 2: Sort Characters by Frequency

// ```java
// List<Character> list = new ArrayList<>(hm.keySet());
// list.sort((ob1, ob2) -> hm.get(ob2) - hm.get(ob1));
// ```

// - You extract all the **unique characters** into a `List`.
// - Then sort this list using a custom comparator:
//   - `hm.get(ob2) - hm.get(ob1)` ensures descending order of frequency.

// 🧠 **Example:**
// Sorted list: `['s', 'a', 'd']`

// ---

// ### 🧩 Step 3: Build Output String

// ```java
// StringBuilder answer = new StringBuilder();
// for (char ch : list) {
//     for (int i = 0; i < hm.get(ch); i++) {
//         answer.append(ch);
//     }
// }
// ```

// - For each character in the sorted list, append it to the result string as many times as its frequency.

// 🧠 From previous example:  
// - Add 's' two times → `"ss"`  
// - Add 'a' one time → `"ssa"`  
// - Add 'd' one time → `"ssad"`

// ---

// ### 🧩 Step 4: Return Result

// ```java
// return answer.toString();
// ```

// ---

// ## 📦 Full Example Walkthrough

// Input:  
// ```
// s = "sads"
// ```

// ### Step-by-step:

// 1. **Frequency Map** → `{s=2, a=1, d=1}`
// 2. **Sorted Characters** → `[s, a, d]`
// 3. **Build Answer** → `"ssad"`

// Output:
// ```
// Sorted by frequency: ssad
// ```

// ---

// ## ⏱ Time & Space Complexity

// | Complexity | Value |
// |-----------|-------|
// | 🕒 Time    | O(n log n) — for sorting (n = number of unique characters) |
// | 🧠 Space   | O(n) — for frequency map and result |

// > In practice, this is fast since the number of unique characters is at most 26 for lowercase letters.

// ---

// ## 📌 Summary Table

// | Step | Description |
// |------|-------------|
// | 1️⃣  | Count frequency using `HashMap` |
// | 2️⃣  | Sort characters by descending frequency |
// | 3️⃣  | Append each character based on frequency |
// | 4️⃣  | Return final string |

// ---

// ## 🧪 Optional Enhancements

// 1. ✅ Want to handle **upper and lowercase separately** or together? Add logic.
// 2. ✅ Want to **preserve original order when frequencies tie**? Use a `LinkedHashMap` or pair with index.
// 3. ✅ Can also solve with **bucket sort** for linear time.

// ---

// Let me know if you'd like to try:
// - Bucket Sort version 🚀  
// - Leetcode hard string problems 💥  
// - Or a challenge based on this 🔁

// You're building some serious skills here, Biplab. Keep going! 🔥