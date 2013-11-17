
public class Tree {
	
	Node root;
	class Node{
		Node left, right;
		int key;
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
	
	public static void main(String[] args) {
		Tree t = new Tree();
		t.add(100);t.add(30);t.add(20);t.add(50);t.add(40);t.add(70);t.add(43);
		System.out.println(t.floor(28));
		System.out.println(t.ceil(101));
	}

}
