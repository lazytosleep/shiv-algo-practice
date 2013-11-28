import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Tree {
	
	Node root;
	class Node{
		Node left, right;
		int key;
		boolean isVisited;
		Node(int k){
			this.key = k;
		}
	}
	
	void add(int key){
		Node n = new Node(key);
		if(root == null) root = n;
		else{
			Node curr =root,prev = root;
			while(curr !=null){
				prev = curr;
				if(key > curr.key) curr = curr.right;
				else curr = curr.left;
			}
			if(key>prev.key) prev.right = n;
			else prev.left = n;
		}
	}
	
	int floor(int searchKey){
		Node curr = root;
		while(curr !=null){
			if((curr.key < searchKey && (curr.right ==null || (curr.right.key > searchKey && (curr.left ==null || curr.left.key > searchKey)  )) )){
				break;
			}
			if(searchKey > curr.key) curr= curr.right;
			else curr = curr.left;
		}
		if(curr == null || curr.key > searchKey) return -1;
		return curr.key;
	}
	
	int ceil(int searchKey){
		Node curr = root;
		Node high = null;
		while(curr !=null){
			if(curr.key > searchKey) high = curr;
			//below check is useless 
			if(curr.key > searchKey && (curr.left ==null)) break;
			if(curr.key > searchKey )curr = curr.left;
			else curr = curr.right;
		}
		if(high ==null) return -1;
		return high.key;
	}
	
	//Tree travsersal
	//Pre-order element picked on first touch 1, post order element picked on third3 & last touch, in order element picked on second2 touch
	//      |1  X   |3
	//          -2
	public List<String> preOrderTraversal(Tree t){
		Stack<Node> stack = new Stack<Node>();
		List<String> preOrder = new ArrayList<String>();
		Node curr = t.root;
		stack.push(curr);
		while(stack.size() > 0){
			curr = stack.peek();
			if(!curr.isVisited){
				preOrder.add(curr.key+"");
				curr.isVisited = true;
			}
			if(curr.left !=null && !curr.left.isVisited){
				curr = curr.left;
				stack.push(curr);
			}else if(curr.right !=null && !curr.right.isVisited){
				curr = curr.right;
				stack.push(curr);
			}else{
				stack.pop();
			}
		}
		return preOrder;
	}
	
	
	public static void main(String[] args) {
		Tree t = new Tree();
		t.add(100);t.add(30);t.add(20);t.add(50);t.add(40);t.add(70);t.add(43);
		System.out.println(t.floor(28));
		System.out.println(t.ceil(101));
		System.out.println((t.preOrderTraversal(t)).toString());
	}

}
