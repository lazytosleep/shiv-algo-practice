import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 *Backtracking is a refinement of the brute force approach, which systematically searches for a solution to a problem among all available options.
  It does so by assuming that the solutions are represented by vectors (v1, ..., vm) of values and by traversing, in a depth first manner, 
  the domains of the vectors until the solutions are found.
*/
public class BackTracking {
	public static void main(String[] args) {
		//Q1
		int[][] sudoku = 
		{{3,0,6, 5,0,8, 4,0,0},
		 {5,2,0, 0,0,0, 0,0,0},
		 {0,8,7, 0,0,0, 0,3,1},
		 
		 {0,0,3, 0,1,0, 0,8,0},
		 {9,0,0, 8,6,3, 0,0,5},
		 {0,5,0, 0,9,0, 6,0,0},
		 	
		 {1,3,0, 0,0,0, 2,5,0},
		 {0,0,0, 0,0,0, 0,7,4},
		 {0,0,5, 2,0,6, 3,0,0}};
		solveSudoku(sudoku, 0,0);
		printSudoku(sudoku);
		
	}
	
	
	//Q1: Solve sudoku 
	public static boolean solveSudoku(int[][] arr, int row, int col){
		if(row > 8)return true;
		if(col>8) return solveSudoku(arr, ++row, 0);
		if(arr[row][col] !=0 ){
			return solveSudoku(arr, row, col+1 );
		}
		for(int j=1; j<=9 ; j++){
			if(isValid(arr, row, col, j)){
				arr[row][col] = j;
				if(solveSudoku(arr, row, col+1 )){ //back track and try new value if earlier fails, just go one step back non start form the beginning, starting from beginning would 
					return true;                   //be true brute force
				}
				arr[row][col] = 0;
			}
		}
		return false;
	}
	
	public static boolean isValid(int[][] arr,int row, int col, int x){
		for(int i=0; i<9; i++){
			if(arr[row][i] == x) return false;
			if(arr[i][col] == x) return false;
		}
		int startRow = row -row%3;
		int startCol = col -col%3;
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				if(arr[startRow +i][startCol +j] == x) return false;
			}
		}
		return true;
	}
    
	public static void printSudoku(int[][] arr){
		for(int i=0; i<9; i++){
			System.out.println();
			for(int j=0; j<9; j++){
				System.out.print(arr[i][j]+"\t");
			}
		}
	}
	
	//:End
	
	//Q2: Print subsets, given weight, target, subset
	
	public static boolean getSubSet(int[] arr,int size, int target, List<Set<Integer>> subList){
		Set<Integer> set = subList.get(subList.size() -1);
		if(set.size() == size) return true;
		for(int i=0; i<arr.length; i++){
			if(isValid(set, arr[i], target, size)){
	           if(set.size() == (size-1)){
	        	//   subList.add();
	           }
	           if(getSubSet(arr, size, target, subList)){
	        	   
	           }
	           
			}
			
		}
		return false;
	}
	
	public static boolean isValid(Set<Integer> set, int x, int target, int size){
        int sum= 0;
        for(Integer val : set){
        	sum = sum+val;
        }
		sum = sum+x;
		if((sum) >target  || ((set.size()+1 == size) && sum !=target) ) return false;
		return true;
	}
	
	//Q2: Combination no repetition
	
	//Q3: Combination repetition allowed
	
	
	
	
}
