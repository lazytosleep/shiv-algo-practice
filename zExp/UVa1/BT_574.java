package uva;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author shivendra
 * for every elemnts recurse with and without
 *
 */
public class BT_574 {
	static PrintWriter pw = new PrintWriter(System.out);
	static Scanner scn = new Scanner(System.in);
	static int[] intarr = null;
	static LinkedHashSet<List> res = null;
	public static void main(String[] args) {
		PrintWriter pw = new PrintWriter(System.out);
		Scanner scn = new Scanner(System.in);
		while(true){
			String[] arr = scn.nextLine().split("\\s");
			int num = Integer.parseInt(arr[0]);
			if(num ==0) break;
			res = new LinkedHashSet<List>();
					
			intarr = new int[arr.length-2];
			for(int i=2; i<arr.length; i++){
				intarr[i-2] = Integer.parseInt(arr[i]);
			}
			List<Integer> li = new ArrayList();
			solve(num, 0, li);
			
			pw.printf("Sums of %d:\n", num);
			if(res.size() ==0){
				pw.println("NONE");
			}
			else
			for(List<Integer> loc : res){
				String str = "";
				for(int i=0; i<loc.size(); i++){
					if(i!=0) str +="+";
					str+=loc.get(i);
				}
				pw.println(str);
			}
			
		}
		
		pw.close();
	}
	
	
	static void solve(int num, int idx, List<Integer> li){
		if(num ==0){
			res.add(li);
			return;
		}
		if(num <0 || idx >=intarr.length){
			return;
		}
		List<Integer> li2 = new ArrayList(li.size()); 
		li2.addAll(li);
		li.add(intarr[idx]);
		//below two lines are core logic
		solve(num-intarr[idx], idx+1, li );
		solve(num, idx+1, li2);
		

	}
	
	

}

