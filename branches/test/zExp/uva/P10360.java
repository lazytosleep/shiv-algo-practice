package uva;

import java.io.PrintWriter;
import java.util.Scanner;

public class P10360 {
	static int[][] ratKilled ;
	static int max_i, max_j, max_no;
	public static void main(String[] args) {
		PrintWriter pw = new PrintWriter(System.out);
		Scanner scn = new Scanner(System.in);
		int cases = scn.nextInt();
		while(cases-- >0){
			ratKilled = new int[1025][1025];
			max_no =0 ;max_i =0;max_j = 0;
			int d = scn.nextInt();
			int ratsData = scn.nextInt();
			while(ratsData-- >0){
				int x = scn.nextInt();
				int y = scn.nextInt();
				int rats = scn.nextInt();
				int i = x-d >0 ? x-d : 0;
				int xLimit = x+d < 1025 ? x+d : 1024;
				int j = y-d >0 ? y-d : 0;
				int yLimit = y+d < 1025 ? y+d : 1024;
				for(;i<=xLimit;i++){
					int k = j;
					for(;k<=yLimit; k++){
						ratKilled[i][k] = ratKilled[i][k] + rats;
						if(ratKilled[i][k] > max_no){
							max_i = i;
							max_j = k;
							max_no = ratKilled[i][k];
						}
					}
				}
			}
			pw.println(max_i +" "+max_j+" "+max_no);
		}
		pw.close();
	}

}
