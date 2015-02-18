package uva;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BS_12032 {
	
	static int[] arr = new int []{3 ,9,  10, 14};
	static int min;
	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int cases =  reader.nextInt();
		int caseNo = 0;
		while(cases-->0){
			int size = reader.nextInt();
			arr = new int[size];
			String[] input = reader.nextString().split("\\s");
			for(int i=0; i<size; i++){
				arr[i] = Integer.parseInt(input[i]);
			}
			int l =0;
			int h = 10000005;
			while(l<h){
				int mid = (h+l)/2;
				boolean midVal = isPowerSufficient(mid);
				boolean lVal = isPowerSufficient(l);
				if(lVal){
					h = mid-1;
				}else if(midVal){
					h = mid;
				}else{
					l = mid+1;
				}
			}
			min = l;
			pw.println(String.format("Case %d: %d",++caseNo,min ));
		}
		pw.close();
	}

	static boolean isPowerSufficient(int pow){
		int last = 0;
		for(int x : arr){
			int tar = x - last;
			last = x;
			if(tar == pow)pow--;
			else if(tar<pow)continue;
			else return false;
		}
		return true;
	}
	
	static class InputReader {
	    private BufferedReader reader;
	    private StringTokenizer stt;
	 
	    public InputReader(InputStream stream) {
	        reader = new BufferedReader(new InputStreamReader(stream));
	    }
	 
	    public int nextInt(){
	    	try {
				return Integer.parseInt(reader.readLine().trim());
			} catch(Exception e) {
				return -1;
			}
	    }
	    
	    public String nextString(){
	    	try {
				return reader.readLine().trim();
			} catch(Exception e) {
				return null;
			}
	    }
	    
	    
	 
	}

}
