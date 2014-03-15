package CF;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Tree {

	Node root;
	List<Node> nodeList;
	
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
			String[] query1 = (String[])query;
			int queryType = Integer.parseInt(query1[0]);
			int vtx = Integer.parseInt(query1[1]);
			//Node node = getVertex(vtx);
			//Node node = bsToFindNode(nodeList, vtx);
			Node node = nodeList.get(vtx-1);
			if(queryType == 1){
				int val = Integer.parseInt(query1[2]);
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
	
	public static void main(String[] args) {
       Scanner scn = new Scanner(System.in);
       int nodes = scn.nextInt();
       int queries= scn.nextInt();
       scn.nextLine();
       String[] nodeVal = scn.nextLine().split("\\s");
       Node[] nodeList = new Node[nodeVal.length];
       List<Node> nList = new ArrayList<Node>(nodeVal.length);
       //Init
       for(int i=0; i<nodeVal.length; i++){
    	   Node node = new Node();
    	   node.idx = -1;
    	   nList.add(node);
       }
       Tree tr = new Tree();
       for(int i=1; i<nodeVal.length; i++){
    	   String[] edge = scn.nextLine().split("\\s");
    	   int par = Integer.parseInt(edge[0]);
    	   int chi = Integer.parseInt(edge[1]);
    	   Node parNode = nList.get(par-1);
    	   if(parNode.idx == -1){
    		   //parNode = new Node();
    		   parNode.idx = par;
    		   parNode.children = new ArrayList<Node>();
    		   parNode.val = Integer.parseInt(nodeVal[par-1]);
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
    		   chNode.val = Integer.parseInt(nodeVal[chi-1]);
    		   //nList.add(chi-1 , chNode);
    	   }
    	   parNode.children.add(chNode);
       }
       tr.nodeList = nList;
       Collections.sort(tr.nodeList);
       List queryList = new ArrayList();
       for(int i=0; i<queries; i++ ){
    	   String[] quer = scn.nextLine().split("\\s");
    	   queryList.add(quer);
       }
       tr.ansQuery(queryList);
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
