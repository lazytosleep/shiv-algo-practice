package uva;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;


public class UVA_10252 {
	

	public static void main(String[] args) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(System.out);
		Scanner scn = new Scanner(new File("D:\\new  6.txt"));
		while(scn.hasNextLine()){
			String x = scn.nextLine();
			
			String y = scn.nextLine();
			//if(x.length()==0 || y.length()==0)continue;
			char[] arrx = x.toCharArray();
			char[] arry = y.toCharArray();
			Arrays.sort(arrx);
			Arrays.sort(arry);
			StringBuffer sb = new StringBuffer();
			for(int i=0, l=0; i<arrx.length;){
				int j=l;
				int k = i;
				while(j<arry.length && arrx[i]!=arry[j]){
					j++;
				}
				while(k<arrx.length && j <arry.length && arrx[k] == arry[j]){
					sb.append(arry[j]);
					k++; j++; l=j;
				}
				if(k==i)i++;
				else i=k;
				
			}
			pw.println(sb.toString());
			
			
		}
		pw.close();
		
	}
		
	}
	



