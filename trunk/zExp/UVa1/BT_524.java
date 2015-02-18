package uva;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class BT_524 {
	static PrintWriter pw = new PrintWriter(System.out);
	static Scanner scn = new Scanner(System.in);
	static int n;
	static int[] arr;
	static boolean[] barr;
	public static void main(String[] args) throws FileNotFoundException {
		String str = null;
		int test = 0;
	 while(scn.hasNextLine() ){
		 str = scn.nextLine();
		 if(test!=0) pw.println();
		 n = Integer.parseInt(str);
		 arr = new int[n+1];
		 barr = new boolean[n+1];
		 barr[1] = true;
		 arr[1] = 1;
		 pw.println("Case "+ ++test +":");
		 solve(1);
		 
		 if(test==2)
		 break;
	 }
	 pw.close();
	 
	}

	static void solve(int idx){
		int i =1;
		for(; i<barr.length; i++){
			if(!barr[i] && isPrime(i +arr[idx])){
				barr[i] = true;
				
				arr[idx+1] = i;
				if(idx+1 == n ){
					if(isPrime(1 + i)){
						String ans = "";
						for(int p =1; p<arr.length; p++){
							if(p!=1) ans+= " ";
							ans += arr[p];
						}
						pw.println(ans);
					}
					//barr = new boolean[n+1];
					//barr[1] = true;
				}else
					solve(idx+1);
				
				barr[i] = false;
			}
			
			

			
		}
	}
	
	static boolean isPrime(int number){
	         
	        for(int i=2; i<=number/2; i++){
	            if(number % i == 0){
	                return false;
	            }
	        }
	        return true;
	}
	

}

