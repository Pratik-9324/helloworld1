import java.util.LinkedList;
import java.util.Queue;

class Graph {
    private int V; // Number of vertices
    private LinkedList<Integer>[] adj; // Adjacency list representation

    @SuppressWarnings("unchecked")
    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    // Add an edge to the graph
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // Recursive BFS traversal
    private void bfsUtil(Queue<Integer> queue, boolean[] visited) {
        if (queue.isEmpty()) {
            return;
        }

        int vertex = queue.poll();
        System.out.print(vertex + " ");

        for (int neighbor : adj[vertex]) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                queue.add(neighbor);
            }
        }

        bfsUtil(queue, visited);
    }

    // Main BFS function
    public void bfs(int startVertex) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        bfsUtil(queue, visited);
    }
}

public class RecursiveBFS {
    public static void main(String[] args) {
        Graph graph = new Graph(8);

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);
        graph.addEdge(4, 5);
        graph.addEdge(6, 7);

        System.out.println("Recursive BFS starting from vertex 0:");
        graph.bfs(0);
    }
}
