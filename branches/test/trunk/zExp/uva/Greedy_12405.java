package uva;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 
 * @author shivendra
 *
 */
public class Greedy_12405 {

	static char[] arr;
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		PrintWriter pw  = new PrintWriter(System.out);
		int cases  = scn.nextInt();
		int test = 0;
		while(cases-->0){
			int size = scn.nextInt();
			arr = new char[size];
			arr = scn.next().toCharArray();
			pw.println(String.format("Case %d: %d", ++test, solve()));
		}
		pw.close();
	}

	static int solve(){
		int needed = 0;
		for(int i=0 ; i<arr.length; i++){
			char ch = arr[i];
			if(ch == '.'){
				needed++;
				i = i+2;
			}
		}
		return needed;
		
	}

}


