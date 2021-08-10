package dsa.graphs;

import java.util.*;

public class GraphsClass {
    Map<String, List<String>> map = new HashMap<>();

    class GraphWeight{
        int weight;
        String destination;

        public GraphWeight(int weight, String destination) {
            this.weight = weight;
            this.destination = destination;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }
    }

    void addNode(String s) {
        map.put(s, new LinkedList<String>());
    }

    void insertEdge(String source, String destination, boolean biDirectional) {
        if (!map.containsKey(source)) {
            map.put(source, new LinkedList<>());
        }
        if (!map.containsKey(destination)) {
            map.put(destination, new LinkedList<>());
        }
        map.get(source).add(destination);
        if (biDirectional) {
            map.get(destination).add(source);
        }
    }

    int countVertices(){
        int count=0;
        Set verticeSet=new HashSet();
        for(String s:map.keySet()){
            verticeSet.addAll(map.get(s));
        }
        return verticeSet.size();
    }
    int countEdges(){
        int count=0;
        List<String> visited=new ArrayList<>();
        for(String s:map.keySet()){
            count=map.get(s).size();
        }
       return count/2;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (String key : map.keySet()) {
            builder.append(key).append(" : ");
            for (String value : map.get(key)) {
                builder.append(value + " ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
