
public class Test {
	
	boolean [][] board;
	
	void solve(){
		int level = board.length;
		if(level >0){
			for(int i=0; i<board.length; i++){
				if(isValid(leval, i)){
					solve();
				}
			}
			return;
		}
		
	}
	
	
	boolean isValid(int row, int col){
		boolean isValid;
		for(int i=0; i<board.length; i++){
			if(board[row][i] && i!=col){
				return false;
			}
		}
		for(int i=0, j=0; i<board.length; i++, j++ ){
			if(board[i][j] && (i!=row || j !=col) ){ 
				return false;
			}
		}
		for(int i=0, j=board.length-1; i<board.length; i++, j-- ){
			if(board[i][j] && (i!=row || j !=col) ){ 
				return false;
			}
		}
		return true;
	}

}
