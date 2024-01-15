import java.util.Arrays;

class DijkstraAlgorithm {

    private static final int INF = Integer.MAX_VALUE;

    private static void dijkstra(int[][] graph, int source, int vertices) {
        int[] dist = new int[vertices];
        boolean[] visited = new boolean[vertices];

        Arrays.fill(dist, INF);
        dist[source] = 0;

        for (int count = 0; count < vertices - 1; count++) {
            int u = minDistance(dist, visited, vertices);
            visited[u] = true;

            for (int v = 0; v < vertices; v++) {
                if (!visited[v] && graph[u][v] != 0 && dist[u] != INF
                        && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        printSolution(dist, vertices);
    }

    private static int minDistance(int[] dist, boolean[] visited, int vertices) {
        int min = INF;
        int minIndex = -1;

        for (int v = 0; v < vertices; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    private static void printSolution(int[] dist, int vertices) {
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < vertices; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int vertices = 5;
        int[][] graph = {
                {0, 10, 5, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 3, 0, 9, 2},
                {0, 0, 0, 0, 0},
                {8, 0, 0, 6, 0}
        };
        int source = 0;

        System.out.println("Dijkstra's Algorithm:");
        dijkstra(graph, source, vertices);
    }
}
