import java.util.*;
w
public class Stack {
    static final Stack data = new Stack();
    int[] d = new int[4]; int top = -1;

    void push(int v) { if (top + 1 == d.length) d = Arrays.copyOf(d, d.length * 2); d[++top] = v; } 
    Integer pop()  { return top < 0 ? null : d[top--]; }                                           
    Integer peek() { return top < 0 ? null : d[top]; }                                               
    void display() {
        if (top < 0) { System.out.println("Stack is empty."); return; }
        System.out.print("Top -> "); for (int i = top; i >= 0; i--) System.out.print(d[i] + " "); System.out.println();
    }

    static void menu() {
        while (true) {
            System.out.println("\n--------------- STACK OPERATIONS ---------------\n1. Push\n2. Pop\n3. Peek\n4. Display\n5. Return");
            int c = Main.readInt("Enter your choice: ");
            if (c == 5) return;
            switch (c) {
                case 1 -> { data.push(Main.readInt("Value: ")); System.out.println("Pushed."); }
                case 2 -> { Integer v = data.pop(); System.out.println(v == null ? "Error: stack underflow (stack is empty)." : "Popped " + v); }
                case 3 -> { Integer v = data.peek(); System.out.println(v == null ? "Stack is empty." : "Top = " + v); }
                case 4 -> data.display();
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
