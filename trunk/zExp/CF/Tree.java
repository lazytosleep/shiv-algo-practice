package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Tree {

	Node root;
	List<Node> nodeList;
	 static StringTokenizer st;
	    static BufferedReader br;
	    static PrintWriter pw;
	void addData(Node vertex, int val){
          int localVal = val;
          vertex.val +=val;
          if(vertex.children !=null){
             for(Node node : vertex.children){
            	 addData(node, -val);
             }
          }
	}
	
	void ansQuery(List queryList){
		for(Object query: queryList){
			int[] query1 = (int[])query;
			int queryType = (query1[0]);
			int vtx = (query1[1]);
			//Node node = getVertex(vtx);
			//Node node = bsToFindNode(nodeList, vtx);
			Node node = nodeList.get(vtx-1);
			if(queryType == 1){
				int val = (query1[2]);
				addData(node,val );
			}else{
				System.out.println(node.val);
			}
		}
	}
	
	
	public Node getVertex(int ver){
		Stack<Node> stack = new Stack();
		stack.push(root);
		while(stack.size()>0){
			Node currNode = stack.pop();
			if(currNode.idx == ver){
				return currNode;
			}
			List nodeList = currNode.children;
			if(nodeList!=null){
				stack.addAll(nodeList);
			}
		}
		return null;
	}
	
	static Node bsToFindNode(List<Node> list, int vtx){
		int start = list.get(0).idx;
		int end = list.get(list.size()-1).idx;
		while(start <=end){
			int mid = (start+end)/2;
			//int curIdx= list.get(mid).idx; 
			if(mid == vtx)return list.get(vtx);
			if(mid > vtx) end = mid-1;
			else start = mid+1;
		}
		return null;
	}
	
	public static void main(String[] args) throws IOException {
       //Scanner scn = new Scanner(System.in);
       br = new BufferedReader(new InputStreamReader(System.in));
       int nodes = nextInt();
       int queries= nextInt();
       //scn.nextLine();
       int[] nodeVal = new int[nodes];
       for(int i=0; i<nodes; i++){
    	   nodeVal[i] = nextInt();
       }
       //Node[] nodeList = new Node[nodeVal.length];
       List<Node> nList = new ArrayList<Node>(nodeVal.length);
       //Init
       for(int i=0; i<nodeVal.length; i++){
    	   Node node = new Node();
    	   node.idx = -1;
    	   nList.add(node);
       }
       Tree tr = new Tree();
       for(int i=1; i<nodeVal.length; i++){
    	   int par = nextInt();
    	   int chi = nextInt();
    	   Node parNode = nList.get(par-1);
    	   if(parNode.idx == -1){
    		   //parNode = new Node();
    		   parNode.idx = par;
    		   parNode.children = new ArrayList<Node>();
    		   parNode.val = nodeVal[par-1];
    		   //nList.add(par-1, parNode);
    		   if(par ==1){
    			   tr.root = parNode;
    		   }
    	   }
    	   Node chNode = nList.get(chi-1);
    	   if(chNode.idx == -1){
    		   //chNode = new Node();
    		   chNode.idx = chi;
    		   chNode.children = new ArrayList<Node>();
    		   chNode.val = nodeVal[chi-1];
    		   //nList.add(chi-1 , chNode);
    	   }
    	   parNode.children.add(chNode);
       }
       tr.nodeList = nList;
       Collections.sort(tr.nodeList);
       List queryList = new ArrayList();
       for(int i=0; i<queries; i++ ){
    	   int[] quer = new int[3];
    	   int type = nextInt();
    	   quer[0] = type;
    	   if(type ==1){
    		   quer[1] = nextInt();
    		   quer[2] = nextInt();
    	   }else{
    		   quer[1] = nextInt();
    	   }
    		   
    	   queryList.add(quer);
       }
       tr.ansQuery(queryList);
	}
	
	private static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
    private static long nextLong() throws IOException {
        return Long.parseLong(next());
    }
    private static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
    private static String next() throws IOException {
        while (st==null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }

}

class Node implements Comparable<Node>{
	List<Node> children;
	int val;
	int idx;
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return (idx - o.idx);
	}
	
}
