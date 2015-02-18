package uva;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//Instead of doing brute force search n2...do sorting nlogn and binary search  for n items nlogn

public class BS_11057 {
	static int[] arr;
	static int target;
	
	public static void main(String[] args) {
		PrintWriter pw = new PrintWriter(System.out);
		InputReader reader = new InputReader(System.in);
		String str = null;
		while((str=reader.nextLine()) !=null){
			if(str.length() == 0)continue;
			int size = Integer.parseInt(str);
			arr= new int[size];
			String[] strn = reader.nextLine().split("\\s");
			for(int i=0; i<size; i++){
				arr[i] = Integer.parseInt(strn[i]);
			}
			target = Integer.parseInt(reader.nextLine());
			Arrays.sort(arr);
			int fir = 0;
			int sec = 0;
			int minDiff = Integer.MAX_VALUE;
			for(int i=0; i<arr.length-1; ){
				int firloc = arr[i];
				int secloc = target - firloc;
				if(Arrays.binarySearch(arr, ++i, arr.length, secloc)>=0){
					if(Math.abs((secloc - firloc)) < minDiff){
						minDiff= secloc - firloc;
						fir = firloc;
						sec = secloc;
					}
				}
			}
			pw.println(String.format("Peter should buy books whose prices are %d and %d.", fir, sec));
			pw.println();
		}
		pw.close();
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
	        } catch (Exception e) {
	            return null;
	        }
	    }
	}

}

