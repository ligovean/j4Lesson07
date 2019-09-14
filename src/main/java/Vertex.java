public class Vertex {
    private final String label;
    private boolean visited;
    private Vertex prevVert;

    public Vertex(String label) {
        this.label = label;
        this.prevVert = null;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return label;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean getVisited() {
        return visited;
    }

    public void setPrevVert(Vertex prevVert) {
        this.prevVert = prevVert;
    }

    public Vertex getPrevVert() {
        return prevVert;
    }
}
