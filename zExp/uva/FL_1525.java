package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;


public class FL_1525 {
	
    Node root;
	
	class Node{
		Node left;
		Node right;
		char ch;
		Node(char cha){
			ch = cha;
		}
	}
	
	void insert(Node node, char entry){
		Node newNode = new Node(entry);
		if(node ==null){
			if(root ==null){
			root = newNode;
			return;
			}else{
				node = root;
			}
		}
		
		if(entry < node.ch){
			if(node.left == null) node.left = new Node(entry);
			else insert(node.left, entry);
		}else{
			if(node.right == null) node.right = new Node(entry);
			else insert(node.right, entry);
		}
	}
	
	void preorder(Node n){
		if(n==null)return;
		pw.print(n.ch);
		preorder(n.left);
		preorder(n.right);
	}
	
	static PrintWriter pw = new PrintWriter(System.out);
	public static void main(String[] args) {
		InputReader scn = new InputReader(System.in);
		
		while(true){
		Stack st = new Stack();
		FL_1525 soln = new FL_1525();
		String stloc = scn.nextLine();
		
		while(!(stloc.equals("*") || stloc.equals("$"))){
			String str = stloc;
			st.add(str.trim());
			stloc = scn.nextLine().trim();
			
		}
		while(!st.isEmpty()){
		    String str = (String)st.pop();
		    for(int i=0; i<str.length(); i++){
			   soln.insert(null,str.charAt(i));
		    }
		}
		soln.preorder(soln.root);
		pw.println();
		if(stloc.equals("$"))break;
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
