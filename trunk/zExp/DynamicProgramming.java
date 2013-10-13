
public class DynamicProgramming {
	
	public static void main(String[] args) {
		System.out.println(optimumCutBF(10));
		System.out.println(isSubSetSum(new int[]{1,4,2,5,6},5, 3 ));
		System.out.println(chechPalinBF("elephant"));
		System.out.println(checkPalinDP("abaacdeffedcbab"));
		System.out.println(getLCS("xxaybccdx", "yaxcbxdm"));
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
	//get all possible substring, (two outer loops); check if substrings are palindrome (inner loop)
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
	
	//DP approach, Palin(i,j) = str(i) == str(j) && Palin(i+1, j-1) ==> if aba is palin then pabaq is also a palin if p = q
	//Lets make a boolean table starting index and ending index as axis; enter true when palin
	//base cases need to be prepopulated, those are string of length 1 and 2, then compute others on bottom up manner
	 public static String checkPalinDP(String str){
		 int palinLength = 0;
		 String palin=null;
		 int len = str.length();
		 boolean[][] isPalinTable = new boolean[len][len];
		 //Populate base case, len 1 and len 2  aba odd, abba even for base case 1 and 2 respectively
		 for(int i=0;i<len; i++ ){
			 isPalinTable[i][i] = true;
		 }
		 for(int i=0; i<len-1; i++){
			 isPalinTable[i][i+1] = true;
		 }
		 //Lets write it in bottom up manner
		 for(int l=3;l<= len; l++ ){
			 for(int i=0; i<(len-l); i++){
				 if(str.charAt(i) == str.charAt(i+l-1) && isPalinTable[i+1][i+l-2]){
					 isPalinTable[i][i+l-1] = true;
					 if(l > palinLength){
						 palinLength = l;
						 palin = str.substring(i, i+l);
					 }
				 }
			 }
		 }
		 System.out.println("Palin length "+palinLength + " :: "+palin);
		 return palin;
	 }
	
	//Q: LCS, longest common subsequence  abc is subsequence of xayybc
	public static int getLCS(String str1, String str2){
		int max =0 ;
		if(str1.length() == 0 || str2.length() ==0){
			return 0; 
		}
		int i= str1.length()-1;
		int j = str2.length()-1;
        if(str1.charAt(i) == str2.charAt(j)){
        	max = getLCS(str1.substring(0,i), str2.substring(0,j)) + 1;
        }else{
        	max = greater(getLCS(str1.substring(0,i), str2), getLCS(str1, str2.substring(0,j)));
        }
        return max;
	}
	 
	public static int greater(int i, int j){
		return i>j?i:j;
	}
	
	
	
}
