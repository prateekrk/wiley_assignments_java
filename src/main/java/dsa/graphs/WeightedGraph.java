package dsa.graphs;

import sun.reflect.generics.tree.Tree;

import javax.sound.sampled.Line;
import java.util.*;
import java.util.stream.Collectors;

public class WeightedGraph
{
    Map<Integer, LinkedList<Node>> map=new HashMap<>();
    Set<Node> settles=new HashSet<>();
    List<LinkedList<Node>> adj_list;

    private int dist[];
    PriorityQueue<Node > pq=new PriorityQueue<>(new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.getWeight()-o2.getWeight();
        }
    });
    class Node{
        int source;
        int destination;
        int weight;

        public void setDestination(int destination) {
            this.destination = destination;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }



        public Node(int source,int destination, int weight) {
            this.source=source;
            this.destination = destination;
            this.weight = weight;
        }
        public Node(int source, int weight) {
            this.source=source;
//            this.destination = destination;
            this.weight = weight;
        }

        public int getDestination() {
            return destination;
        }

        public int getWeight() {
            return weight;
        }

        public int getSource() {
            return source;
        }
    }

    void createNode(int source){

        map.put(source, new LinkedList<Node>());
    }
    void createEdge(int source,int destination,int wieght,boolean bidirectional){
        if(!map.containsKey(source)){
            map.put(source, new LinkedList<Node>());
        }
        if(!map.containsKey((destination))){
            map.put(destination,new LinkedList<Node>());
        }
        map.get(source).add(new Node(source,destination,wieght));
        if(bidirectional){
            map.get(destination).add(new Node(destination,source,wieght));
        }
    }


    void makeSet(List<Integer> list,int size){
        for(int i=size-1;i>=0;i--){
            list.add(i,-1);
        }
    }


    void kruskals(){
        List<Node> list=new ArrayList<>();
        for(int s:map.keySet()){
             Collections.sort(map.get(s), new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.getWeight()-o2.getWeight();
                }
            });
            list.add(map.get(s).get(0));
        }
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.getWeight()-o2.getWeight();
            }
        });
        list.forEach(node->System.out.println(node.getSource()+"-->"+node.getDestination()+" : "+node.getWeight()));
    }

    void createAdjList(){
        for(int s:map.keySet()){
            adj_list.addAll(Collections.singleton(map.get(s)));
        }
    }

    void dijikstras(List<LinkedList<Node>> adj,int src){
      createAdjList();
      this.adj_list=adj;
      for(int i=0;i<map.size();i++){
          dist[i]=Integer.MAX_VALUE;
      }
      pq.add(new Node(src,0));
      dist[src]=0;
      while(settles.size()!=map.size()){
          Node u=pq.remove();
          settles.add(u);
          neighbhors(u);
      }

    }
    void neighbhors(Node u){
        int eDistance=-1;
        int nDistance=-1;
        for(int i=0;i<map.get(u.getSource()).size();i++) {
            Node v = adj_list.get(u.source).get(i);
            if (!settles.contains(v)) {
                eDistance = v.weight;
                nDistance = dist[u.source] + eDistance;

                // compare distances
                if (nDistance < dist[v.source])
                    dist[v.source] = nDistance;

                // Add the current vertex to the PriorityQueue
                pq.add(new Node(v.source,dist[v.source]));
            }
        }
    }



    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int key : map.keySet()) {
            builder.append(key).append(" : ");
            for (Node value : map.get(key)) {
                builder.append(value.getDestination() + " "+value.getWeight()+", ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
    public static  void main(String args[]){
        int V = 6;
        int source = 0;
        // adjacency list representation of graph
        List<List<dsa.graphs.Node> > adj_list = new ArrayList<List<dsa.graphs.Node> >();
        // Initialize adjacency list for every node in the graph
        for (int i = 0; i < V; i++) {
            List<dsa.graphs.Node> item = new ArrayList<dsa.graphs.Node>();
            adj_list.add(item);
        }


        // Input graph edges
        adj_list.get(0).add(new dsa.graphs.Node(1, 5));
        adj_list.get(0).add(new dsa.graphs.Node(2, 3));
        adj_list.get(0).add(new dsa.graphs.Node(3, 2));
        adj_list.get(0).add(new dsa.graphs.Node(4, 3));
        adj_list.get(0).add(new dsa.graphs.Node(5, 3));
        adj_list.get(2).add(new dsa.graphs.Node(1, 2));
        adj_list.get(2).add(new dsa.graphs.Node(3, 3));
        // call Dijkstra's algo method
        Graph_pq dpq = new Graph_pq(V);
        dpq.algo_dijkstra(adj_list, source);

        // Print the shortest path from source node to all the nodes
        System.out.println("The shorted path from source node to other nodes:");
        System.out.println("Source\t\t" + "Node#\t\t" + "Distance");
        for (int i = 0; i < dpq.dist.length; i++)
            System.out.println(source + " \t\t " + i + " \t\t "  + dpq.dist[i]);
    }
}


