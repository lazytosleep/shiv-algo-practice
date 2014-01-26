import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


public class GraphAlgo {
	public static void main(String[] args) {
		EdgeWeightedGraph graph = new EdgeWeightedGraph(5);
		graph.addEdge(1,2,3);
		graph.addEdge(1,3,4);
		graph.addEdge(1,5,2);
		graph.addEdge(3,5,7);
		graph.addEdge(2,4,9);
		graph.addEdge(4,5,8);
		System.out.println(graph.markMST());
	}
	
}

class EdgeWeightedGraph{
	List<Edge>[] adjList;
	boolean[] isSeen;
	EdgeWeightedGraph(int size){
		isSeen = new boolean[size+1];
		adjList = new List[size+1];
		for(int i=0; i<=size; i++){
			adjList[i] = new ArrayList();
		}
	}
	public void addEdge(int u, int v, int wt){
		Edge edge = new Edge(u, v, wt);
		adjList[u].add(edge);
		adjList[v].add(edge);
	}
	
	public List markMST(){
		PriorityQueue<Edge> pq  = new PriorityQueue<Edge>();
		List<Edge> minSpnningTree = new ArrayList<Edge>() ; 
		List<Edge> adj0 = adjList[1];
		Edge min = null;
		for(int i=0; i<adj0.size(); i++){
			pq.add(adj0.get(i));
		}

		while(pq !=null && pq.size() >0){
			Edge currEdge = pq.remove();
			if(isSeen[currEdge.to] && isSeen[currEdge.from]){
				continue;
			}
			//check the cond
			//if(!doesFormLoop(minSpnningTree, currEdge))
				minSpnningTree.add(currEdge);
			//get all the edges from both sides
			int vtx = currEdge.from;
			if(!isSeen[vtx]){
				List<Edge> eList = adjList[vtx];
				pq.addAll(eList);
			}
			vtx = currEdge.to;
			if(!isSeen[vtx]){
				List<Edge> eList = adjList[vtx];
				pq.addAll(eList);
			}
			isSeen[currEdge.to] = true;
			isSeen[currEdge.from] = true;

		}
		return minSpnningTree;
	}

	boolean doesFormLoop(List<Edge> minSpanningTree, Edge edge){
		for(int i=0; i<minSpanningTree.size(); i++){
			Edge currEdge = minSpanningTree.get(i);
			//if(edge.to == currEdge.to)
				//return true;
		}
		return false;
	}
	
}
class Edge implements Comparable<Edge>{
	int from;
	int to;
	int wt;
	Edge(int from,int to, int wt){
		this.from = from;
		this.to = to;
		this.wt = wt;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		if(this.wt > o.wt)return +1;
		if(this.wt < o.wt)return -1;
		return 0;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return from+ " :: "+to;
	}
	
	
}
