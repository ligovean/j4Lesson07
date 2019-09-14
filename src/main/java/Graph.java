import java.util.*;

public class Graph {
    private final List<Vertex> vertexList;
    private final boolean[][] adjMat;

    private int size;

    public Graph (int maxVertexCount){
        this.vertexList = new ArrayList<>();
        this.adjMat = new boolean[maxVertexCount][maxVertexCount];
        this.size = 0;
    }

    public void addVertex(String label){
        vertexList.add(new Vertex((label)));
        size++;
    }

    public int getSize() {
        return size;
    }

    public void addEdges(String startLabel, String finishLabel, String...others){
        addEdge(startLabel, finishLabel);
        for (String anotherLabel: others) {
            addEdge(startLabel,anotherLabel);
        }
    }

    public void addEdge(String startLabel, String finishLabel){
        int startIndex = indexOf(startLabel);
        int finishIndex = indexOf(finishLabel);

        if (startIndex == -1 || finishIndex == -1){
            throw new IllegalArgumentException("Invalid vertex labels");
        }

        adjMat[startIndex][finishIndex] = true;
        adjMat[finishIndex][startIndex] = true;
    }

    private int indexOf(String startLabel) {
        for (int i = 0; i < size; i++) {
            if (vertexList.get(i).getLabel().equals(startLabel)){
                return i;
            }
        }
        return -1;
    }

    public void display() {
        System.out.println("-------");
        System.out.println("Graph size is " + getSize());
        for (int i = 0; i < size; i++) {
            System.out.print(vertexList.get(i));
            for (int j = 0; j < size; j++) {
                if (adjMat[i][j]) {
                    System.out.print(" -> " + vertexList.get(j));
                }
            }
            System.out.println();
        }
        System.out.println("-------");
    }

    public void dfs(String startLabel){
        int startIndex = indexOf(startLabel);
        if (startIndex == -1){
            throw new IllegalArgumentException("Invalid startLabel: " + startLabel);
        }
        Stack<Vertex> stack = new Stack<>();

        Vertex vertex = vertexList.get(startIndex);
        System.out.println(vertex.getLabel());
        visitVertex(stack, vertex);

        while (!stack.isEmpty()){
            vertex = getNearUnvisitedVedrtex(stack.peek());
            if (vertex != null){
                visitVertex(stack, vertex);
                System.out.println(vertex.getLabel());
            }
            else stack.pop();
        }
        resetVertexState();
    }

    public void bfs(String startLabel){
        int startIndex = indexOf(startLabel);
        if (startIndex == -1){
            throw new IllegalArgumentException("Invalid startLabel: " + startLabel);
        }
        Queue<Vertex> queue = new ArrayDeque<>();
        Vertex vertex = vertexList.get(startIndex);
        System.out.println(vertex.getLabel());
        visitVertex(queue, vertex);

        while (!queue.isEmpty()){
            vertex = getNearUnvisitedVedrtex(queue.peek());
            if (vertex != null){
                visitVertex(queue, vertex);
                System.out.println(vertex.getLabel());
            }
            else queue.remove();
        }

        resetVertexState();

    }

//==========================ДЗ==============================
    public Stack<String> bfsFind(String startLabel, String finishLabel){

        Stack<String> res = new Stack<>();

        int startIndex = indexOf(startLabel);
        int finishIndex = indexOf(finishLabel);

        if (startIndex == -1)throw new IllegalArgumentException("Invalid startLabel: " + startLabel);
        if (finishIndex == -1)throw new IllegalArgumentException("Invalid finishLabel: " + finishLabel);

        Queue<Vertex> queue = new ArrayDeque<>();
        Vertex vertex = vertexList.get(startIndex);
        Vertex finishVertex = vertexList.get(finishIndex);

        visitVertex(queue, vertex);
        while (!queue.isEmpty()){


            vertex = getNearUnvisitedVedrtex(queue.peek());
            if (vertex != null){
                vertex.setPrevVert(queue.peek());
                if (vertex.getLabel().equals(finishVertex.getLabel())){
                    Vertex vertexRev = finishVertex;

                    res.add(vertexRev.getLabel());

                    while (vertexRev.getPrevVert() != null){
                        vertexRev = vertexRev.getPrevVert();
                        res.add(vertexRev.getLabel());
                    }

                    break;
                }

                visitVertex(queue, vertex);
            }
            else queue.remove();
        }

        resetVertexState();

    return res;
    }

//==================================================================
    private void visitVertex(Queue<Vertex> queue, Vertex vertex) {
        //System.out.println(vertex.getLabel() + " prev " + vertex.getPrevVert());
        //System.out.print(" prev " + vertex.getPrevVert());
        queue.add(vertex);
        vertex.setVisited(true);
    }

    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        //System.out.println(vertex.getLabel());
        stack.push(vertex);
        vertex.setVisited(true);
    }

    private Vertex getNearUnvisitedVedrtex(Vertex currentVertex) {
        int currentIndex = vertexList.indexOf(currentVertex);
        for (int i = 0; i< size; i++){
            if (adjMat[currentIndex][i] && !vertexList.get(i).getVisited()) return vertexList.get(i);
        }
        return null;
    }

    private void resetVertexState() {
        for (Vertex vertex: vertexList) {
            vertex.setVisited(false);
            vertex.setPrevVert(null);
        }
    }
}
