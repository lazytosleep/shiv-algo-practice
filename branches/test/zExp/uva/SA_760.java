package uva;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SA_760 {
	
	    public static void main(String[] args) throws FileNotFoundException {
	    	Scanner scn = new Scanner(new File("D://new  6.txt"));
	    	PrintWriter pw = new PrintWriter(System.out);
	    	String x = null;
	    	
	    	
	    	while((x=scn.nextLine())!=null){
	    		int lcsIdx = 0;
		    	int lcslen = 0;
		    	Set<String> ansList = new LinkedHashSet();
		    
	    		String y = scn.hasNextLine()? scn.nextLine() : "";
	    		
	    		int lenx = x.length();
	    		int leny = y.length();
	    		String str = x+y;
	    		init(str);
	    		buildSA();
	    		for(int i=0; i<str.length()-1&& lenx>0 && leny>0;i++){
	    			int j = i+1;
	    			while((sa[i]<lenx && sa[j] < lenx) || (sa[i]>=lenx && sa[j] >= lenx)){
	    				if(++j>=str.length())break;
	    			}
	    			while(j<str.length() && ((sa[i]<lenx && sa[j] >= lenx) || (sa[i]>=lenx && sa[j] < lenx))){
	    				int idx1 = sa[i]<lenx?sa[i]:sa[j]; int idx2 = sa[j]>=lenx? sa[j]-lenx : sa[i]-lenx;
	    				int lcs = 0;
	    				int lcsi = idx1;
	    				while(idx1<lenx && idx2 < leny && x.charAt(idx1++) == y.charAt(idx2++)){
	    					lcs++;
	    				}
	    				if(lcs >= lcslen && lcs >0){
	    					lcslen = lcs;
	    					lcsIdx = lcsi;
	    					ansList.add(str.substring(lcsIdx, lcsIdx+lcslen));
	    				}
	    				j++;
	    			}

	    		}
	    		if(ansList.size() ==0){
	    			pw.println("No common sequence.");
	    		}else
	    		for(String str1:ansList )
	    		if(str1.length() == lcslen)
	    			pw.println(str1);
	    		
	    		if(!scn.hasNextLine())break;
	    		else{
	    			scn.nextLine();
	    			pw.println();
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
	



