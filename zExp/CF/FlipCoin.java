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
		if(i<= startRange && j>=endRange && !currNode.isStale ){
			return arr[nodeIdx].val;
		}
		int mid = (startRange + endRange)/2;
		int sum =  min(querySum(i, j, left, startRange, mid),querySum(i, j, right,mid+1 ,endRange));
		if(currNode.isStale && !arr[left].isStale && !arr[right].isStale){
			currNode.isStale = false;
			currNode.val = sum;
		}
		return sum;
	}
	
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
	
	int min(int i, int j){
		return i>j?j:i;
	}

}
