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
			
			int [] maxArr = new int[size];
			maxArr[0] = arr[0];
			int absMax = maxArr[0] ;
			for(int i=1; i<size; i++){
				int curr = arr[i];
				maxArr[i] = maxArr[i-1] + curr <curr ? curr : maxArr[i-1] + curr;
				absMax = maxArr[i] > absMax ? maxArr[i] : absMax;
			}
			if(absMax>0){
				pw.println(String.format("The maximum winning streak is %d.", absMax));
			}else
			pw.println("Losing streak.");
		}
		pw.close();
		
	}
}
