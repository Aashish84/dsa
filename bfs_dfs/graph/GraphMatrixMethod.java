package bfs_dfs.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class GraphMatrix{
    private boolean adjMatrix[][];
    private int numVertices;

    // Initialize the matrix
    public GraphMatrix(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new boolean[numVertices][numVertices];
    }

    // Add edges
    public void addEdge(int i, int j) {
        adjMatrix[i][j] = true;
        adjMatrix[j][i] = true;
    }

    // Remove edges
    public void removeEdge(int i, int j) {
        adjMatrix[i][j] = false;
        adjMatrix[j][i] = false;
    }

    // Print the matrix
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
        s.append(i + ": ");
        for (boolean j : adjMatrix[i]) {
            s.append((j ? 1 : 0) + " ");
        }
        s.append("\n");
        }
        return s.toString();
    }

    public void print(){
        for (int i = 0 ; i < adjMatrix.length ; i++){
            System.out.print(i+": ");
            for(int j = 0 ; j < adjMatrix[i].length ; j++){
                if(adjMatrix[i][j]){
                    System.out.print(1);
                }else{
                    System.out.print(0);
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void bft(){
        int start = 0;
        Queue <Integer> q = new LinkedList<>();

        q.add(start);
        Set<Integer> set = new HashSet<>();
        while(!q.isEmpty()){
            
            int tmp = q.remove();

            if(!set.contains(tmp)){
                System.out.println("visited : "+tmp);
                set.add(tmp);
            }


            for (int i = 0 ; i < adjMatrix[tmp].length ; i++){
                if(adjMatrix[tmp][i]){
                    if(!set.contains(i)){
                        q.add(i);
                    }
                }
            }

        }
        System.out.println(set);
    }

}
class GraphMatrixMethod{

    public static void main(String[] args) {
        GraphMatrix g = new GraphMatrix(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(0, 4);

        // System.out.print(g.toString());

        g.print();
        g.bft();
    }
}