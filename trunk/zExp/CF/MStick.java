package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MStick {
	
	float arr[];
	float segTree[];
	int oldValToRestore = -1;
	void init(){
		int size = arr.length -1 + arr.length;
		segTree = new float[size];
		buildMinTree(0, 0, arr.length-1);
	}
	
	float buildMaxTree(int node, int start, int end){
		if(start == end){
			segTree[node] = arr[start];
			return segTree[node];
		}
		int mid = (start + end)/2;
		float left = buildMinTree(2*node +1, start, mid);
		float right = buildMinTree(2*node +2, mid+1, end);
		return segTree[node] = left>right? left : right;
	}
	
	float updateMaxTree(int node, int start, int end, int l, int r, float val, boolean revert){
		if(start == end){
			if(!revert)
			segTree[node] = (segTree[node] - val)/2;
			else
			segTree[node] = segTree[node] *2 + val;
			return segTree[node];
		}
		int mid = (start+end)/2;
		if(l<=mid){
			updateMaxTree(2*node +1, start, mid, l,r,val, revert);
		}
		if(r>=mid+1){
			updateMaxTree(2*node +2, mid+1, end, l,r,val, revert);
		}
		return segTree[node] = max(segTree[2*node+1], segTree[2*node+2]);
	}
	
	float findMax(int node, int start, int end, int l, int r){
			if(l<=start && end <=r){
			   return segTree[node]
			}
			int mid = (start +end)/2;
			if(mid<=r){
			  return findMax(2*node+1, start, mid, l,r);
			}
			if(mid+1 >=l){
				return findMax(2*node+2, mid+1, end, l, r);
			}
			return max(findMax(2*node+1, start, mid, l,r), findMax(2*node+2, mid+1, end, l, r));
	
	}
	
	float max(float i, floatj){
		return i>j?i:j;
	}
	float findMin(int node, int start, int end, int l, int r){
		if(l<=start && end<=r){
			return segTree[node];
		}
		int mid = (start+end)/2;
		if(r<=mid)return findMin(2+node+1, start, mid, l, r);
		if(l>=mid+1) return findMin(2+node+2, mid+1, end, l, r);
		return min(findMin(2+node+1, start, mid, l, r),findMin(2+node+2, mid+1, end, l, r));
	}
	
	float min(float i, float j){
		return i<j?i:j;
	}
	
	float solve(int i, int j){
        int max1, max2, max3 =0;		
		if(i-1>0){
		    max1 = findMax(0, 0, arr.lenght, 0, i-1 );
		}
		max2 = findMax(0, 0, arr.lenght, i, j );
		if(j+1<arr.length){
			max3 = findMax(0, 0, arr.lenght, j+1, arr.length-1 );
		}
		int tempTime = 0;
		if(max2 >=max1 && max2>=max3){
		    if(oldValToRestore ==-1){
			  float min = findMin(0, 0, arr.lenght, i, j);
			  updateMaxTree(0, 0, arr.length, i, j, min, false);
			  oldValToRestore = min;
			}else{
			   updateMaxTree(0, 0, arr.length, i, j, oldValToRestore, true);
			   float min = findMin(0, 0, arr.lenght, i, j);
			   updateMaxTree(0, 0, arr.length, i, j, min, false);
			    oldValToRestore = min;
			}
		   max2 = findMax(0, 0, arr.lenght, i, j);
		   tempTime = oldValToRestore;
		}
		int time = max(max2, max(max1, max3));
		int totalTime = time + tempTime;
		
	    return totalTime;
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



