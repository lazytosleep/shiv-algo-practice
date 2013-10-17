import java.util.ArrayList;
import java.util.List;


public class Graph {
	//no of vertex
	int V;
	//no of edges
	int E;
	List<List<Integer>> adjList;
	boolean [] isSeen ;
    public Graph(int v){
    	this.V= v;
    	isSeen = new boolean[v];
    	adjList = new ArrayList<List<Integer>>(v);
    	for(int i=0; i<v; i++){
    		List<Integer> li = new ArrayList<Integer>();
    		adjList.add(li);
    	}
    }
    
    public void addEdge(int v, int w){
        adjList.get(v).add(w);
        adjList.get(w).add(v);
    }
    
    public static void main(String[] args) {
		Graph gr = new Graph(5);
		gr.addEdge(0, 1);
		gr.addEdge(0, 2);
		gr.addEdge(1, 2);
		gr.addEdge(2, 3);
		gr.addEdge(0, 4);
		gr.addEdge(3, 1);
		gr.DFS(null, 3);
	}
    
    public void DFS(List<Integer> list, int x){
    	list= list == null ? adjList.get(0): list;
    	for(int i=0; i<list.size(); i++){
    		int node = list.get(i);
    		if(node == x){
    			System.out.println("Got it ");
    		}
    		if(isSeen[node]){
    			continue;
    		}else{
    			isSeen[node] = true;
    			DFS(adjList.get(node),x);
    		}
    	}
    }
    
    public void BFS(){
    	
    }

}
