package ds;

import java.util.Stack;
//TODO check for cycle, if cycle exist topoligical sort is not possible
public class TopologicalSort {
	
	int[][] graph;
	boolean[] isSeen;
	Stack reversePostOrder = new Stack();
	void processGraph(){
		
		for(int v=0; v<graph.length; v++){
			if(!isSeen[v])DFS(v);
		}
	}
	
	void DFS(int v){
		isSeen[v] = true;
		 for(int u: graph[v]){
			 if(!isSeen[u]){
				 DFS(u);
			 }
		 }
		 reversePostOrder.add(v);
	}

}
