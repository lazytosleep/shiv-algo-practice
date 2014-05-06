package CF;

public class FlipCoin {
	
	//seg tree
	Node arr[] = null;
	int n;
	static class Node{
		int val;
		int updateFlag;
	}
	
	void init(){
		for(int i=0; i<n; i++){
			arr[i] = new Node();
		}
	}
	
	int querySum(int i, int j, int nodeIdx, int startRange, int endRange){
		int left = 2*nodeIdx +1;
		int right = 2*nodeIdx +2;
		if(i<= startRange && j>=endRange){
			return arr[nodeIdx].val;
		}
		int mid = (startRange + endRange)/2;
		return min(querySum(i, j, left, startRange, mid),querySum(i, j, right,mid+1 ,endRange));
	}
	
	void update(int val, int i, int j){
		
	}
	
	int min(int i, int j){
		return i>j?j:i;
	}

}
