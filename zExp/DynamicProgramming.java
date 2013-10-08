
public class DynamicProgramming {
	
	public static void main(String[] args) {
		System.out.println(optimumCutBF(8));
	}

	//Q1: cut the rope to maximize the product
	// for i=1-->n  max(n) = i * max (n-i); 
	public static int optimumCutBF(int n){
		int max =1;
		for(int i=1; i<=n; i++){  //provide the width
			int temp = (i * optimumCutBF(n-i)); //Depth first
			if(temp >max) max = temp;
		}
		return max;
	}
	
	//Optimized cut DP
	public static int optimizedCutDP(int n){
		int max =1;
		return max;
	}
	
}
