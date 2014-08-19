package ds;
/**
 * 
 * @author shivendra 
 * used for RMQ
 *
 */
public class SegmentTreeV2 {
	
	static int[] array;
	static int[] segmentTree;
	static enum oper {min, max, sum};
	static oper currOper;
	static int notInArrayToken = -1;
	
	static void init(){
		int n = array.length;
		int segTreeSize = (int) (2 * Math.pow(2, Math.floor((Math.log(n)/Math.log(2)) +1)));
		segmentTree = new int[segTreeSize];
	}
	static int buildSegTree(int[] arr, int node,  int l, int r){
		if(l==r){
			return (segmentTree[node] = arr[l]);
		}else{
			int mid = (l+r)/2;
			if(currOper == oper.min){
				return segmentTree[node] = Math.min(buildSegTree(arr, 2* node +1, l, mid), buildSegTree(arr, 2*node +2, mid+1, r));
			}else if(currOper == oper.max){
				return segmentTree[node] = Math.max(buildSegTree(arr, 2* node +1, l, mid), buildSegTree(arr, 2*node +2, mid+1, r));
			}else{
				return segmentTree[node] = buildSegTree(arr, 2* node +1, l, mid)+ buildSegTree(arr, 2*node +2, mid+1, r);
			}
				
		}
	}
	
	static int query(int i, int j, int node, int l, int r){
		if(i>r || j < l)return -1;
		if(i<=l && r <=j){
			return segmentTree[node];
		}else{
			int mid = (l+r)/2;
			int leftVal = query(i, j, 2*node+1, l , mid);
			int rtVal = query(i, j, 2*node +2, mid+1, r);
			if(currOper == oper.min)return leftVal!=-1 ? rtVal !=-1 ? Math.min(leftVal, rtVal):leftVal: rtVal;
			else if(currOper == oper.max)return leftVal!=-1 ? rtVal !=-1 ? Math.max(leftVal, rtVal):leftVal: rtVal;
			else return leftVal!=-1 ? rtVal !=-1 ? (leftVal + rtVal):leftVal: rtVal;
		}
		
	}
	
	static void update(){
		
	}
	
	static void lazyUpdate(){
		
	}
	
	public static void main(String[] args) {
		array = new int[]{1,2,3,5,2,8};
		init();
		currOper = oper.max;
		buildSegTree(array, 0, 0, array.length-1);
		System.out.println(query(0,4,0,0,array.length-1) + " :: "+ query(3,4,0,0,array.length-1));
		init();
		currOper = oper.min;
		buildSegTree(array, 0, 0, array.length-1);
		System.out.println(query(0,4,0,0,array.length-1) + " :: "+ query(3,4,0,0,array.length-1));
		init();
		currOper = oper.sum;
		buildSegTree(array, 0, 0, array.length-1);
		System.out.println(query(0,4,0,0,array.length-1) + " :: "+ query(3,4,0,0,array.length-1));
		
	}

}
