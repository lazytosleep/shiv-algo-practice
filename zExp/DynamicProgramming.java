
public class DynamicProgramming {
	
	public static void main(String[] args) {
		System.out.println(optimumCutBF(8));
		System.out.println(isSubSetSum(new int[]{1,4,2,5,6},5, 3 ));
		System.out.println(chechPalinBF("ababcdabbadcaaa"));
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
	
	//Q3 : Longest palindrome sub string
	//fix at beginning and reduce from end, run inner loop between
	public static String chechPalinBF(String str){
		int start =0 , end = 0;
		for(int i=0; i< str.length(); i++){
			int j=0;
			for(j= (str.length()-1); j>i;j--){
                int k=i,l=j;
				for(k=i; k<l;l--,k++){
					if(str.charAt(k)!= str.charAt(l)){
                		break;
                	}
                }
				if(k>=l) break;
			}
			if(j >i  && (j-i) > (end -start) ){
				start = i; end = j;
			}
		}
		if((end -start) >0) return str.substring(start, end +1);
		return null;
	}
	
}
