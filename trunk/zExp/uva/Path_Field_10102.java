package uva;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Path_Field_10102 {
	
	static char[][] grid;
	static int max;
	public static void main(String[] args) {
		PrintWriter pw = new PrintWriter(System.out);
		InputReader scn = new InputReader(System.in);
		String str = null;
		while((str = scn.nextLine())!=null && str.length() >0){
		int size = Integer.parseInt(str);
		grid = new char[size][];
		max =0 ;
		for(int i=0; i<size; i++){
			grid[i] = scn.nextLine().toCharArray();
		}
		
		for(int i =0; i<size; i++){
			for(int j=0; j<size; j++){
				if(grid[i][j] == '1'){
					int locMin = Integer.MAX_VALUE;
					for(int x=0; x<size; x++){
						for(int y=0; y<size; y++){
							if(grid[x][y] == '3'){
								int loc = findDist(i, j, x, y);
								locMin = locMin<loc ? locMin : loc;
							}
						}
					}
					max = max>locMin ? max : locMin;
				}
			}
		}
		pw.println(max);
		}
		pw.close();
		
	}
	
	static int findDist(int srX, int srY, int tX, int tY){
		return Math.abs(srX-tX) + Math.abs(srY - tY);
	}
	
	static class InputReader {
	    private BufferedReader reader;
	    private StringTokenizer stt;
	 
	    public InputReader(InputStream stream) {
	        reader = new BufferedReader(new InputStreamReader(stream));
	    }
	 
	    public String nextLine() {
	        try {
	            return reader.readLine().trim();
	        } catch (Exception e) {
	            return null;
	        }
	    }
	 
	}
	
	

}
