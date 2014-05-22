package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MStick {
	
	float arr[];
	float segTree[];
	
	void init(){
		int size = arr.length -1 + arr.length;
		segTree = new float[size];
		buildMinTree(0, 0, arr.length-1);
	}
	
	float buildMinTree(int node, int start, int end){
		if(start == end){
			segTree[node] = arr[start];
			return segTree[node];
		}
		int mid = (start + end)/2;
		float left = buildMinTree(2*node +1, start, mid);
		float right = buildMinTree(2*node +2, mid+1, end);
		segTree[node] = left<right? left : right;
		return segTree[node];
	}
	
	float update(int node, int start, int end, int l, int r, float val){
		if(start == end){
			segTree[node] = (segTree[node] - val)/2;
			return segTree[node];
		}
		int mid = (start+end)/2;
		if(l<=start && r>=end){
			float left = update(2*node +1, start, mid, l,r,val);
			float right = update(2*node +2, mid+1, end, l,r,val);
			return segTree[node]= left<right?left:right;
		}
		if(l<=mid){
			update(2*node +1, start, mid, l,r,val);
		}
		if(r>mid+1){
			update(2*node +2, mid+1, end, l,r,val);
		}
		return 0;
	}
	
	float findMin(int node, int start, int end, int l, int r){
		if(l<=start && end<=r){
			return segTree[node];
		}
		int mid = (start+end)/2;
		
		if(l<=mid && mid+1 <=r){
			return min(findMin(2+node+1, start, mid, l, r),findMin(2+node+2, mid+1, end, l, r));
		}
		if(r<=mid)return findMin(2+node+1, start, mid, l, r);
		if(l>=mid+1) findMin(2+node+2, mid+1, end, l, r);
		return 0;
	}
	
	float min(float i, float j){
		return i<j?i:j;
	}
	
	float solve(int i, int j){
		
		int min1= findMin(0,i-1);
		
	    return max+min;
	}
	
	public static void main(String[] args) {
			InputReader reader = new InputReader(System.in);
			int n = reader.nextInt();
			MStick ms = new MStick();
			ms.arr = new float[n];
			for(int i=0; i<n; i++){
				ms.arr[i] = reader.nextInt();
			}
			int noOfQ = reader.nextInt();
			for(int i=0;  i<noOfQ; i++){
				System.out.println(ms.solve(reader.nextInt(), reader.nextInt()));
			}
	}
	
	
	
	
	
	static class InputReader {
	    private BufferedReader reader;
	    private StringTokenizer stt;
	 
	    public InputReader(InputStream stream) {
	        reader = new BufferedReader(new InputStreamReader(stream));
	    }
	 
	    public String nextLine() {
	        try {
	            return reader.readLine().trim();
	        } catch (IOException e) {
	            return null;
	        }
	    }
	 
	    public String nextString() {
	        while (stt == null || !stt.hasMoreTokens()) {
	            stt = new StringTokenizer(nextLine());
	        }
	        return stt.nextToken();
	    }
	 
	    public int nextInt() {
	        return Integer.parseInt(nextString());
	    }
	 
	}

}



