package ds;

public class BiPertileGraph {
	
	int[][] graph;
	boolean isBipertile = true;
	boolean [] isSeen;
	boolean [] color;
	void processGraph(){
		
		for(int v=0; v<graph.length; v++){
			if(!isSeen[v]) DFS(v);
		}
	}
	
	void DFS(int v){
		isSeen[v] = true;
		for(int u : graph[v]){
			if(!isSeen[u]){
				color[u] = !color[v];
				DFS(u);
			}else if(color[u] == color[v]){
				isBipertile = false;
			}
		}
	}

}
