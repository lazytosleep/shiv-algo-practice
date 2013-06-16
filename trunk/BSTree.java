import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class BSTree {
	
	Node root = null;
	class Node{
	    Node parent, left, right;	
		int val;
		Node(Node parent, int val){
			this.parent = parent;
			this.val = val;
		}
	}
	
	
	public void Add(int val){
		if(root ==null){
			Node node = new Node(null, val);
			root = node;
		}else {
			Node local = root;
			while(true){
				if(val >= local.val ){
					if(local.right == null){
						Node node = new Node(local, val);
						local.right = node;
						break;
					}else{
						local = local.right;
					}
				}else if(val < local.val){
					if(local.left == null){
						Node node = new Node(local, val);
						local.left = node;
						break;
					}else{
						local = local.left;
					}
				}
			}
		}
				
	}
	
	public void printTree(){
		List<Node> li = (new ArrayList<Node>());
		li.add(root);
		printInt(li);
	}
	private void printInt(List<Node> li){
		List<Node> newList = new ArrayList<Node>(); 
		Iterator<Node> itr = li.listIterator();
		while(itr.hasNext()){
			Node node = itr.next();
		if(node !=null)System.out.print(node.val);
		
		 if(node.left !=null) newList.add(node.left);
		 if(node.right != null) newList.add(node.right);
		}
		System.out.print("\n");
		if(newList.size()>0) printInt(newList);
	}
	
	public static void main(String [] args){
		BSTree tree = new BSTree();
		tree.Add(5);
		tree.Add(3);
		tree.Add(7);
		tree.Add(1);
		tree.Add(2);
		tree.Add(8);
	    tree.printTree();
		
	}
	
	
}
