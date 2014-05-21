package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MStick {
	
	float arr[];
	
	float solve(int i, int j){
		
		//Find the min time in range
		float min =arr[i];
		for(int idx=i; idx<=j; idx++){
			min = arr[idx] < min ? arr[idx] : min;
		}
		
		//update array i to j 
	    for(int idx =i; idx <=j; idx++){
	    	arr[idx] = (arr[idx] - min)/2;
	    }
		
	    //find the max in range
	    float max =0;
	    for(int idx=0; idx<arr.length; idx++){
	    	max =  arr[idx] > max ? arr[idx] : max;
	    }
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



