public class Queue {
    static final Queue data = new Queue();
    Node front, rear;

    void enqueue(int v) { Node n = new Node(v); if (rear == null) front = rear = n; else { rear.next = n; rear = n; } }   
    Integer dequeue() {                                                                                              
        if (front == null) return null;
        int v = front.val; front = front.next; if (front == null) rear = null; return v;
    }
    Integer peek() { return front == null ? null : front.val; }
    void display() {
        if (front == null) { System.out.println("Queue is empty."); return; }
        System.out.print("Front -> "); for (Node n = front; n != null; n = n.next) System.out.print(n.val + " "); System.out.println("<- Rear");
    }

    static void menu() {
        while (true) {
            System.out.println("\n--------------- QUEUE OPERATIONS ---------------\n1. Enqueue\n2. Dequeue\n3. Peek/Front\n4. Display\n5. Return");
            int c = Main.readInt("Enter your choice: ");
            if (c == 5) return;
            switch (c) {
                case 1 -> { data.enqueue(Main.readInt("Value: ")); System.out.println("Enqueued."); }
                case 2 -> { Integer v = data.dequeue(); System.out.println(v == null ? "Error: queue underflow (queue is empty)." : "Dequeued " + v); }
                case 3 -> { Integer v = data.peek(); System.out.println(v == null ? "Queue is empty." : "Front = " + v); }
                case 4 -> data.display();
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
