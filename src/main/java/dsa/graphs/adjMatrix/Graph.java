package dsa.graphs.adjMatrix;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Vertex{
    private String label;
    private  boolean wasVisited;

    public boolean isWasVisited() {
        return wasVisited;
    }

    public void setWasVisited(boolean wasVisited) {
        this.wasVisited = wasVisited;
    }

    public Vertex(String label) {
        this.label = label;
        this.wasVisited = false;
    }

    public String getLabel() {
        return label;
    }



}
public class Graph {
    final private Vertex[] vertices;
    final private int[][] adj;
    private int nVerts;
    final private Stack<Integer> s;
    final private Queue<Integer> q;
    public Graph() {
        vertices = new Vertex[20];
        adj = new int[20][20];
        nVerts = 0;
        s = new Stack<>();
        q=new LinkedList<Integer>();

    }
//    public Vertex[] getVertices() {
//        return vertices;
//    }
//
//    public void setVertices(Vertex[] vertices) {
//        this.vertices = vertices;
//    }
//
//    public int[][] getAdj() {
//        return adj;
//    }
//
//    public void setAdj(int[][] adj) {
//        this.adj = adj;
//    }
//
//    public int getnVerts() {
//        return nVerts;
//    }
//
//    public void setnVerts(int nVerts) {
//        this.nVerts = nVerts;
//    }
//
//    public Stack<Integer> getS() {
//        return s;
//    }


    public void addVertex(String label) {

        vertices[nVerts++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        adj[start][end] = 1;
        adj[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.print(vertices[v].getLabel() + " ");
    }

    public int getAdjUnvisitedVertices(int v) {
        for (int j = 0; j < nVerts; j++) {
            if (adj[v][j] == 1 && !vertices[j].isWasVisited()) {
                return j;
            }
        }
        return -1;

    }

    public void dfs() {
        vertices[0].setWasVisited(true);
        displayVertex(0);
        s.push(0);

        while (!s.isEmpty()) {
            int v = getAdjUnvisitedVertices(s.peek());

            if (v == -1) {
                s.pop();
            } else {
                vertices[v].setWasVisited(true);
                displayVertex(v);
                s.push(v);
            }

        }
    }
    public  void bfs(){
        for(int i=0;i<nVerts;i++)
        {
            vertices[i].setWasVisited(false);
        }
        vertices[0].setWasVisited(true);
        displayVertex(0);
        q.add(0);
        int v2;
        while(!q.isEmpty()) {
            int v1 = q.remove();
            while((v2=getAdjUnvisitedVertices(v1))!=-1) {
                vertices[v2].setWasVisited(true);
                displayVertex(v2);
                q.add(v2);
            }
        }
    }

    void refresh(){
        for(int i=0;i<nVerts;i++){
            vertices[0].setWasVisited(false);
        }
    }
    void minimumSpanningTree(){
//        vertices[start].setWasVisited(true);
//        displayVertex(start);
//        s.push(start);
//
//        while (!s.isEmpty()) {
//            int v = getAdjUnvisitedVertices(s.peek());
//
//            if (v == -1) {
//                s.pop();
//            } else {
//                vertices[v].setWasVisited(true);
//                displayVertex(v);
//                s.push(v);
//            }
//
//        }
        for(int i=0;i<nVerts;i++)
        {
            vertices[i].setWasVisited(false);
        }
        vertices[0].setWasVisited(true);
//        displayVertex(0);
        s.push(0);

        while(!s.isEmpty()){

            int v = getAdjUnvisitedVertices(s.peek());

            if (v == -1) {
                s.pop();
            } else {
                vertices[v].setWasVisited(true);
                System.out.print(vertices[s.peek()].getLabel()+vertices[v].getLabel()+" ");
                s.push(v);
            }

        }
    }
}

