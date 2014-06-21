package ds;

public class GraphUnDirected {
	
	int[][] graph = null;
	boolean [] isSeen = null;
	int connectedCount = 0;
	boolean hasCycle = false;
	void processGraph(){
		
		for(int v=0;v<graph.length;v++){
			if(!isSeen[v]){
				connectedCount++;
				DFS(v, -1);
			}
		}
			
	}
	
	void DFS(int v, int w){
		isSeen[v] = true;
		for(int u : graph[v]){
			if(!isSeen[u]){
			DFS(u, v);
			}else if(u !=w ){
				hasCycle = true;
			}
		}
	}

}
