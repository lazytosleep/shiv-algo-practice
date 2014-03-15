package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Sort {
   public static void main(String[] args) throws IOException {
	Sort378B sr = new Sort378B();
	sr.solve();
}
}
//Example of merge sort
class Sort378B{
	 static StringTokenizer st;
	    static BufferedReader br;
	    static PrintWriter pw;
	public void solve() throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = nextInt();
		//Scanner scn = new Scanner(System.in);
		//int n = scn.nextInt();
		int[] teamA = new int[n];
		int[] teamB = new int[n];
		for(int i=0; i<n; i++){
			teamA[i] = nextInt();
			teamB[i] = nextInt();
		}
		//Print team A results
		int res =0 ;
		int thisMin = n/2;
		int otherMin = 0;
		for(int i=0; i<n;i++){
			if(i<n/2){
				pw.print(1);
				res+=1;
			}
			else{
				if(teamA[thisMin]<teamB[otherMin]){
					res+=1;
					thisMin++;
					pw.print(1);
				}
				else{
					//res+=0;
					otherMin++;
				}
			}
		}
		printLen(n, res);
		pw.println();
		res = 0;
		otherMin = 0;
		thisMin = n/2;
		for(int i=0; i<n; i++){
			if(i<n/2){
				res+=1;
				pw.print(1);
			}
			else{
				if(teamB[thisMin]< teamA[otherMin]){
					res+=1;
					thisMin++;
					pw.print(1);
				}
				else{
					//res+=0;
					otherMin++;
				}
			}
		}
		printLen(n, res);
		pw.close();
	}
	
	void printLen(int size , int n){
		
		for(int i=n+1; i<=size; i++){
			pw.print(0);
		}
	}
	
	 private static int nextInt() throws IOException {
	        return Integer.parseInt(next());
	    }
	    private static long nextLong() throws IOException {
	        return Long.parseLong(next());
	    }
	    private static double nextDouble() throws IOException {
	        return Double.parseDouble(next());
	    }
	    private static String next() throws IOException {
	        while (st==null || !st.hasMoreTokens())
	            st = new StringTokenizer(br.readLine());
	        return st.nextToken();
	    }
	
}
