package uva;

import java.util.Scanner;

public class Grpah_OilDepo_572 {
	//do DFS or BFS to find no of connected components on matrix representation of graph
	
	static char[][] graph;
	static boolean[][] isSeen;
	static int components ;
	static int rows, col;
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		while((rows = scn.nextInt())!=0){
			col = scn.nextInt();
			graph = new char[rows][col];
			isSeen = new boolean[rows][col];
			components = 0;
			for(int i=0; i<rows; i++){
					graph[i] = scn.nextLine().toCharArray();
			}
			
			//traverse
			for(int i=0; i<rows; i++){
				for(int j=0; j<col; j++){
					if(graph[i][j] == '@' && !isSeen[i][j]){
						DFS(i, j);
						++components;
					}
				}
			}
			System.out.println("Comp "+components);
		}
		
		
	}
	
	static void DFS(int i, int j){
		isSeen[i][j] = true;
		for(int x=i-1; x<=i+1; i++){
			for(int y=j-1; y<=j+1; j++ ){
				if(inRange(x, y) && !isSeen[x][y]){
					DFS(x,y);
				}
			}
		}
		
	}
	
	static boolean inRange(int x, int y){
		if(0<=x && x<rows && 0<=y && y<col )return true;
		return false;
	}
	
	

}
