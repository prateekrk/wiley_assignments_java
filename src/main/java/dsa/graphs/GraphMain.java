package dsa.graphs;

import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.util.Scanner;

public class GraphMain {
    public static void main(String args[]) {
        GraphsClass graph=new GraphsClass();

        graph.insertEdge("Delhi", "Ahmedabad", true);
        graph.insertEdge("Delhi", "Patna", true);
        graph.insertEdge("Ahmedabad", "Indore", true);
        graph.insertEdge("Indore", "Patna", true);
        graph.insertEdge("Chennai", "Ahmedabad", true);

        System.out.println(graph);
        System.out.println(graph.countVertices());
        System.out.println(graph.countEdges());
        }
    }

