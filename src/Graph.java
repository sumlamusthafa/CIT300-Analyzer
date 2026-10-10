import java.util.*;

public class Graph {
    static final Graph data = new Graph();
    Map<Integer, List<Integer>> adj = new TreeMap<>();

    boolean addVertex(int v) { if (adj.containsKey(v)) return false; adj.put(v, new ArrayList<>()); return true; }
    boolean addEdge(int u, int v) {
        if (!adj.containsKey(u) || !adj.containsKey(v) || u == v || adj.get(u).contains(v)) return false;
        adj.get(u).add(v); adj.get(v).add(u); return true;
    }
    void display() {
        if (adj.isEmpty()) { System.out.println("Graph is empty."); return; }
        adj.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
    Object[] bfs(int start) {
        List<Integer> order = new ArrayList<>(); Set<Integer> seen = new HashSet<>();
        java.util.Queue<Integer> q = new ArrayDeque<>(); int steps = 0;
        q.add(start); seen.add(start);
        while (!q.isEmpty()) {
            int u = q.poll(); order.add(u);
            for (int w : adj.get(u)) { steps++; if (seen.add(w)) q.add(w); }
        }
        return new Object[]{order, steps};
    }

    Object[] dfs(int start) {
        List<Integer> order = new ArrayList<>(); Set<Integer> seen = new HashSet<>();
        Deque<Integer> st = new ArrayDeque<>(); int steps = 0;
        st.push(start);
        while (!st.isEmpty()) {
            int u = st.pop();
            if (!seen.add(u)) continue;
            order.add(u);
            List<Integer> nb = adj.get(u);
            for (int i = nb.size() - 1; i >= 0; i--) { steps++; if (!seen.contains(nb.get(i))) st.push(nb.get(i)); }
        }
        return new Object[]{order, steps};
    }

    static void menu() {
        while (true) {
            System.out.println("\n--------------- GRAPH OPERATIONS ---------------\n1. Add Vertex\n2. Add Edge\n3. Display Graph\n4. BFS Traversal\n5. DFS Traversal\n6. Return");
            int c = Main.readInt("Enter your choice: ");
            if (c == 6) return;
            switch (c) {
                case 1 -> System.out.println(data.addVertex(Main.readInt("Vertex id: ")) ? "Vertex added." : "Vertex already exists.");
                case 2 -> { int u = Main.readInt("From: "), v = Main.readInt("To: ");
                    System.out.println(data.addEdge(u, v) ? "Edge added." : "Invalid edge (missing vertex, self-loop or duplicate)."); }
                case 3 -> data.display();
                case 4, 5 -> {
                    if (data.adj.isEmpty()) { System.out.println("Graph is empty."); break; }
                    int s = Main.readInt("Start vertex: ");
                    if (!data.adj.containsKey(s)) { System.out.println("Vertex does not exist."); break; }
                    Object[] r = c == 4 ? data.bfs(s) : data.dfs(s);
                    String line = (c == 4 ? "BFS" : "DFS") + " from " + s + ": " + r[0] + " | steps=" + r[1];
                    System.out.println(line); Main.results.add(line);
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
