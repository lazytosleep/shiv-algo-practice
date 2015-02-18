package uva;
//prob 11686 pick up the stick
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class P11686 {
	
	List<Integer>[] gh;
	boolean [] isSeen;
	boolean [] onStack;
	Stack<Integer> reversePostOrder;
	boolean hasCycle;
	void processGraph(){
		for(int v=1; v<gh.length; v++){
			if(!isSeen[v])
			DFS(v);
		}
	}
	
	void DFS(int v){
		isSeen[v] = true;
		onStack[v] = true;
		for(int w: gh[v]){
		   if(!isSeen[w]){
			   DFS(w);
		   }else if(onStack[w]){
			   hasCycle = true;
			   break;
		   }
		}
		onStack[v] = false;
		reversePostOrder.add(v);
	}
	
	void init(int v){
		gh = new ArrayList[v+1];
		for(int i=1; i<=v; i++){
			gh[i] = new ArrayList<Integer>();
		}
		isSeen = new boolean[v+1];
		onStack = new boolean[v+1];
		reversePostOrder = new Stack<Integer>();
	}
	void addEdge(int x, int y){
		gh[x].add(y);
		//gh[y].add(x);
	}
	
	void solve(PrintWriter pw){
		processGraph();
		if(hasCycle)pw.print("IMPOSSIBLE");
		else{
			while(!reversePostOrder.isEmpty()){
				pw.println(reversePostOrder.pop());
			}
		}
	}
	
	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		boolean contn = true;
		while(contn){
			int v = reader.nextInt();
			int e = reader.nextInt();
			if(v ==0 && e==0){
				contn = false;
				break;
			}
			P11686 ex = new P11686();
			ex.init(v);
			for(int i=1; i<=e; i++){
				int x = reader.nextInt();
				int y = reader.nextInt();
				
				ex.addEdge(x, y);
			}
			ex.solve(pw);
			
			
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
