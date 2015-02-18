package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BT_TreeRec_536 {
	
	class Node{
		char val;
		Node left, rt;
		public Node(char ch) {
			val = ch;
		}
	}
	
	Node root;
	int offset;
	static PrintWriter pw;
	void buildTree(List<Character> io, List<Character> preo, int start, int end, Node parent, boolean isLeft){
		if(start > end) return;
		char rootVal = preo.get(offset++);
		int rootIdx = start -1;
		while(rootVal != io.get(++rootIdx)){
			
		}
		Node node = new Node(rootVal);
		if(root ==null){
			root =node;
		}else{
			if(isLeft) parent.left = node;
			else parent.rt = node;
		}
		
		buildTree(io, preo, start, rootIdx-1, node, true);
		buildTree(io, preo,rootIdx+1,end, node, false);
	}
	
	void postOrderTr(Node node){
		if(node!=null){
			postOrderTr(node.left);
			postOrderTr(node.rt);
			pw.print(node.val);
		}
	}
	
	public static void main(String[] args) {
		InputReader scn =new InputReader(System.in);
		pw = new PrintWriter(System.out);
		String str = null;
		while((str = scn.nextLine())!=null && str.length() > 0){
			String[] trv = str.split("\\s");
			List<Character> preo = new ArrayList<Character>();
			List<Character> io = new ArrayList<Character>();
				for(int i=0; i<trv[0].length(); i++){
					preo.add(trv[0].charAt(i));
				}
				for(int i=0; i<trv[1].length(); i++){
					io.add(trv[1].charAt(i));
				}
				BT_TreeRec_536 solver = new BT_TreeRec_536();
				solver.buildTree(io, preo, 0, io.size()-1, null, false);
				solver.postOrderTr(solver.root);
				pw.println();
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
	        } catch (Exception e) {
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
