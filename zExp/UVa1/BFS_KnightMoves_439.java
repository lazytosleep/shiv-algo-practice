package uva;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_KnightMoves_439 {
	
	//As no weighted edges, we could use BFS
	
	static boolean[][] graph;
	static Queue<Node> queue;
	static int disX, disY;
	static int moves;
	static class Node{
		int i, j;
		int depth;
		Node(int x, int y){
			i = x;
			j = y;
		}
	}
	
	public static void main(String[] args) {
		 PrintWriter pw = new PrintWriter(System.out);
		 InputReader scn = new InputReader(System.in);
	     String str = null;
	     while((str = scn.nextLine())!=null && str.length() >0) {
	     String[] strArr = str.split("\\s");
	     Node source = new Node((int)strArr[0].charAt(0)-97, (int)strArr[0].charAt(1)-49);
	     disX = strArr[1].charAt(0)-97;
	     disY = strArr[1].charAt(1)-49;
	     queue = new LinkedList<Node>();
	     moves = 0;
	     graph = new boolean[8][8];
	     queue.add(source);
	     dfs(queue);
	     pw.println("To get from "+strArr[0]+" to "+strArr[1]+" takes "+ moves+" knight moves.");
	     }
	     pw.close();
		
	}

	static void dfs(Queue<Node> q){
		while(!q.isEmpty()){
		    Node n = q.poll();
			int x = n.i;
			int y = n.j;
			if(x == disX && y ==disY){
				moves = n.depth;
				break;
			}
			graph[x][y] = true;
			addNodeReturnIfFind(x+2,y+1,n.depth);
			addNodeReturnIfFind(x+2,y-1,n.depth);
			addNodeReturnIfFind(x-2,y+1,n.depth);
			addNodeReturnIfFind(x-2,y-1,n.depth);
			addNodeReturnIfFind(x+1,y+2,n.depth);
			addNodeReturnIfFind(x-1,y+2,n.depth);
			addNodeReturnIfFind(x+1,y-2,n.depth);
			addNodeReturnIfFind(x-1,y-2,n.depth);
		}
	}
	
	static void addNodeReturnIfFind(int i, int j, int dep){
		if(inRange(i, j) && !graph[i][j]){
			Node n1 = new Node(i,j);
			n1.depth = dep +1;
			queue.add(n1);
		}
	}
	
	static boolean inRange(int i, int j){
		return (0<=i && i <8 && 0<= j && j <8);
	}
	
	static class InputReader {
	    private BufferedReader reader;
	    private StringTokenizer stt;
	 
	    public InputReader(InputStream stream) {
	        reader = new BufferedReader(new InputStreamReader(stream));
	    }
	 
	    public String nextLine() {
	        try {
	            return reader.readLine().trim();
	        } catch (Exception e) {
	            return null;
	        }
	    }
	 
	    public String nextString(String str) {
	    	if(stt ==null){
	            stt = new StringTokenizer(str);
	    	}
	    	if(stt.hasMoreTokens()){
	        return stt.nextToken();
	    	}else return "-1";
	    }
	 
	    public int nextInt(String str) {
	        return Integer.parseInt(nextString(str));
	    }
	 
	}
	
}
