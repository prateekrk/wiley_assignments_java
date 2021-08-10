package dsa.graphs.weightedGraphs.adjList;

import java.util.*;

class Edge {
    int targetNode;
    int distanceFromNode;

    Edge(int targetNode, int distance) {
        this.targetNode = targetNode;
        this.distanceFromNode = distance;
    }
}

 public class GraphWeightedAdjList {
    List<List<Edge>> graph;
    boolean[] visited;
    int distance[];

     GraphWeightedAdjList() {
        graph = new ArrayList<>();
        visited = new boolean[20];
        distance = new int[20];

        for (int i = 0; i < 20; i++) {
            graph.add(i, new ArrayList<>());
            distance[i] = Integer.MAX_VALUE;
        }
    }

    public void addEdge(int sourceNode, int targetNode, int distance) {
        graph.get(sourceNode).add(new Edge(targetNode, distance));
        //graph.get(targetNode).add(new Edge(sourceNode, distance));
    }

    public int minimumDistanceBetweenTwoNodes(int source, int destination) {
        if (source == destination)
            return 0;

        PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.distanceFromNode));

        distance[source] = 0;
        minHeap.add(new Edge(0, 0));

        while (!minHeap.isEmpty()) {
            int v = minHeap.poll().targetNode;
            if (visited[v])
                continue;

            visited[v] = true;

            List<Edge> childList = graph.get(v);

            for (Edge child : childList) {
                int dist = child.distanceFromNode;
                int childNode = child.targetNode;

                if (!visited[childNode] && (distance[v] + dist < distance[childNode])) {
                    distance[childNode] = distance[v] + dist;
                    child.distanceFromNode = distance[v] + dist;
                    minHeap.add(child);
                }
            }
        }

        return distance[destination];
    }

    boolean pathExists(int source, int destination){
         dfs(destination);
         if(visited[source]){
             return true;
         }
         return false;
    }
    void dfs(int source){
         for(int i=0;i<20;i++){
             visited[i]=false;
         }

         Stack<Integer> s=new Stack<Integer>();

         s.push(source);
         visited[source]=true;

         while(!s.isEmpty()){
             int node=s.pop();
             System.out.print(node + " ");

             List<Edge> neighbours = graph.get(node);

             for(Edge e:neighbours){
                 if(!visited[e.targetNode]){
                     s.push(e.targetNode);
                     visited[e.targetNode]=true;
                 }
             }
         }
    }

    int prims(int source){
        for(int i=0;i<20;i++){
            visited[i]=false;
        }
         PriorityQueue<Edge> pq=new PriorityQueue<Edge>((e1,e2)->e1.distanceFromNode-e2.distanceFromNode);
         int dist=0;

         List<Edge> childofSource=graph.get(source);
         visited[source]=true;

         pq.addAll(childofSource);

         while(!pq.isEmpty()){
             Edge edge=pq.poll();
             dist=dist+edge.distanceFromNode;
             if(visited[edge.targetNode]){
                 continue;
             }
             visited[edge.targetNode]=true;

             List<Edge> childOfNode=graph.get(edge.targetNode);
             for(Edge e:childOfNode){
                 if(!visited[e.targetNode]){
                     pq.add(e);
                 }
             }
         }

         return dist;
    }

}