import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graphs {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }
    // public static void createGraph(ArrayList<Edge> graph[]){
    //     for(int i=0;i<graph.length;i++){
    //         graph[i]=new ArrayList<Edge>();
    //     }
    //     graph[0].add(new Edge(0, 2));
    //     graph[1].add(new Edge(1, 2));
    //     graph[1].add(new Edge(1, 3));

    //     graph[2].add(new Edge(2, 0));
    //     graph[2].add(new Edge(2, 1));
    //     graph[2].add(new Edge(2, 3));

    //     graph[3].add(new Edge(3, 1));
    //     graph[3].add(new Edge(3, 2));
    // }

    static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));
    }
    public static void bfs(ArrayList<Edge>[] graph){
        Queue<Integer>q=new LinkedList<>();
        boolean vis[]=new boolean[graph.length];
        // src =0
        q.add(0);
        while(!q.isEmpty()){
            int curr=q.remove();
            if(!vis[curr]){
                System.out.print(curr+" ");
                vis[curr]=true;
                // to get neighbour
                for(int i=0;i<graph[curr].size();i++){
                    Edge e=graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }
    public static void dfs(ArrayList<Edge>[] graph,int curr,boolean vis[]){
        // visit
        System.out.print(curr+" ");
        vis[curr]=true;
        // calling all the neighbours
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph, e.dest, vis);
            }
        }
    }
    public static boolean hasPath(ArrayList<Edge>[] graph,int src,int dest,boolean vis[]){
        if(src==dest){
            return true;
        }
        for(int i=0;i<graph[src].size();i++){
            Edge e=graph[src].get(i);
            // e.dest is my neighbour
            vis[src]=true;
            if(!vis[e.dest] && hasPath(graph, e.dest, dest, vis)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int V=5;
        ArrayList<Edge>[] graph=new ArrayList[V];

        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();
        }
        // o vertex 
        graph[0].add(new Edge(0, 1,5));
        // 1 vertex 
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));
        // 2 vertex
        graph[2].add(new Edge(2, 1, 3));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 4));

        // 3 vertex 
        graph[3].add(new Edge(3, 1, 3));
         graph[3].add(new Edge(3, 2, 3));
        //  4 vertex

         graph[4].add(new Edge(4, 2, 2));


        // 2's neighbour
        for(int i=0;i<graph[2].size();i++){
            Edge e=graph[2].get(i);
            System.out.println(e.dest);
        }

        // for bfs traversal

        int v=7;
        ArrayList<Edge>graph2[]=new ArrayList[v];
        createGraph(graph2);
        System.out.println("BFS Algo");
        bfs(graph2);
        System.out.println();
        System.out.println("DFS Algo");
        dfs(graph2, 0, new boolean[v]);
        System.out.println( hasPath(graph2, 0, 5, new boolean[v]));
       
    }
}
