package CF;

public class SegTree220B {

	int[] arr;
	int[] segTree;
	
	
	int init(int node, int st, int end){
		if(st==end){
			segTree[node] = arr[st];
			return segTree[node];
		}
		int mid = (st+end)/2;
		int 
	}
	
	
}
