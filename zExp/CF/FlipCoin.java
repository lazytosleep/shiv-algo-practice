package CF;

public class FlipCoin {
	
	//seg tree
	Node arr[] = null;
	int n;
	static class Node{
		int val;
		int propogate;
		boolean isStale;
	}
	
	void init(){
		arr = new Node[n];
		for(int i=0; i<n; i++){
			arr[i] = new Node();
		}
	}
	
	int querySum(int i, int j, int nodeIdx, int startRange, int endRange){
		if(nodeIdx >=arr.length ||  i>endRange || j < startRange){
			return 0;
		}
		Node currNode = arr[nodeIdx];
		int left = 2*nodeIdx +1;
		int right = 2*nodeIdx +2;
		//if node is stale and has some value value to propogate do it now
		if(currNode.propogate !=0){
			propogateTillLeaf(nodeIdx, currNode.propogate);
		}
		if(i<= startRange && j>=endRange && !currNode.isStale ){
			return arr[nodeIdx].val;
		} 
		
		int mid = (startRange + endRange)/2;
		int sum =  sum(querySum(i, j, left, startRange, mid),querySum(i, j, right,mid+1 ,endRange));
		if(currNode.isStale && !arr[left].isStale && !arr[right].isStale){
			currNode.isStale = false;
			currNode.val = sum;
		}
		return sum;
	}
	//propogate till the range become subset i,j
	void update(int val, int i, int j, int nodeIdx, int startRange, int endRange){
		 if(nodeIdx >= arr.length)return;
		 Node node = arr[nodeIdx];
		 node.isStale = true;
		 if(i<= startRange && j >= endRange){
			 //if leaf node
			 if(startRange == endRange){
				 node.isStale = false;
				 node.val +=val;
			 }else
			 node.propogate = val;
		 }else{
		    int mid = (startRange + endRange)/2;
			int left = 2*nodeIdx +1;
			int right = 2*nodeIdx +2;
			if(i<=mid){
				update(val, i, j, left, startRange, mid);
			}
			if(j>mid){
				update(val, i, j, right, mid+1, endRange);
			}
		 	 
		 }
	}
	
	boolean isLeafNode(int idx){
		//should not have left child
		return (2*idx +1 >=arr.length);
	}
	
	void propogateTillLeaf(int nodeIdx, int val){
		int left = 2 * nodeIdx +1;
		int right = 2* nodeIdx +2;
		int sum =0;
		if(isLeafNode(nodeIdx)) {
			//this is leaf as no left child
			arr[nodeIdx].val +=val;
			return;
		}else{
			int propVal  = arr[left].propogate;
			if(propVal !=0)val +=propVal;
			propogateTillLeaf(left, val);
			sum += arr[left].val;
		}
		if(2*nodeIdx +2 < arr.length){
			int propVal  = arr[right].propogate;
			if(propVal !=0)val +=propVal;
		propogateTillLeaf(right, val);
		sum+= arr[right].val;
		}
		arr[nodeIdx].val = sum;
		arr[nodeIdx].isStale = false;
		arr[nodeIdx].propogate = 0;
		
	}
	
	int sum(int i, int j){
		return i+j;
	}
	
	public static void main(String[] args) {
		FlipCoin fc = new FlipCoin();
		fc.n = 7;
		//Max size height of tree
		fc.init();
		fc.update(1, 0, 2, 0, 0, 3);
		fc.update(4, 2, 3, 0, 0, 3);
		System.out.println(fc.querySum(1, 2, 0, 0, 3));
		
	}
	

}
