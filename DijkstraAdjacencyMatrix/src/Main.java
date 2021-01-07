
public class Main {
	public static void main(String[] args) {
		int vertices = 10;
        DijkstraAdjacencyMatrix graph = new DijkstraAdjacencyMatrix(vertices);
        int sourceVertex = 0;
        //For every vertex
    	for (int i = 0; i < vertices; i++) {
        //Create a edge with random weight
    		for (int j = 0; j < vertices; j++) {
                //Skip same verticies
    			if (i == j) {
    				graph.addEdge(i, j, 0);
    			}
    			else {
    				graph.addEdge(i, j, (int) (Math.random() * 1000));  //add edge
    			}
    		}
    	}
    	graph.dijkstra_GetMinDistances(sourceVertex);		
        System.out.println("There are "+graph.count+ " comparisons");
    }
}
