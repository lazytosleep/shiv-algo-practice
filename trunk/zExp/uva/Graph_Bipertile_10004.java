package uva;

/**
 * For each connected component, color nodes with true and false(use DFS or BFS), pick the min true or false 
 */

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Graph_Bipertile_10004 {
	
	static List<Integer>[]graph;
	static boolean [] isSeen;
	static boolean[] color;
	static boolean isBipertile;
    static int trueCol ;	
    static int gaurds;
    static int localNodes = 0;
    public static void main(String[] args) {
    	PrintWriter pw = new PrintWriter(System.out);
    	Scanner scn = new Scanner(System.in);
    	int cases = scn.nextInt();
    	while(cases-->0){
    		int nodes = scn.nextInt();
    		int edge = scn.nextInt();
    		graph = new List[nodes];
    		isSeen = new boolean[nodes];
    		color = new boolean[nodes];
    		isBipertile = true;
    		gaurds = 0;
    		for(int i=0; i< nodes; i++){
    			graph[i] = new ArrayList();
    		}
    		for(int i=0; i<edge; i++){
    			int x = scn.nextInt();
    			int y = scn.nextInt();
    			graph[x].add(y);
    			graph[y].add(x);
    		}
    		for(int i=0; i<graph.length; i++){
    			if(!isSeen[i]){
    				trueCol = 0;
    				localNodes = 0;
    				DFS(i);
    				int locgaurds = trueCol< Math.abs(trueCol - localNodes)? trueCol : Math.abs(trueCol - localNodes);
    				gaurds = (locgaurds ==0)? ++gaurds:(gaurds+locgaurds);
    			}
    		}
    		if(isBipertile){
    			pw.println(gaurds);
    		}else pw.println(-1);
    	}
    	pw.close();
    }
	
	static void DFS(int vtx){
		isSeen[vtx] = true;
		localNodes++;
		for(int v : graph[vtx]){
			if(isSeen[v] && color[v] == color[vtx]){
				isBipertile = false;
				break;
			}else if(!isSeen[v]){
				color[v]= !color[vtx];
				if(color[v])trueCol++;
				DFS(v);
			}
		}
	}
	
}
