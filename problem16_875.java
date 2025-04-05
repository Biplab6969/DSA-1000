public class problem16_875 {

  private static int sumbyD(int[] piles, int mid){
    int n = piles.length;
    int sum = 0;
    for(int i=0; i<n; i++){
        sum += Math.ceil((double)(piles[i]) / (double)(mid));
    }
    return sum;
}


private static int minEatingSpeed(int[] piles, int h) {
    int n = piles.length;
    if(n>h){
        return -1;
    }

    int maxi = Integer.MIN_VALUE;
    for(int i=0; i<n; i++){
        maxi = Math.max(maxi, piles[i]);
    }
    int low = 1;
    int high = maxi;
    while(low <= high){
        int mid = low + (high - low)/2;
        if(sumbyD(piles, mid) <= h){
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    return low;
}
  public static void main(String[] args) {
    int[] piles = {7, 15, 6, 3};
    int h = 8;
    int ans = minEatingSpeed( piles,  h);
    System.out.println("Koko should eat at least " + ans + " bananas/hr.");
}
}


// 🧠 Algorithm Explanation (Step-by-step):
// ✅ Step 1: Define the Search Space
// java
// Copy
// Edit
// low = 1;
// high = max(piles);
// Because:

// Minimum she can eat is 1 banana/hour

// Maximum (worst case) is eating the largest pile in 1 hour

// ✅ Step 2: Binary Search Loop
// java
// Copy
// Edit
// while (low <= high):
//     mid = (low + high)/2;
//     totalHours = sumbyD(piles, mid);
//     if (totalHours <= h):
//         high = mid - 1; // try smaller speed
//     else:
//         low = mid + 1; // increase speed
// You calculate how many hours it would take for a given speed (mid) and adjust your search based on whether it fits within h.

// ✅ Step 3: The sumbyD() Function
// This function calculates how many hours Koko would take if she eats at mid speed.

// java
// Copy
// Edit
// sum += Math.ceil((double)piles[i] / (double)mid);
// Since even eating a partial pile takes a full hour, we use Math.ceil().

// ✅ Step 4: Return the Result
// java
// Copy
// Edit
// return low;
// When the loop ends, low holds the smallest k that lets her eat all bananas within h hours.