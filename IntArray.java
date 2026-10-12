import java.util.*;

public class IntArray {
    static final IntArray data = new IntArray();   
    int[] a = new int[4]; int size = 0;

    void insert(int v) { if (size == a.length) a = Arrays.copyOf(a, size * 2); a[size++] = v; }   
    boolean delete(int v) {                                                                      
        for (int i = 0; i < size; i++)
            if (a[i] == v) { System.arraycopy(a, i + 1, a, i, size - i - 1); size--; return true; }
        return false;
    }
    int indexOf(int v) { for (int i = 0; i < size; i++) if (a[i] == v) return i; return -1; }    
    void display() { System.out.println(size == 0 ? "Array is empty." : Arrays.toString(Arrays.copyOf(a, size))); }

    static void menu() {
        while (true) {
            System.out.println("\n--------------- ARRAY OPERATIONS ---------------\n1. Insert\n2. Delete\n3. Search\n4. Display\n5. Return");
            int c = Main.readInt("Enter your choice: ");
            if (c == 5) return;
            switch (c) {
                case 1 -> { data.insert(Main.readInt("Value: ")); System.out.println("Inserted."); }
                case 2 -> System.out.println(data.delete(Main.readInt("Value to delete: ")) ? "Deleted." : "Value not found.");
                case 3 -> { int i = data.indexOf(Main.readInt("Value to search: ")); System.out.println(i >= 0 ? "Found at index " + i : "Not found."); }
                case 4 -> data.display();
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
