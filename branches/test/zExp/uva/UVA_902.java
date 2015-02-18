package uva;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;


public class UVA_902 {
	

	public static void main(String[] args) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(System.out);
		Scanner scn = new Scanner(new File("D:\\new  6.txt"));
		while(scn.hasNextLine()){
			String x = scn.nextLine();
			if(x.length() ==0) continue;
			String[] arr = x.split("\\s");
			Map<String, Integer> map = new HashMap();
			int size = Integer.parseInt(arr[0]);
			String str = arr.length==1?scn.nextLine() : arr[1];
			for(int i=0; i<str.length()-size;i++){
				String temp = str.substring(i, i+size);
				if(map.get(temp)==null){
					map.put(temp, 1);
				}else{
					map.put(temp, map.get(temp)+1);
				}
			}
			String max = "";
			int fre = 1;
			for(Entry<String, Integer> e:map.entrySet()){
				if(e.getValue() >fre){
					fre = e.getValue();
					max= e.getKey();
				}
			}
			pw.println(max);
		}
		pw.close();
		
	}
		
	}
	



