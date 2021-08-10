package dsa.graphs.adjMatrix;

public class GraphAdjMain {
    public static void main(String []args) {
        Graph theGraph = new Graph();
        theGraph.addVertex("A");
        theGraph.addVertex("B");
        theGraph.addVertex("C");
        theGraph.addVertex("D");
        theGraph.addVertex("E");
        theGraph.addVertex("F");


        theGraph.addEdge(0, 1);
        theGraph.addEdge(0, 2);
        theGraph.addEdge(0, 3);
        theGraph.addEdge(0, 4);
        theGraph.addEdge(0, 5);
        theGraph.addEdge(1, 2);
        theGraph.addEdge(1, 3);
        theGraph.addEdge(1, 4);
        theGraph.addEdge(1, 5);
        theGraph.addEdge(2, 3);
        theGraph.addEdge(2, 4);
        theGraph.addEdge(2, 5);
        theGraph.addEdge(3, 4);
        theGraph.addEdge(3, 5);
        theGraph.addEdge(4, 5);


        System.out.println("Visits: ");
        theGraph.dfs();
        System.out.println();

        System.out.println("BFS : ");
        theGraph.bfs();
        System.out.println();

        System.out.println("Minimum Spanning Tree");
        theGraph.minimumSpanningTree();
    }

}
