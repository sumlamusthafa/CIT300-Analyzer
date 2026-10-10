import java.util.*;

public class Main {
    static final Scanner sc = new Scanner(System.in);
    static final List<String> results = new ArrayList<>();   
    static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try { return Integer.parseInt(sc.nextLine().trim()); }
            catch (NumberFormatException e) { System.out.println("Invalid input: enter a whole number."); }
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=============================================\n DATA STRUCTURE & GRAPH ANALYZER\n=============================================");
            System.out.println("1. Array Operations\n2. Stack Operations\n3. Queue Operations\n4. Linked List Operations\n5. Searching Operations\n6. Graph Operations\n7. Performance Comparison\n8. Display All Results\n9. Exit");
            switch (readInt("Enter your choice: ")) {
                case 1 -> IntArray.menu();
                case 2 -> Stack.menu();
                case 3 -> Queue.menu();
                case 4 -> LinkedList.menu();
                case 5 -> Searching.menu();
                case 6 -> Graph.menu();
                case 7 -> Performance.run();
                case 8 -> { if (results.isEmpty()) System.out.println("No results recorded yet."); else results.forEach(System.out::println); }
                case 9 -> { System.out.println("Goodbye!"); return; }
                default -> System.out.println("Invalid choice. Enter 1-9.");
            }
        }
    }
}
