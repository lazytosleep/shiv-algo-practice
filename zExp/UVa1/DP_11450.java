package uva;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DP_11450 {
	static PrintWriter pw = new PrintWriter(System.out);
	static Scanner scn = null;
	public static void main(String[] args) throws FileNotFoundException {
		scn = new Scanner(new File("D:\\new  6.txt"));
		int size = Integer.parseInt(scn.nextLine());
		while(size-- >0){
			String[] arr = scn.nextLine().split("\\s");
			int M = Integer.parseInt(arr[0]);
			int c = Integer.parseInt(arr[1]);
			List<Integer>[] ver = new ArrayList[c];
			for(int x=0; x<c; x++){
				arr = scn.nextLine().split("\\s");
				ver[x] = new ArrayList();
				for(int y=1; y<arr.length; y++){
					ver[x].add(Integer.parseInt(arr[y]));
				}
			}
			//input parsing ends
			
			int[][] dp = new int[M+1][c+1];
			for(int i=0;  i<dp.length; i++){
				for(int j=0; j<dp[i].length; j++){
				if(j!=0)
				dp[i][j] = -1000;
				}
			}
			for(int m=1; m<=M; m++){
				for(int j=1; j<=c; j++ ){
					for(int k=0; k<ver[j-1].size();k++){
						int camt = ver[j-1].get(k);
						if(m>=camt && dp[m-camt][j-1]!=-1000){
						int dpVal = dp[m-camt][j-1] + camt;
						
						dp[m][j] = Math.max(dp[m][j], dpVal);
						}
					}
				}
			}
			
			
			if(dp[M][c]!=-1000)
			pw.println(dp[M][c]);
			else
				pw.println("no solution");
		}
		pw.close();
		
		

	}
	
	

}

//below solution is correct but runtime complexity is exponential 
/*
 * int[] dppre =new int[1], dpcur=null;
			while(ver-->0){
				arr = scn.nextLine().split("\\s");
				int len = Integer.parseInt(arr[0]);
				dpcur = new int[dppre.length * len];
				int idx =0;
				for(int i=1; i<=len; i++){
					int x = Integer.parseInt(arr[i]);
					for(int j=0; j<dppre.length;j++){
						dpcur[idx] = dppre[j]+x;
						if(ver ==0){
							max = dpcur[idx] >max && dpcur[idx] <=amt ? dpcur[idx] : max;
						}
						idx++;
					}
				}
				dppre= dpcur;
				
			}
			if(max>0)
			pw.println(max);
			else
				pw.println("no solution");
 */





