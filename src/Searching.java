import java.util.*;

public class Searching {
    static int[] linearSearch(int[] a, int n, int key) {    
        int steps = 0;
        for (int i = 0; i < n; i++) { steps++; if (a[i] == key) return new int[]{i, steps}; }
        return new int[]{-1, steps};
    }
    static int[] binarySearch(int[] a, int n, int key) {      
        int lo = 0, hi = n - 1, steps = 0;
        while (lo <= hi) {
            steps++; int mid = (lo + hi) >>> 1;
            if (a[mid] == key) return new int[]{mid, steps};
            if (a[mid] < key) lo = mid + 1; else hi = mid - 1;
        }
        return new int[]{-1, steps};
    }

    static void menu() {
        System.out.println("\n--------------- SEARCHING OPERATIONS ---------------");
        IntArray arr = IntArray.data;
        if (arr.size == 0) { System.out.println("Array is empty. Insert values via Array Operations first."); return; }
        int key = Main.readInt("Value to search: ");
        int[] sorted = Arrays.copyOf(arr.a, arr.size); Arrays.sort(sorted);   
        long t1 = System.nanoTime(); int[] lin = linearSearch(arr.a, arr.size, key); t1 = System.nanoTime() - t1;
        long t2 = System.nanoTime(); int[] bin = binarySearch(sorted, sorted.length, key); t2 = System.nanoTime() - t2;
        String r1 = "Linear Search | key=" + key + " | index=" + lin[0] + " | steps=" + lin[1] + " | " + t1 + " ns";
        String r2 = "Binary Search | key=" + key + " | index=" + bin[0] + " (in sorted copy) | steps=" + bin[1] + " | " + t2 + " ns";
        System.out.println(r1); System.out.println(r2); Main.results.add(r1); Main.results.add(r2);
    }
}
