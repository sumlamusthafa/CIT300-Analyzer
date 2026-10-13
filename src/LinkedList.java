public class LinkedList {
    static final LinkedList data = new LinkedList();
    Node head;

    void insertFront(int v) { Node n = new Node(v); n.next = head; head = n; }        
    void insertEnd(int v) {                                                           
        Node n = new Node(v); if (head == null) { head = n; return; }
        Node c = head; while (c.next != null) c = c.next; c.next = n;
    }
    boolean delete(int v) {                                                              
        if (head == null) return false;
        if (head.val == v) { head = head.next; return true; }
        for (Node c = head; c.next != null; c = c.next)
            if (c.next.val == v) { c.next = c.next.next; return true; }
        return false;
    }
    int search(int v) { int i = 0; for (Node c = head; c != null; c = c.next, i++) if (c.val == v) return i; return -1; }   
    void display() {
        if (head == null) { System.out.println("List is empty."); return; }
        for (Node c = head; c != null; c = c.next) System.out.print(c.val + " -> "); System.out.println("null");
    }

    static void menu() {
        while (true) {
            System.out.println("\n------------ LINKED LIST OPERATIONS ------------\n1. Insert at front\n2. Insert at end\n3. Delete\n4. Search\n5. Display\n6. Return");
            int c = Main.readInt("Enter your choice: ");
            if (c == 6) return;
            switch (c) {
                case 1 -> { data.insertFront(Main.readInt("Value: ")); System.out.println("Inserted at front."); }
                case 2 -> { data.insertEnd(Main.readInt("Value: ")); System.out.println("Inserted at end."); }
                case 3 -> System.out.println(data.delete(Main.readInt("Value to delete: ")) ? "Deleted." : "Not found (or list empty).");
                case 4 -> { int i = data.search(Main.readInt("Value to search: ")); System.out.println(i >= 0 ? "Found at position " + i : "Not found."); }
                case 5 -> data.display();
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
