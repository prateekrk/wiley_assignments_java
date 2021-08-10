package dsa.graphs.weightedGraphs.adjList;

public class GraphWeightedAdjListMain {
    public static void main(String args[]) {
        GraphWeightedAdjList graphWeightedAdjList = new GraphWeightedAdjList();

//        graphWeightedAdjList.addVertex("A");
//        graphWeightedAdjList.addVertex("C");
//        graphWeightedAdjList.addVertex("D");
//        graphWeightedAdjList.addVertex("E");
//        graphWeightedAdjList.addVertex("F");
//        graphWeightedAdjList.addVertex("G");

        graphWeightedAdjList.addEdge(0,1,5);
        graphWeightedAdjList.addEdge(0,3,8);
        graphWeightedAdjList.addEdge(1,2,6);
        graphWeightedAdjList.addEdge(1,3,5);
        graphWeightedAdjList.addEdge(2,4,4);
        graphWeightedAdjList.addEdge(3,2,2);
        graphWeightedAdjList.addEdge(3,4,7);
        graphWeightedAdjList.addEdge(4,1,5);
//        graphWeightedAdjList.addEdge(0,1,5);
//        graphWeightedAdjList.addEdge(0,1,5);
//
//        System.out.println(graphWeightedAdjList.minimumDistanceBetweenTwoNodes(0,3));
//
//        System.out.println("\nDFS: ");
//        graphWeightedAdjList.dfs(0);
//
//        System.out.println("path exists : "+graphWeightedAdjList.pathExists(2,3));

        System.out.println("Prims minimum spanning tree distance :"+ graphWeightedAdjList.prims(0));


    }

}
