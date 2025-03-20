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
