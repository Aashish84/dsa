package uniform_cost_serach;

import java.util.*;

class Edge<T> {
    T source;
    T destination;
    int weight;
    String path;

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

    private Map<T, List<Edge<T>> > map = new HashMap<>();

    // This function adds a new vertex to the graph
    public void addVertex(T s)
    {
        map.put(s, new LinkedList<Edge<T>>());
    }

    public void addEdge( T source, T destination, int weight )
    {

        if (!map.containsKey(source))
            addVertex( source);

        if (!map.containsKey(destination))
            addVertex(destination);

        map.get(source).add(new Edge<>(source , destination , weight));
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

    // uniform cost search using priority queue
    public void ucs(T source , T des){

        // Set<T> set = new HashSet<>();
        
        // set.add(source);
        PriorityQueue<Edge<T>> pq = new PriorityQueue<>(
            (a,b)->a.weight - b.weight
        );
        for(Edge<T> val : map.get(source)){
            val.path = source +" -> "+ val.destination;
            pq.add(val);
            // set.add(val.destination);
        }

        while(!pq.isEmpty()){
            Edge<T> tmp = pq.poll();

            if(tmp.destination.equals(des)){
                System.out.println("reached , weight : " + tmp.weight+" // path : "+ tmp.path);
                break;
            }

            if(map.containsKey(tmp.destination)){
                for(Edge<T> val : map.get(tmp.destination)){
                    // if(!set.contains(val.destination)){
                        val.weight = tmp.weight + val.weight;
                        val.path = tmp.path + " -> " + val.destination;
                        pq.add(val);
                        // set.add(val.destination);
                    // }
                }
            }
        }
    }
    
    // Prints the adjancency list of each vertex.
    @Override
    public String toString(){
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

public class DirectedGraph {

    public static void main(String args[]){

        Graph<String> g2 = new Graph<>();
        g2.addEdge("Source", "b", 3);
        g2.addEdge("Source", "c", 5);
        g2.addEdge("b", "f", 4);
        g2.addEdge("c", "e", 2);
        g2.addEdge("c", "d", 1);
        g2.addEdge("f", "j", 1);
        g2.addEdge("e", "f", 2);
        g2.addEdge("d", "e", 4);
        g2.addEdge("e", "dest", 1);

        System.out.println(g2.toString());

        System.out.println("=========");

        g2.ucs("Source", "dest");

    }
} 
