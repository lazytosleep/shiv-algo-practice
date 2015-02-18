package spoj;

import java.io.PrintWriter;
import java.util.Scanner;

public class BRCKTS {
	
	int[] segTree;
	int[] arr;
	
	void update(int val, int idx, int node, int rStart, int rEnd){
		 
	}
	
	void init(int segTreeSize){
		segTree  = new int[segTreeSize];
		buildTree(0, 0, arr.length-1);
	}
	
	int buildTree(int node, int start, int end){
		if(start == end){
			segTree[node] = arr[start];
			return arr[start];
		}
		int mid = (start+end)/2;
		int sum  = buildTree(2*node+1, start, mid) + buildTree(2* node +2, mid+1, end);
		segTree[node] = sum;
		return sum;
	}
	
	void updateFromLeaf(int node){
		
		segTree[node] = -segTree[node];
		if(node >0){
		
		int parentNode = node/2;
		
		updateFromLeaf(parentNode);
		}
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		BRCKTS bs = new BRCKTS();
		PrintWriter pw = new PrintWriter(System.out);
		int elementsSize = scn.nextInt();
		bs.arr = new int[elementsSize];
		String str = scn.next();
		for(int i=0; i<str.length() ; i++){
			bs.arr[i] = str.charAt(i) ==40 ? 1 : -1;
		}
		int segTreeSize = (elementsSize -1) + elementsSize;
		bs.init(segTreeSize);
		int queries = scn.nextInt();
		for(int i=0; i< queries; i++){
			int query = scn.nextInt();
			if(query == 0){
				pw.println(bs.segTree[0] == 0? "true" : "false");
			}else{
				//( = 50
				//int val = query==50 ? 1 : -1;
				
						bs.updateFromLeaf(elementsSize -1 + query - 1);
			}
		}
		pw.close();
			
	}

}
