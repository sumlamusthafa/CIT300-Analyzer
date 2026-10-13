public class Performance {
    static void run() {
        System.out.println("\n=============================================\n PERFORMANCE COMPARISON\n=============================================");
        System.out.printf("%-16s %-16s %-10s %-12s%n", "Operation", "Algorithm", "Steps", "Time(ns)");
        System.out.println("------------------------------------------------------------");
        for (int n : new int[]{1000, 10000, 100000}) {
            int[] data = new int[n]; for (int i = 0; i < n; i++) data[i] = i * 2;   
            int key = data[n - 1];
            long t = System.nanoTime(); int[] l = Searching.linearSearch(data, n, key); long tl = System.nanoTime() - t;
            t = System.nanoTime(); int[] b = Searching.binarySearch(data, n, key); long tb = System.nanoTime() - t;
            print("Search n=" + n, "Linear O(n)", l[1], tl); print("Search n=" + n, "Binary O(log n)", b[1], tb);
        }
        Graph g = Graph.data;
        if (g.adj.isEmpty()) {   
            g = new Graph(); for (int i = 1; i <= 8; i++) g.addVertex(i);
            int[][] e = {{1,2},{1,3},{2,4},{2,5},{3,6},{3,7},{5,8},{6,8}}; for (int[] x : e) g.addEdge(x[0], x[1]);
            System.out.println("(Graph empty - using sample graph of 8 vertices)");
        }
        int s = g.adj.keySet().iterator().next();
        long t = System.nanoTime(); Object[] bf = g.bfs(s); long tb = System.nanoTime() - t;
        t = System.nanoTime(); Object[] df = g.dfs(s); long td = System.nanoTime() - t;
        print("Graph Traversal", "BFS O(V+E)", (int) bf[1], tb); print("Graph Traversal", "DFS O(V+E)", (int) df[1], td);
        System.out.println("=============================================");
        System.out.println("Note: binary search needs far fewer steps (log n vs n) but requires sorted data.");
    }
    static void print(String op, String algo, int steps, long ns) {
        String line = String.format("%-16s %-16s %-10d %-12d", op, algo, steps, ns);
        System.out.println(line); Main.results.add(line);
    }
}
