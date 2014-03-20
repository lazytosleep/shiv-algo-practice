package CF;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class TreePropogation {
    List<Integer> node[];
	int[] val = null;
	boolean[] isVisited;
	List<Integer> disc = new ArrayList();
	List<Integer> end = new ArrayList();
	List<Integer> start = new ArrayList();
	int[] AIB = new int[400002]; 
	
	
	public void update(int pos, int val){
		for(;pos<=40000; pos = (pos + (pos & -pos))){
			AIB[pos] = AIB[pos]+val;
		}
	}
	
	public int query(int pos)
	{
	    int sum = 0;
	    for (; pos >= 1; pos -= pos & -pos)
	        sum += AIB[pos];
	    return sum;
	}
	
	void DFS(int vtx){
		isVisited = new boolean[node.length];
		disc.add(vtx);
		Stack<Integer> st = new Stack();
		 st.add(vtx);
		 while(!st.empty()){
			 int currVtx = st.pop();
			 start.add(currVtx);
			 isVisited[vtx] = true;
			 List<Integer> nodeList = node[currVtx];
			 for(Integer curr: nodeList){
				 if(isVisited[curr] == false)
					 disc.add(curr);
					 st.add(curr);
			 }
			 end.add(currVtx);
		 }
		
	}
	
	public static void main(String[] args) {
		List<Integer> res = new ArrayList();
		Scanner scn = new Scanner(System.in);
		int m = scn.nextInt(), n = scn.nextInt();
		TreePropogation tp = new TreePropogation();
		tp.node = new ArrayList[n];
		//init
		for(int i=0; i<n; i++){
			tp.val[i] = scn.nextInt();
			tp.node[i] = new ArrayList();
		}
		for(int i=0; i<n-1; i++){
			int one = scn.nextInt();
			int other = scn.nextInt();
			tp.node[one].add(other);
			tp.node[other].add(one);
		}
		//ready for DFS...do a DFS
		tp.DFS(1);
		//lets do query
		for(int i=0, type; i<m;i++ ){
			type = scn.nextInt();
			if(type ==1){
				int node = scn.nextInt();
				int val = scn.nextInt();
				if(tp.disc.get(node)%2 == 0){
					tp.update(tp.start.get(node), val);
	                tp.update(tp.end.get(node), -val);
				}else{
					 tp.update(tp.end.get(node), -val);
		             tp.update(tp.start.get(node), val);
				}
			}else{
				int node = scn.nextInt();
				if (tp.disc.get(node)% 2 == 0)
	                res.add(tp.val[node] + tp.query(node));
	            else
	            	res.add(tp.val[node] + tp.query(node));
			}
		}
		for(Integer num: res){
			System.out.println(num);	
		}
		
	}
	
}
