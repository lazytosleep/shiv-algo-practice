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
		for(int i=0; i<n; i++){
			arr[i] = new Node();
		}
	}
	
	int querySum(int i, int j, int nodeIdx, int startRange, int endRange){
		Node currNode = arr[nodeIdx];
		int left = 2*nodeIdx +1;
		int right = 2*nodeIdx +2;
		//if node is stale and has some value value to propogate do it now
		if(currNode.propogate !=0){
			propogateTillLeaf(nodeIdx, currNode.propogate);
		}
		if(i<= startRange && j>=endRange && !currNode.isStale ){
			return arr[nodeIdx].val;
		}else if( i>endRange || j < startRange){
			return 0;
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
		 Node node = arr[nodeIdx];
		 node.isStale = true;
		 if(i<= startRange && j >= endRange){
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
	
	void propogateTillLeaf(int nodeIdx, int val){
		int left = 2 * nodeIdx +1;
		int right = 2* nodeIdx +2;
		if(2*nodeIdx+1 < arr.length) {
		propogateTillLeaf(2*nodeIdx+1, val);
		}else{
			//this is leaf as no left child
			arr[nodeIdx].val +=val;
			return;
		}
		if(2*nodeIdx +2 < arr.length){
		propogateTillLeaf(2*nodeIdx+2, val);
		}
		arr[nodeIdx].val = sum(arr[left].val , arr[right].val);
		arr[nodeIdx].isStale = false;
		
	}
	
	int sum(int i, int j){
		return i+j;
	}

}
