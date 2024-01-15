import java.util.ArrayList;

public class Dijkstra {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s ,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
         }
    }
    static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1,10 ));
        graph[0].add(new Edge(0, 2,5 ));
        graph[1].add(new Edge(1, 3, 1));
        graph[2].add(new Edge(2, 1, 3));
        graph[2].add(new Edge(2,3 , 1));
    }
}
