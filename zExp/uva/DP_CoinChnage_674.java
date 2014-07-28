package uva;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

//traverse cents form low to high for each denomination and add 1 for new combination
public class DP_CoinChnage_674 {
	static int[] denominations = new int[]{1, 5, 10, 25, 50};
	static long ways[];
	static int amt;
	public static void main(String[] args) {
		ways = new long[30001];
		ways[0] = 1;
		for(int i=0; i<denominations.length; i++){
			for(int j=denominations[i]; j<=30000; j++){
				ways[j] +=ways[j - denominations[i]];
			}
		}
		PrintWriter pw = new PrintWriter(System.out);
		InputReader reader = new InputReader(System.in);
		int input = -1;
		String str = null;
		while((str = reader.nextLine())!=null && str.trim().length() >0 &&  (input = Integer.parseInt(str.trim()))>=0){
			long output = ways[input];
			
			pw.println(output);
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
