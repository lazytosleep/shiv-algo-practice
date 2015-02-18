package uva;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BT_Subsetsum_624 {
	static int len = 0;
	static List<Integer> maxli;
	static int max = 0;
	static int lim = 0;
	static int[] intArr = null;
	public static void main(String[] args) throws Exception {
		PrintWriter pw = new PrintWriter(System.out);
		Scanner scn = new Scanner(new File("D:\\new  6.txt"));
		while(scn.hasNext()){
			max =0;
		String[] arr = scn.nextLine().split("\\s");
		intArr = new int[arr.length];
		len  =arr.length;
		for(int i=0; i<arr.length;i++){
			intArr[i] = Integer.parseInt(arr[i]); 
		}
		int size  = intArr[0];
		lim  = size;
		comb(size, 2, new ArrayList<Integer>());
		StringBuffer buf = new StringBuffer();
		for(int i=0; i<maxli.size(); i++){
			buf.append(maxli.get(i)).append(" ");
		}
		buf.append("sum:").append(max);
		pw.println(buf.toString());
		}
		pw.close();
		
	}
	
	static void comb(int size, int idx, List<Integer> li){
		if(idx>= len || size <=0 ){
			int locsum = 0;
			for(int i=0; i<li.size(); i++){
				locsum += li.get(i);
			}
			if(locsum <=lim && locsum >max){
				max = locsum;
				maxli = li;
			}
			return;
		}
		int val = intArr[idx];
		List<Integer> li1 = new ArrayList<Integer>(li.size()); 
		li1.addAll(li);
		li1.add(val);
		comb(size-val, idx+1, li1 );
		comb(size, idx+1, li);
	}

}
