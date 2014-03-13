import java.util.ArrayList;
import java.util.List;

import sun.misc.Queue;


public class Graph1 {
	//no of vertex
	int V;
	//no of edges
	int E;
	List<List<Integer>> adjList;
	boolean [] isSeen ;
    public Graph1(int v){
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
		Graph1 gr = new Graph1(5);
		gr.addEdge(0, 1);
		gr.addEdge(0, 2);
		gr.addEdge(1, 2);
		gr.addEdge(2, 3);
		gr.addEdge(0, 4);
		gr.addEdge(3, 1);
		gr.DFS(null, 3);
		gr.BFS();
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
    //BFS is base of minimum spanning tree, Dejishta algo
    public void BFS(){
    	for(int i=0; i<isSeen.length; i++){
    		isSeen[i] = false;
    	}
    	Queue q = new Queue();//Just changing this to stack would make it dfs
    	q.enqueue(0);
    	try {
			while(!q.isEmpty()){
				int vertex = (Integer)q.dequeue();
				for(int i=0; i<adjList.get(vertex).size(); i++){
					int currV = adjList.get(vertex).get(i);
					if(!isSeen[currV]){
						isSeen[currV] = true;
						q.enqueue(currV);	
					}
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Lets print all vertex to see if they are visited
		boolean allSeen = true;
    	for(int i=0; i<isSeen.length; i++){
    		if(!isSeen[i]){
    			allSeen = false;
    			break;
    		}
    	}
    	System.out.println("Is All vertex visited :: "+allSeen);
    }
    
   

}
