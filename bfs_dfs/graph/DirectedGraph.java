package bfs_dfs.graph;

import java.util.*;

class Edge<T> {
    T source;
    T destination;
    int weight;

    public Edge(T source , T destination , int weight){
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "[destination=" + destination + ", source=" + source + ", weight=" + weight + "]";
    }
    
}

class Graph<T> {

    // We use Hashmap to store the edges in the graph
    private Map<T, List<Edge<T>> > map = new HashMap<>();

    // This function adds a new vertex to the graph
    public void addVertex(T s)
    {
        map.put(s, new LinkedList<Edge<T>>());
    }

    // This function adds the edge
    // between source to destination
    public void addEdge(T source,
                        T destination,
                        boolean bidirectional,
                        int weight
                        )
    {

        if (!map.containsKey(source))
            addVertex( source);

        if (!map.containsKey(destination))
            addVertex(destination);

        map.get(source).add(new Edge<>(source , destination , weight));
        if (bidirectional == true) {
            map.get(destination).add(new Edge<>(destination , source , weight));
        }
    }

    public void bfs(T start_vertex){
        if(map.size()==0){return;}

        Queue<T> q = new LinkedList<>();
        q.add(start_vertex);
        Set<T> set = new HashSet<>();
        set.add(start_vertex);
        while(!q.isEmpty()){
            T tmp = q.remove();
            System.out.println(tmp);
            int tmp_arr_size = map.get(tmp).size();
            for(int i = 0 ; i < tmp_arr_size ; i++){
                T tmp_destination = map.get(tmp).get(i).destination;
                if(!set.contains(tmp_destination)){
                    q.add(tmp_destination);
                    set.add(tmp_destination);
                }
            }
        }
    }

    Map<T , Boolean> visited = new HashMap<>();
    public void dfs(T next2){
        System.out.println(next2);
        visited.put(next2 , true);
       
        Iterator<Edge<T>> ite = map.get(next2).listIterator();
        while(ite.hasNext()){
            T next = ite.next().destination;
            if(!visited.containsKey(next)){
                dfs(next);
            }
        }
    }

    
    // Prints the adjancency list of each vertex.
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        for (T v : map.keySet()) {
            builder.append(v.toString() + ": ");
            for (Edge<T> w : map.get(v)) {
                builder.append(w.toString() + " ");
            }
            builder.append("\n");
        }

        return (builder.toString());
    }

}
// Driver Code
public class DirectedGraph {

    public static void main(String args[])
    {

        // Object of graph is created.
        Graph<Integer> g = new Graph<Integer>();

        // edges are added.
        // Since the graph is bidirectional,
        // so boolean bidirectional is passed as true.
        g.addEdge(0, 1,true ,1);
        g.addEdge(0, 4, true ,1);
        g.addEdge(1, 2, true ,1);
        g.addEdge(1, 3, true,1) ;
        g.addEdge(1, 4, true,1);
        g.addEdge(2, 3, true,1);
        g.addEdge(3, 4, true,1);

        // Printing the graph
        System.out.println("Graph:\n"
                           + g.toString());


        g.bfs(4);
        System.out.println("===========");
        g.dfs(4);
    }
} 
