package uva;

import java.io.PrintWriter;
import java.util.Scanner;

public class DP_10684 {

	public static void main(String[] args) {
		PrintWriter pw = new PrintWriter(System.out);
		Scanner scn = new Scanner(System.in);
		int size = 0;
		int[] arr = null;
		while((size =scn.nextInt())!=0){
			arr = new int[size];
			for(int i=0; i<size; i++){
				arr[i] = scn.nextInt();
			}
			
			int [] minArr = new int[size];
			minArr[0] = arr[0];
			int absMax = minArr[0] ;
			for(int i=1; i<size; i++){
				int curr = arr[i];
				minArr[i] = minArr[i-1] + curr <curr ? curr : minArr[i-1] + curr;
				absMax = minArr[i] > absMax ? minArr[i] : absMax;
			}
			if(absMax>0){
				pw.println(String.format("The maximum winning streak is %d.", absMax));
			}else
			pw.println("Losing streak.");
		}
		pw.close();
		
	}
}
