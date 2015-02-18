package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 * @author trips
 * First construct the tree using inoder and post order traversal, then do a preorder traversal (DFS) to find pathval of leaf nodes
 */
public class BTree_548_Tree {
	
	Node root;
	class Node{
		int val;
		int pathSum;
		Node left, right;
		public Node(int va) {
		 val =  va;
		}
	}
	int  minLeafPath = Integer.MAX_VALUE;
	int minNode = 0;
	
	int offset = 0;
	void addNode(List inorder, List postOrder, int start, int end,Node parent,  boolean isLeft){
        if(start >end)return;
        int val = (Integer)postOrder.get(offset--);
        int rootIdx = start-1;
        while(val!= (Integer)inorder.get(++rootIdx)){
        }
        Node node = new Node(val);
        if(root ==null){
        	root = node;
        	node.pathSum = val;
        }else{
        	node.pathSum = parent.pathSum + val;
        	if(isLeft)parent.left = node;
        	else parent.right = node;
        }
        addNode(inorder, postOrder,rootIdx+1, end,node,  false);
        addNode(inorder, postOrder,start,rootIdx -1, node, true);
		
	}
	
	void preOrderTraversal(Node node){
		 if(node.left !=null)
			 preOrderTraversal(node.left);
		 if(node.right!=null)
			 preOrderTraversal(node.right);
		 if(node.left == null && node.right == null && node.pathSum < minLeafPath){
			 minLeafPath = node.pathSum ;
			 minNode = node.val;
		 }
		
	}
	
	public static void main(String[] args) {
		InputReader scn = new InputReader(System.in); 
		PrintWriter pw = new PrintWriter(System.out);
		String line = scn.nextLine();
		while(line!=null && line.length() > 0){
			List inorder = new ArrayList();
			List postOrder = new ArrayList();
			String[] str = line.split("\\s");
			for(String st : str){
				inorder.add(Integer.parseInt(st));
			}
			str = scn.nextLine().split("\\s");
			for(String st : str){
				postOrder.add(Integer.parseInt(st));
			}

			BTree_548_Tree solver = new BTree_548_Tree();
			solver.offset = inorder.size() -1;
			solver.addNode(inorder, postOrder, 0, inorder.size()-1, null, false);
			solver.preOrderTraversal(solver.root);
			pw.println(solver.minNode);
			line = scn.nextLine();
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
