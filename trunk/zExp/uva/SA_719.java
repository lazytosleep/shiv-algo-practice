package uva;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class SA_719 {
	
	    public static void main(String[] args) {
	    	Scanner scn = new Scanner(System.in);
	    	PrintWriter pw = new PrintWriter(System.out);
	    	int size = Integer.parseInt(scn.nextLine());
	    	while(size-->0){
	    		String temp = scn.nextLine();
	    		int len = temp.length();
	    		String str =  temp.concat(temp);
	    		init(str);
	    		buildSA();
	    		for(int i=0; i<str.length();i++){
	    			if(sa[i] <len){
	    				pw.println(sa[i] +1);
	    				break;
	    			}
	    		}
	    		
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
	



