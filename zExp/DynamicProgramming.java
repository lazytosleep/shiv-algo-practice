
public class DynamicProgramming {
	
	public static void main(String[] args) {
		System.out.println(optimumCutBF(8));
		System.out.println(isSubSetSum(new int[]{1,4,2,5,6},5, 3 ));
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
	
 	//Q2:Sub set sum SubSetSum(set, n, sum) = SubSetSum(set, n-1, sum) || SubSetSum(set, n-1, sum-set(n-1))
	//While we move from one end to other element is either part of subset or not
	public static boolean isSubSetSum(int[] arr, int n, int sum){
		if(sum == 0)return true;
		if(n == 0)return false;
		return isSubSetSum(arr, n-1, sum) || isSubSetSum(arr, n-1, sum-arr[n-1]);
	}
	
	
}
