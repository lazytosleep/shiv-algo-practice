package uva;

import java.io.PrintWriter;
import java.util.Scanner;
/**
 * 
 * @author shiv
 * simple knapsack problem
 *
 */
public class DP_knpasack_562 {
	
	public static void main(String[] args) {
		PrintWriter pw = new PrintWriter(System.out);
		Scanner scn = new Scanner(System.in);
		int cases = Integer.parseInt(scn.nextLine());
		while(cases-->0){
			int inputSize = Integer.parseInt(scn.nextLine());
			if(inputSize ==0)scn.nextLine();
			int[] arr = new int[inputSize];
			int sum = 0;
			int itemFound = 0;
			while(itemFound !=inputSize){
			String[] stArr = scn.nextLine().split("\\s");
			itemFound += stArr.length;
			for(int i=0; i<stArr.length; i++){
				arr[i] = Integer.parseInt(stArr[i]);
				sum += arr[i];
			}
			}
			int tot = sum/2;
			int[][] dpTable = new int[arr.length+1][tot+1];
			for(int coin =0; coin <=arr.length; coin ++){
				for(int amt =0; amt<=tot; amt++){
					if(amt ==0 || coin ==0) continue;
					else{
						int coinVal = arr[coin-1];
						if(coinVal <=amt){
							dpTable[coin][amt] = Math.max(dpTable[coin-1][amt-coinVal] + coinVal, dpTable[coin-1][amt]);
						}else{
							dpTable[coin][amt] = dpTable[coin-1][amt];
						}
					}
				}
			}
			pw.println(sum - 2 *dpTable[arr.length][tot]);
		}
		pw.close();
	}

}
