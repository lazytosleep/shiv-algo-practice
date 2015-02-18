package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeProb {
	
	Node root;
	
	static class Node{
		Node left, right;
		int val;
		Node(int v){
			val = v;
		}
	}
	
	//Q: convert tree to DLL, DLL should be as in-order traversal of tree
	void treeToLL(Node node, Node tail){
		if(node==null)return;
		treeToLL(node.left, tail);
		if(tail==null) tail=node;
		else{
			tail.right = node;
			node.left = tail;
			tail = node;
		}
		treeToLL(node.right, tail);
	}
	
	//Q: Sorted linked list to balanced BST
	static void convertBST(LinkedList<Node> li, Node par, int start, int end ){
		int mid = (start+end)/2;
		
		Node curr = new Node(li.get(mid).val);
		if(par!=null){
			if(curr.val<=par.val) par.left = curr;
			else par.right = curr;
		}
		convertBST(li, curr, start, mid);
		convertBST(li, curr, mid, end);
		
	}
	
	//Q: find height of tree given all child parent pairs
	static int[] parent;
	static void getDepth(int[] parent, int[] depth, int nodeIdx){
		if(parent[nodeIdx] == -1){
			depth[nodeIdx] = 1;
			return;
		}
		if(depth[parent[nodeIdx]] ==0){
			getDepth(parent, depth, parent[nodeIdx]);
		}
		depth[nodeIdx] = depth[parent[nodeIdx]] +1;
	}
	
	
	//Q: test given tree is fulltree
	
	static boolean isFullTree(Node n){
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(n);
		//idea is if we get any full or partially full node post childless or partially full node during left to right leval order traversal
		//level order traversal is not only way, any depth first traversal(pre, post , int order) could be used but tin that case you need 
		//to maintain level info as well
		boolean isNotFullFound = false;
		while(!queue.isEmpty()){
			Node n1= queue.poll();
			if((n1.left!=null || n1.right !=null) && isNotFullFound) return false;
			if(n1.left ==null && n1.right !=null)return false;
			if(n1.left ==null || n1.right ==null) isNotFullFound = true;
			queue.add(n1.left);
			queue.add(n1.right);
		}
		return true;
	}
	 
	//q: test if tree is BST
	//do inorder traversal, node encountered should be in ascending order
	
	//Q: one binary tree is subtree of other
	
	//spiral order traversal
	
	//Q: two elements of BST are swapped, fix the BST
	//idea is to maintain two pointers and keep them updated if you meet unsorted elements during inorder traversal, if swapped elements are adjacent
	//then only one unsorted point would be seen
	//below routine sets the node pointer to be swapped
	static Node n1;static Node n2;
	static void fixBST(Node n){
		if(n==null)return;
		fixBST(n.left);
		if(n.left!=null && n.left.val > n.val && n1==null) {
			n1=n.left;
			n2= n;
		}else n2 = n;
		fixBST(n.right);
	}
	
	//Q: non recursive in order traversal
	//Need to solve????????????????????????????
	static void inOrderNonRec(Node n){
		Stack<Node> st = new Stack<Node>();
		st.add(n);
		while(!st.empty()){
			Node node = st.peek();
			if(node.left!=null) st.add(node.left);
			else if(node.right !=null){
				System.out.println(node.val);
				st.add(node.right);
				st.pop();
			}
			else{
				System.out.println(st.pop().val);
			}
			
			
		}
	}
	
	//find max distance(no of nodes) between any to nodes in tree/ find tree diameter//longest possible path in tree
	static int  findDiameter(Node n){
		int leftDia = findDiameter(n.left);
		int rightDia = findDiameter(n.right);
		//either max path would go via root, or in left tree itself or in right tree. If its in left on right subtree we need to recurse the same logic
		return Math.max(1+height(n.left)+height(n.right), Math.max(leftDia, rightDia));
	}
	
	static int height(Node n){
		if(n==null)return 0;
		else return 1+ Math.max(height(n.left),height(n.right)); 
	}

}







//Given tree is full binary tree
//left most node is filled

//create a mirror tree of BST

//given binary is subtree of another tree






//given a binary tree print its parimeter> all outer nodes
//do any DFS traversal (pre/post/in order) and print leaf nodes

