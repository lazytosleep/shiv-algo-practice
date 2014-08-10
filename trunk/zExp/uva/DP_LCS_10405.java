package uva;

import java.io.PrintWriter;
import java.util.Scanner;

public class DP_LCS_10405 {
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		while(scn.hasNextLine()){
			String str1 = scn.nextLine();
			String str2 = scn.nextLine();
			int[][] opt = new int[str1.length()+1][str2.length()+1];
			for(int i=1; i<=str1.length();i++){
				for(int j=1; j<=str2.length(); j++){
					if(str1.charAt(i-1) == str2.charAt(j-1)){
						opt[i][j] = opt[i-1][j-1] +1;
					}else{
						opt[i][j] = Math.max(opt[i-1][j], opt[i][j-1]);
					}
				}
			}
			pw.println(opt[str1.length()][str2.length()]);
		}
		pw.close();
		
	}

}
