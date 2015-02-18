package uva;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 
 * @author shivendra
 * backtracking
 *
 */
public class Sudoku_989 {
	
	static int[][] sudoku;
	static boolean[][] fixed;
	static int dim;
	static int size;
	static boolean solved;
	public static void main(String[] args) throws Exception {
		PrintWriter pw = new PrintWriter(System.out);
		Scanner scn = new Scanner(new File("D:\\new  3.txt"));
		while(scn.hasNextLine()){
			String str = scn.nextLine();
			if(str.length() ==0)continue;
			dim = Integer.parseInt(str);
			size = dim*dim;
			sudoku = new int[size][size];
			fixed = new boolean[size][size];
			solved = false;
			for(int i=0; i<size; i++){
				for(int j=0; j<size; j++){
					sudoku[i][j] = scn.nextInt();
					fixed[i][j] = sudoku[i][j]!=0? true : false;
				}
			}
			solver(0,0);
			//print soln
			if(solved){
				for(int i=0; i<size; i++){
					for(int j=0; j<size; j++){
						pw.print(sudoku[i][j] + " ");
					}
					pw.println();
				}}else{
					pw.println("NO SOLUTION");
				}
			pw.println();
		}
		pw.close();

	}
    static void solver(int i, int j){
    	if (fixed[i][j]) {
    		if(setSolved(i,j))return;
    		if(j<size-1)
    			solver(i, j+1);
    		else if(i<size-1){
    			solver(i+1, 0);
    		}
    	}else{
    		for(int k=1;k<=size&& !solved ; k++ ){
    			if(isValid(i, j, k)){
    				sudoku[i][j] = k;
    				if(setSolved(i, j))return;
    				if(j<size-1)
    	    			solver(i, j+1);
    	    		else if(i<size-1){
    	    			solver(i+1, 0);
    	    		}

    			}
    		}
    		//reset
    		if(!solved) sudoku[i][j] = 0;
    	}
    }
    
    static boolean setSolved(int i, int j){
    	if(i ==size-1 && j==size-1){
    		solved = true;
    	}
    	return solved;
    }
	
	static boolean isValid(int i, int j, int val){
		if(val == 0) return false;
		for(int k=0;k<size;k++ ){
			if(sudoku[i][k] == val)return false;
		}
		for(int k=0; k<size; k++){
			if(sudoku[k][j]==val)return false;
		}
		int x = i/dim * dim;
		int limx = x +dim;
		for(;x<limx;x++){
			int y = j/dim * dim;
			int limy = y+dim;
			for(;y<limy; y++){
				if(sudoku[x][y] == val)return false;
			}
		}
		
		return true;
	}
}
