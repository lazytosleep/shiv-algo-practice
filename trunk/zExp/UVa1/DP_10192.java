package uva;

import java.io.PrintWriter;
import java.util.Scanner;

public class DP_10192 {
	
	public static void main(String[] args) {
		
		while(true){
			str1 = scn.nextLine();
			if(str1.trim().equals("#"))break;
			str2 = scn.nextLine();
			tcase++;
			solve();
		}
		pw.close();
	}
	static PrintWriter pw = new PrintWriter(System.out);
	static Scanner scn = new Scanner(System.in);
	static int tcase = 0;
	static String str1, str2;
	static void solve(){
	int[][] table = new int[str1.length()+1][str2.length()+1];
	for(int i=0; i<=str1.length();i++){
		for(int j=0; j<=str2.length();j++){
			if(i==0 || j==0)table[i][j] = 0;
			else{
				if(str1.charAt(i-1) == str2.charAt(j-1)){
					table[i][j] = table[i-1][j-1] + 1;
				}else{
					table[i][j] = Math.max(table[i-1][j], table[i][j-1]);
				}
			}
			
		}
	}
	//pw.format("Case #%d: you can visit at most %d cities.",tcase,table[str1.length()][str2.length()]);
	pw.println("Case #"+tcase+": you can visit at most "+table[str1.length()][str2.length()]+" cities.");
	}
	
}
