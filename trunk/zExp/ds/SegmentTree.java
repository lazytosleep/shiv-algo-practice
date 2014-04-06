package ds;

public class SegmentTree {
	
	int [] inputArray, segmentTree = null;
	
	public void initSegmentTree(){
		segmentTree = new int[inputArray.length];
		
	}
	
	public int populateSegmentTree(int idx, int start, int end){
		
		//divide and get min
		if(start == end){
			segmentTree[idx] = inputArray[start];
			return segmentTree[idx];
		}
		int midIdx = (start + end)/2;
		segmentTree[idx] = min(populateSegmentTree(idx*2+1, start, midIdx),populateSegmentTree(idx*2+2, midIdx+1, end) );
		return segmentTree[idx];
		
	}
	
	public int minQuery(int start, int end, int min, int max, int idx){
		 int midIdx = (min+max)/2;
		 if(min>end || max<start ) return Integer.MAX_VALUE;
		 
		 if((min == max) || (min>=start && max <=end))return segmentTree[idx];
		 
		return min(minQuery(start, end, start, midIdx, idx*2 +1), minQuery(start, end, midIdx+1, end, idx*2 + 2));
		
	}
	
	int min(int i, int j){
		return i>j? j: i;
	}
	
	public static void main(String[] args) {
		SegmentTree st = new SegmentTree();
		st.inputArray = new int[]{4,5,3,1,8,2,7,5};
		st.segmentTree = new int[50];
		st.populateSegmentTree(0, 0, st.inputArray.length-1);
		System.out.println(st.minQuery(2, 7, 0, st.inputArray.length-1, 0));
		
	}
	
	

}
