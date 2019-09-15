import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        testFind();
        //testGraph();
        //testDfs();
        //testBfs();
    }

    private static void testFind() {
        Graph graph = new Graph(10);
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Рязань");
        graph.addVertex("Калуга");
        graph.addVertex("Липецк");
        graph.addVertex("Тамбов");
        graph.addVertex("Орел");
        graph.addVertex("Саратов");
        graph.addVertex("Курск");
        graph.addVertex("Воронеж");

        graph.addEdge("Москва","Тула");
        graph.addEdge("Тула","Липецк");
        graph.addEdge("Липецк","Воронеж");

        graph.addEdge("Москва","Рязань");
        graph.addEdge("Рязань","Тамбов");
        graph.addEdge("Тамбов","Саратов");
        graph.addEdge("Саратов","Воронеж");

        graph.addEdge("Москва","Калуга");
        graph.addEdge("Калуга","Орел");
        graph.addEdge("Орел","Курск");
        graph.addEdge("Курск","Воронеж");


        //graph.display();
        //System.out.println("Обход Графа в ширину: ");
       // graph.bfs("Москва");

        Stack<String> resRout = graph.bfsFind("Москва","Воронеж");
        System.out.println();
        System.out.print ("Кратчайший маршрут: ");
        while (!resRout.isEmpty()){
            System.out.print(resRout.pop()+ " ");
        }
    }

    private static void testGraph() {
        Graph graph = new Graph(10);
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Рязань");
        graph.addVertex("Калуга");
        graph.addVertex("Липецк");
        graph.addVertex("Тамбов");
        graph.addVertex("Орел");
        graph.addVertex("Саратов");
        graph.addVertex("Курск");
        graph.addVertex("Воронеж");

        graph.addEdge("Москва","Тула");
        graph.addEdge("Тула","Липецк");
        graph.addEdge("Липецк","Воронеж");

        graph.addEdge("Москва","Рязань");
        graph.addEdge("Рязань","Тамбов");
        graph.addEdge("Тамбов","Саратов");
        graph.addEdge("Саратов","Воронеж");

        graph.addEdge("Москва","Калуга");
        graph.addEdge("Калуга","Орел");
        graph.addEdge("Орел","Курск");
        graph.addEdge("Курск","Воронеж");


        //graph.display();
        graph.bfs("Москва");
    }


    private static void testDfs() {
        Graph graph = new Graph(7);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");

        graph.addEdges("A", "B", "C", "D");
        graph.addEdge("B", "E");
        graph.addEdge("E", "C");
        graph.addEdge("D", "F");
        graph.addEdge("F", "G");

        graph.dfs("A");
        //A B E C D F G
    }

    private static void testBfs() {
        Graph graph = new Graph(8);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");

        graph.addEdges("A", "B", "C", "D");
        graph.addEdge("B", "E");
        graph.addEdge("E", "H");
        graph.addEdge("C", "F");
        graph.addEdge("D", "G");

        graph.bfs("A");

    }

}