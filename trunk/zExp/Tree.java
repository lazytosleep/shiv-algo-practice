import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
	public List<String> preOrderTraversal(Tree t, int order){
		Stack<Node> stack = new Stack<Node>();
		List<String> preOrder = new ArrayList<String>();
		Node curr = t.root;
		stack.push(curr);
		while(stack.size() > 0){
			curr = stack.peek();
			if(!curr.isVisited){
				if(order==1)
				preOrder.add(curr.key+"");
				curr.isVisited = true;
			}
			if(curr.left !=null && !curr.left.isVisited){
				curr = curr.left;
				stack.push(curr);
			}else if(curr.right !=null && !curr.right.isVisited){
				curr = curr.right;
				stack.push(curr);
				if(order==2)
					preOrder.add(curr.key+"");
			}else{
				stack.pop();
				if(order==3)
					preOrder.add(curr.key+"");
			}
		}
		return preOrder;
	}
	
	static void isSumTree(Tree t){
		if(t.root == null) return;
		checkSumTree(t.root);
	}
	
	private static int checkSumTree(Node n){
		 if(n == null) return 0;
		 if(n.left ==null && n.right ==null)return n.key;
		 int sum = checkSumTree(n.left) + checkSumTree(n.right);
		 if(n.key !=sum){
			 System.out.println("Not a sum tree");
		 }
		 return sum;
	}
	static void areLeafsAtTheSameLevel(Tree t){
		if(t.root ==null) return;
		System.out.println(traverseNodes(t.root, 1)>=1);
	}
	
	static int traverseNodes(Node n, int currlevel){
		 if(n==null)return currlevel-1;
		 if(n.left ==null && n.right ==null){
			 return currlevel;
		 }
		 if(traverseNodes(n.left, currlevel+1)!=traverseNodes(n.right, currlevel+1)){
			 return -1;
		 }else return currlevel + 1;
	}
	
	static void printTree(Tree t){
		if(t.root == null)return;
		int currLevelOffset = height(t);
        Queue<Node> q = new LinkedList<Tree.Node>();
        q.add(t.root);
        while(q.size()>0){
        	Node n = q.poll();
        	if(n==null){
        		System.out.println();
        		currLevelOffset--;
        	}
        }
	}
	 static void printNode(Node n, int offset){
		 for(int i=0; i<offset; i++) System.out.print("\t");
		 System.out.print(n.key);
	 }
	
	public static void widthFirstTraversal(Tree t){
		if(t.root == null)return;
		Queue<Node> q = new LinkedList<Node>();
		q.add(t.root);
		while(q.size() >0){
			Node n = q.poll();
			System.out.print(n.key+"\t");
			if(n.left !=null) q.add(n.left);
			if(n.right !=null) q.add(n.right);
		}
	}
	
	public static int height(Tree t){
		int height = 0;
		if(t.root == null)return height;
		else return subTreeHeight(t.root)+1;
	}
	
	public static int subTreeHeight(Node n){
		   int leftHeight =0;
		   int rightHeight = 0;
		   if(n.left !=null) leftHeight = subTreeHeight(n.left) + 1;
		   if(n.right !=null) rightHeight = subTreeHeight(n.right) + 1;
	       if(leftHeight >=rightHeight)return leftHeight;
	       else return rightHeight;
	}
	
	
	public static void main(String[] args) {
		Tree t = new Tree();
		t.add(100);t.add(30);t.add(20);t.add(50);t.add(40);t.add(70);t.add(43);t.add(200);
		System.out.println(t.floor(28));
		System.out.println(t.ceil(101));
		System.out.println((t.preOrderTraversal(t,3)).toString());
		System.out.println(t.height(t));
		t.widthFirstTraversal(t);
		areLeafsAtTheSameLevel(t);
		isSumTree(t);
	}

}
