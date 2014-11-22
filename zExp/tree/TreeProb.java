package tree;

public class TreeProb {
	
	Node root;
	
	//convert tree to DLL, DLL should be as in-order traversal of tree
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
	
	class Node{
		Node left, right;
		int val;
	}

}

//test given tree is BST

//Given tree is full binary tree
//left most node is filled

//create a mirror tree of BST

//given binary is subtree of another tree

//find max distance between any to nodes in tree/ find tree diameter



