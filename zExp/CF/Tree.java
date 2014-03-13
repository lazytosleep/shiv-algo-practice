package CF;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tree {

	public static void main(String[] args) {
       Scanner scn = new Scanner(System.in);
       int nodes = scn.nextInt();
       int queries= scn.nextInt();
       String[] nodeVal = scn.nextLine().split("\\s");
       Node[] nodeList = new Node[nodeVal.length -1];
       Tree tr = new Tree();
       for(int i=1; i<nodeVal.length; i++){
    	   String[] edge = scn.nextLine().split("\\s");
    	   int par = Integer.parseInt(edge[0]);
    	   int chi = Integer.parseInt(edge[1]);
    	   Node parNode = nodeList[par-1];
    	   if(parNode == null){
    		   parNode = new Node();
    		   parNode.children = new ArrayList<Node>();
    		   parNode.val = Integer.parseInt(nodeVal[par-1]);
    		   nodeList[par-1] = parNode;
    	   }
    	   Node chNode = nodeList[chi-1];
    	   if(chNode == null){
    		   chNode = new Node();
    		   chNode.children = new ArrayList<Node>();
    		   chNode.val = Integer.parseInt(nodeVal[chi-1]);
    		   nodeList[chi-1] = chNode;
    	   }
    	   parNode.children.add(chNode);
       }
       for(int i=1; i<=queries; i++ ){
    	   String[] quer = scn.nextLine().split("\\s");
    	   int queryType = Integer.parseInt(quer[0]);
    	   
       }
	}

}

class Node{
	List<Node> children;
	int val;
}
