package uva;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author shivendra
 * if nodes are not connected or there is any odd degree node euler circuit is not possible. 
 * id euler curcuit is possible then use remove visited node algo to print eular circuit.
 * rem: eular traversal algo is not same as DFS or BFS
 * and of course one bead is edge connecting two color nodes 
 *
 */
public class Graph_Necklace_10054 {
	
	static List<Integer>[] graph;
	static int[] degree;
	static boolean isEulerCircuit;
	static boolean[] isSeen;
	static Scanner scn;
	static PrintWriter pw;
	static List<Integer> eulerCircuit;
	public static void main(String[] args) {
		scn = new Scanner(System.in);
		pw = new PrintWriter(System.out);
		int cases = scn.nextInt();
		int size  = cases;
		while(cases-->0){
			init(scn.nextInt());
			pw.println(String.format("Case #%d", size-cases));
			if(isEulerCurcit()){
				eulerCircuit  = new ArrayList();
				eulerCurcit(1);
				for(int i=0; i<eulerCircuit.size()-1; i++){
					pw.println(eulerCircuit.get(i) + " "+ eulerCircuit.get(i+1) );
				}
			}
			else{
				pw.println("some beads may be lost");
			}
			pw.println();
		}
		pw.close();
	}
	
	static void eulerCurcit(int vtx){
		for(int v: graph[vtx]){
			if(graph[vtx].get(graph[vtx].indexOf(v))>0){
			graph[v].set(graph[v].indexOf(vtx),0);
			graph[vtx].set(graph[vtx].indexOf(v),0);
			eulerCurcit(v);
			}
		}
		eulerCircuit.add(vtx);
	}
	
	static boolean isEulerCurcit(){
		for(int i=1; i<degree.length && graph[i].size() > 0;i++){
			if((degree[i]&1) ==1) return false;
		}
		int connectedComp = 0;
		for(int i=1; i<graph.length && graph[i].size() >0; i++){
			if(!isSeen[i]){
				DFS(i);
				connectedComp++;
			}
		}
		if(connectedComp > 1) return false;
		else return true;
	}
	//DFS traversal to know no of connected comonenets
	static void DFS(int vtx){
		isSeen[vtx] = true;
		for(int v: graph[vtx]){
			if(!isSeen[v]){
				DFS(v);
			}
		}
	}
	
	static void init(int edges){
		graph = new List[51];
		isSeen = new boolean[51];
		degree = new int[51];
		for(int i=0; i<graph.length; i++){
			graph[i] = new ArrayList();
		}
		for(int i=0; i<edges; i++){
			int x = scn.nextInt();
			int y = scn.nextInt();
			graph[x].add(y);
			graph[y].add(x);
			degree[x]++;
			degree[y]++;
		}
	}

}
