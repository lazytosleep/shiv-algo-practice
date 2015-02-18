package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Stack_Rails_514 {
	
	static Stack inc, sta, out;
	
	public static void main(String[] args) {
		InputReader scn = new InputReader(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		
		int size =scn.nextInt();
		while(size >0){
		
		boolean count = true;
		while(count){
			inc = new Stack();
			 
			for(int i=size; i>0; i--){
				inc.add(i);
			}
		sta = new Stack();
		String ans = "Yes";
		for(int i=1; i<=size; i++){
			boolean  found = false;
			int curr = scn.nextInt();
			if(curr == 0){
				count = false;
				break;
			}
			if(!sta.isEmpty()&& (Integer)sta.peek() == curr){
				sta.pop();
				found = true;
			}else{
			while(!inc.isEmpty() && (Integer)inc.peek() !=curr){
				sta.push(inc.pop());
			}
			if(!inc.isEmpty() && (Integer)inc.pop() == curr){
				found = true;
			}
			}
			if(!found){
				ans = "No";
				
			}
		}
		if(count)
			pw.println(ans);
		}
		pw.println();
		size =scn.nextInt();
		}
		pw.flush();
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
