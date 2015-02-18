package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * 
 * @author shivendra 
 *
 */
public class UnionFind_793 {

	
	static int[] parent;
	
	static int findRep(int i){
		return parent[i] == i ? i : (parent[i] = findRep(parent[i]));
	}
	
	static void union(int i, int j){
		parent[findRep(i)] = findRep(j);
	}
	
	static boolean isSameSet(int i, int j){
		return findRep(i) == findRep(j);
	}
	
	public static void main(String[] args) throws IOException {
		PrintWriter pw = new PrintWriter(System.out);
		BufferedReader scn = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(scn.readLine().trim());
		scn.readLine();
		while(cases-- >0){
		int nos = Integer.parseInt(scn.readLine().trim());
		int successful = 0;
		int unsuccessful = 0;
		parent = new int[nos+1];
		for(int i=0; i<parent.length; i++){
			parent[i] = i;
		}
		String str = null;
		while((str= scn.readLine())!=null && str.length() >0 ){
			String[] arr = str.split("\\s");
			char ch = arr[0].toCharArray()[0];
			if(ch == 'c'){
				int x = Integer.parseInt(arr[1]);
				int y = Integer.parseInt(arr[2]);
				union(x,y );
			}else{
				if(isSameSet(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]))) successful++;
				else unsuccessful++;
			}
		}
		pw.print(successful +","+unsuccessful+"\n");
		if(cases != 0){
			pw.print("\n");
		}
		}
		
		pw.close();
		
	}
	
	static class InputReader {
	    private BufferedReader reader;
	    private StringTokenizer stt;
	 
	    public InputReader(InputStream stream) {
	        reader = new BufferedReader(new InputStreamReader(stream));
	    }
	 
	}

}
