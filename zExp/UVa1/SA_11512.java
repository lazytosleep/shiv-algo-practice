package uva;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SA_11512 {
	
	    public static void main(String[] args) throws FileNotFoundException {
	    	Scanner scn = new Scanner(new File("D://new  6.txt"));
	    	PrintWriter pw = new PrintWriter(System.out);
	    	
	    	int size = Integer.parseInt(scn.nextLine());
	    	while(size-->0){
	    		int lcsIdx = 0;
		    	int lcslen = 0;
		    	int occur = 0;
		    	String ans = "";
	    		String str = scn.nextLine();
	    		init(str);
	    		buildSA();
	    		for(int i=0; i<sa.length-1;i++){
	    			int j = i+1;
	    			int idx1 = sa[i];
	    			int idx2 = sa[j];
	    			int locallen = 0;
	    			while(idx1<str.length() && idx2<str.length() && str.charAt(idx1++) == str.charAt(idx2++)){
	    				 locallen++;
	    			}
	    			if(locallen >= lcslen && locallen >0) {
	    				String temp = str.substring(sa[i], sa[i]+ locallen);
	    				if(locallen == lcslen ){
	    					if(temp.equals(ans))
	    					occur++;
	    				}else{
	    					occur = 2;
	    				lcslen = locallen;
	    				ans = temp;
	    				}
	    			}

	    		}
	    		if(lcslen ==0){
	    			pw.println("No repetitions found!");
	    		}else
	    			pw.println(ans+" "+occur);
	    	}
	    	 pw.close();
		}
	    
		static String str = "aaabaaaaaabaa";
		static int[] sa =new int[str.length()];
		static int[] rank=new int[str.length()];;
		static int[] temp=new int[str.length()];;
		static int gap=0;
		static int n=0;
		static void init(String astr){
			str = astr;
			sa =new int[str.length()];
			rank=new int[str.length()];;
			temp=new int[str.length()];;
			gap=0;
			n=0;
		}
		
		static void buildSA(){
			n = str.length();
			for(int i=0; i<n; i++){
				sa[i] = i;
				rank[i] = str.charAt(i);
			}
			
			for(gap=-1; (1<<gap)<n; gap++){
				temp = new int[n];
				sort(sa, 0, n-1);
				int cnt = 0;
				for(int i=0 ; i<n; i++){
					if(i>0 && comprator(sa[i-1], sa[i])>0)cnt++;
					temp[sa[i]] = cnt;
				}
				if(cnt==n-1)break;
				rank = temp;
			}
			//System.out.println(Arrays.toString(sa));
		}
		//quick sort
		static void sort(int [] arr, int st, int end){
			if(st<end){
				int x = findIdx(arr, st, end);
				sort(arr, st, x-1);
				sort(arr, x+1, end);				
			}
			
		}
		
		static void swap(int[] arr, int i, int j){
			int tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
		}
		static int findIdx(int[] arr, int st, int end){
			int val = arr[end];
			int idx = st-1;
			for(int i=st; i<end; i++){
				if(comprator(arr[i],val)==1){
					swap(arr, ++idx, i);
				}
			}
			swap(arr, ++idx, end);
			return idx;
		}
		
		static int comprator(int i, int j){
			if(gap ==-1 || rank[i] !=rank[j]){
				return (rank[i] < rank[j]) ? 1: 0;
			}
			i+=(1<<gap);
			j+=(1<<gap);
			if(i >n-1 || j > n-1){
				return (i<j)?0:1 ;
			}
			return ((rank[i] < rank[j]) ? 1 : 0);
		}
		
	}
	



