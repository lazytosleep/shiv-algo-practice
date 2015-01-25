
package uva;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 
 * @author shiv
 * Kanpsack 0-1 problem
 *
 */

public class DP_10664 { 

	public static void main(String[] args) {
		PrintWriter pw = new PrintWriter(System.out);
		Scanner scn = new Scanner(System.in);
		int cases = Integer.parseInt(scn.nextLine());
		while(cases-->0){
			
			String[] strArr = scn.nextLine().split("\\s");
			int[] arr = new int[strArr.length];
			
			int sum =0;
			for(int i=0; i<strArr.length; i++){
				arr[i] = Integer.parseInt(strArr[i]);
				sum +=arr[i];
			}
			if((sum & 1) == 0){
				int[][] dpTable = new int[arr.length+1][sum/2 +1];
				for(int item=0; item<dpTable.length; item++){
					
					for(int weight=0; weight<dpTable[item].length; weight++){
						if(item==0 || weight==0) dpTable[item][weight] = 0;
						else{
							int wt = arr[item-1];
							if(wt <=weight)
								dpTable[item][weight] = Math.max(dpTable[item-1][weight-wt] + wt, dpTable[item-1][weight]);
							else
								dpTable[item][weight] = dpTable[item-1][weight];
						}
					}
				}
				pw.println(dpTable[arr.length][sum/2] == sum/2?"YES" : "NO");
			}else{
				pw.println("NO");
			}
			
		}
		pw.close();
	}
	
	/** below DP function would have worked provided infinite supply of items
	 * boolean[] dpTable = new boolean[sum/2 +1];
				dpTable[0] = true;
				for(int i=1; i<=sum/2; i++){
					for(int j=0; j<arr.length; j++){
						if(arr[j]<=i){
							if(dpTable[i-arr[j]]){
								dpTable[i] = true;
								break;
							}
						}
					}
				}
	 */
	

} 