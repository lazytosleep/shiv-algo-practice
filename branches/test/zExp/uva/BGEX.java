package uva;
//11080 - Place the Guards
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BGEX {
	
	List<Integer>[] gh;
	int count;
	boolean [] color;
	boolean [] isSeen;
	void processGraph(){
		for(int v=0; v<gh.length; v++){
			if(!isSeen[v]){
				color[v] = true;
				count++;
				DFS(v);
			}
		}
		
	}
	
	void DFS(int v){
		isSeen[v] = true;
		for(int u:gh[v]){
			if(!isSeen[u]){
				color[u] = !color[v];
				if(color[u])count++;
				DFS(u);
			}else if(color[u] == color[v]){
				count = -1;
				break;
			}
		}
		
	}
	
	int findAns(){
		processGraph();
        return count;		
	}
	
	void init(int vtx){
		gh = new ArrayList[vtx];
		for(int i=0; i<vtx; i++){
			gh[i] = new ArrayList<Integer>();
		}
		isSeen = new boolean[vtx];
		color = new boolean[vtx];
		
	}
	
	void addEdge(int i, int j){
		gh[i].add(j);
		gh[j].add(i);
	}
	
	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int noOfTest = reader.nextInt();
		for(int j=0; j<noOfTest; j++){
		int jn = reader.nextInt();
		int st = reader.nextInt();
		BGEX ex = new BGEX();
		ex.init(jn);
		for(int i=0; i<st; i++){
			int x = reader.nextInt();
			int y = reader.nextInt();
			ex.addEdge(x, y);
		}
		pw.println(ex.findAns());
		}
		pw.close();
		
		
		
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
	        } catch (IOException e) {
	            return null;
	        }
	    }
	 
	    public String nextString() {
	        while (stt == null || !stt.hasMoreTokens()) {
	            stt = new StringTokenizer(nextLine());
	        }
	        return stt.nextToken();
	    }
	 
	    public int nextInt() {
	        return Integer.parseInt(nextString());
	    }
	 
	}


}

