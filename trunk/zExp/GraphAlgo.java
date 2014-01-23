import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


public class GraphAlgo {
	
	
}

class Graph{
	List<Edge>[] adjList;
	boolean[] isSeen;
	Graph(int size){
		isSeen = new boolean[size];
		adjList = new List[size];
		for(int i=0; i<size; i++){
			adjList[i] = new ArrayList();
		}
	}
	void addEdge(int u, int v, int wt){
		Edge edge = new Edge(u, v, wt);
		adjList[u].add(edge);
		adjList[v].add(edge);
	}
	
	List markMST(){
		PriorityQueue<Edge> pq  = new PriorityQueue<Edge>();
		List<Edge> minSpnningTree = new ArrayList<Edge>() ; 
		List<Edge> adj0 = adjList[0];
		Edge min = null;
		for(int i=0; i<adj0.size(); i++){
			pq.add(adj0.get(i));
		}
		
		
		while(pq !=null && pq.size() >0){
			Edge currEdge = pq.remove();
			if(isSeen[currEdge.to] && isSeen[currEdge.from]){
				continue;
			}
			
			isSeen[currEdge.to] = true;
			isSeen[currEdge.from] = true;
			//check the cond
			if(!doesFormLoop(minSpnningTree, currEdge))
			minSpnningTree.add(currEdge);
			//get all the edges from both sides
			int vtx = currEdge.from;
			List<Edge> eList = adjList[vtx];
			pq.addAll(eList);
			vtx = currEdge.to;
			eList = adjList[vtx];
			pq.addAll(eList);
			
		}
		return minSpnningTree;
	}
	
	boolean doesFormLoop(List<Edge> minSpanningTree, Edge edge){
		for(int i=0; i<minSpanningTree.size(); i++){
			Edge currEdge = minSpanningTree.get(i);
			if(edge.to == currEdge.to)
				return true;
		}
		return false;
	}
	void traverseMST(PriorityQueue<Edge> pq, int nodeKey){
		List list = adjList[nodeKey];
		Edge lowsetWtEdge = null;
		for(int i=0; i<list.size(); i++){
			Edge curredge = (Edge)list.get(i);
		    
		}
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
	
	
}
