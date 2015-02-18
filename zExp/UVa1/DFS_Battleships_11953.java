package uva;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;



/**
 * 
 * @author Shivendra
 * do a DFS or BFS to find connected components in grid
 *
 */
public class DFS_Battleships_11953 {
	
	static char[][] grid;
	static boolean[][] isSeen;
	static int cc;
	static int size;
	public static void main(String[] args) {
		PrintWriter pw = new PrintWriter(System.out);
		InputReader reader = new InputReader(System.in);
		int cases = reader.nextInt();
		int idx = 0;
		while(cases-- >0){
			size = reader.nextInt();
			grid = new char[size][size];
			isSeen = new boolean[size][size];
			cc =0;
			for(int i=0; i<size; i++){
				grid[i] = reader.nextString().toCharArray();
			}
			for(int i=0; i<size; i++){
				for(int j=0; j<size; j++){
					if(!isSeen[i][j] && isDesiredChar(i, j)){
						if(DFS(i,j))cc++;
					}
				}
			}
			pw.println(String.format("Case %d: %d",++idx, cc));
		}
		pw.close();
	}
	
	static boolean DFS(int i, int j){
		boolean alive = false;
		isSeen[i][j]  = true;
		if(grid[i][j] == 'x')alive = true;
		for(int x=i-1; x<=i+1; x++){
			for(int y=j-1; y<=j+1; y++){
				if(inRange(x, y) && isDesiredChar(x, y)&& !isSeen[x][y]){
					if(DFS(x,y)) alive = true;
				}
			}
		}
		return alive;
	}
	
	static boolean inRange(int i, int j){
		return 0<=i && i<size && 0<=j && j <size;
	}
	
	static boolean isDesiredChar(int i, int j){
		return (grid[i][j] == 'x' || grid[i][j] == '@');
	}
	
	static class InputReader {
	    private BufferedReader reader;
	    private StringTokenizer stt;
	 
	    public InputReader(InputStream stream) {
	        reader = new BufferedReader(new InputStreamReader(stream));
	    }
	 
	    public int nextInt(){
	    	try {
				return Integer.parseInt(reader.readLine().trim());
			} catch(Exception e) {
				return -1;
			}
	    }
	    
	    public String nextString(){
	    	try {
				return reader.readLine().trim();
			} catch(Exception e) {
				return null;
			}
	    }
	}

}
