import java.util.Arrays;


public class DynamicProgramming {
	
	public static void main(String[] args) {
		System.out.println(optimumCutBF(13));
		System.out.println(optimizedCutDP(10, new int[10]));
		System.out.println(optimizedCutDP_BU(13));
		System.out.println(isSubSetSum(new int[]{1,4,2,5,6},5, 3 ));
		System.out.println(chechPalinBF("elephant"));
		System.out.println(checkPalinDP("abaacdeffedcbab"));
		System.out.println(getLCS("xxaybccdx", "yaxcbxdm"));
		System.out.println(getLCSDP("xxaybccdx", "yaxcbxdm"));
		System.out.println(getMinCoinsForASum(14, new int[]{1,2,3,5}));
		System.out.println(getMaxNonDecreasingSequence(new int[]{1,5,6,2,3,4}));
		System.out.println(maxNonConsecutiveSum(new int[]{7, 7, 7, 7, 7, 7, 7}));
		System.out.println(fillArray(new int[]{1,1,2,2,2,3,3,4,4}));
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
	
	//Optimized cut DP//memoized
	public static int optimizedCutDP(int n, int[] arr){
		int max =1;
		if(n==0) return 1;
		if(arr[n-1]>=max) return arr[n-1];
		for(int i=1; i<= n; i++){
			max= greater(max,i* optimizedCutDP(n-i, arr));
			arr[n-1] = max;
		}
		return max;
	}
	
	//Optimized cut DP-bottom up
	//j->
	public static int optimizedCutDP_BU(int n){
		int max=1;
		int[] optCut = new int [n+1];
		optCut[0] = 1;
		for(int i=1; i<=n ; i++){
			for(int j=1; j<=i; j++){
				max = greater(max, (j)*optCut[i-j]); //Notice, here recursive call is not needed as in memoization since we already calculate needed result for a particular calculation
			}                                        //Best way to understand it, draw a recursion tree(value of variables over recursion), and travel from bottom 
			optCut[i] = max;
		}
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
    //Solve it using DP, bottom up approach
	public static int getLCSDP(String str1, String str2){
		int [][] resultTable = new int[str1.length()+1][str2.length()+1];
		
		for(int i=0; i<=str1.length(); i++){
			for(int j=0; j<=str2.length(); j++){
				if(i==0 || j==0){
					resultTable[i][j] = 0;
					continue;
				}
				if(str1.charAt(i-1)==str2.charAt(j-1)){
					resultTable[i][j] = resultTable[i-1][j-1] + 1;
				}else{ 
					resultTable[i][j] = greater(resultTable[i-1][j], resultTable[i][j-1]);
				}
			}
		}
		return resultTable[str1.length()][str2.length()];
	}
	
	//Q : If Strings are interleaved 
	public static boolean isInterleaved(String str1, String str2, String comb){
		if(str1.length() ==0 && str2.length() ==0) return true;
		if(comb.length() == 0) return false;
		char combCh = comb.charAt(0);
		if((str1.length() >0 && combCh == str1.charAt(0)) || (str2.length() > 0 && combCh == str2.charAt(0))){
			return isInterleaved(str1.substring(1), str2, comb.substring(1)) || isInterleaved(str1, str2.substring(1), comb.substring(1)); 
		}else{
			return isInterleaved(str1.substring(1), str2, comb.substring(1));
		}
	}
	
	//Get sum with min coins 
	public static int getMinCoinsForASum(int sum, int[] coins){
		int noCoins = 0;
		int[] minCoin = new int[sum+1];
		minCoin[0] = 0;
		for(int i=1; i<=sum; i++){
			minCoin[i] = 999999; //infinite
		}
		for(int i=1; i<=sum; i++){ //First loop for transition form one state to another
			for(int j=0; j<coins.length; j++){//try all possible transition from higher to lower value
				if(coins[j] <= i && ((minCoin[i-coins[j]] + 1) < minCoin[i]) ){
					minCoin[i] = minCoin[i-coins[j]] + 1;
				}
			}
		}
		return minCoin[sum];
		
	}
	
	//longest non decreasing sequence
	public static int getMaxNonDecreasingSequence(int[] sequence){
		int seqLength = 0;
		int[] maxLength = new int[sequence.length];
		for(int i=0; i<maxLength.length; i++){
			maxLength[i] = 1;
		}
		for(int i=0; i<maxLength.length; i++){
			for(int j=0; j<i; j++){
				if(sequence[i] > sequence[j]){
					maxLength[i] = maxLength[j] +1;
					seqLength = maxLength[i] > seqLength ? maxLength[i] : seqLength;
				}
			}
		}
		return seqLength;
	}
	
	//Lonest ap
	public static int getMaxAP(int[] seq){
		
		
		return 6;
	}
	
	public static int maxNonConsecutiveSum(int[] arr){
		int max = 0;
		int[] maxSum = new int[arr.length];
		for(int i=0; i<arr.length; i++){
			maxSum[i] = arr[i];
		}
		for(int i=0; i< arr.length; i++){
			for(int j=i-2; j>0 && j>=i-3; j--){
				if(maxSum[i] < maxSum[j] + arr[i]){
					maxSum[i] = maxSum[j] + arr[i];
					max = maxSum[i] > max ? maxSum[i] : max;
				}
			}
		}
		return max;
	}
	
	//Fill the elements in array inplace of zero, in increasing order, elements should repeat atleast twice and at max 5 times
	//State change [0010000203]
	public static boolean fillArray(int[] arr){
		int i = 0;
		//boolean[]isSolvable = new booelan[arr.length];
		boolean solvable = true;
		int minLastState = 0; 
		int lastVal =0;
		int maxOccur = 5;
		int minOccur  = 2;
		for(; i<arr.length; i++){
			int nonZeroVal =0;
			int nonZeroIdx =0;
			if(arr[i]!=0){
				nonZeroIdx = i;
				nonZeroVal = arr[i];
			}else{
				if(i == arr.length -1 && lastVal ==0){
					nonZeroVal = arr.length/2;
					nonZeroIdx = arr.length-1;
				}else
				continue; 
			}
			
			if(lastVal == nonZeroVal){
				for(int idx=minLastState; idx<=nonZeroIdx; idx++, minLastState++){
					arr[minLastState] = nonZeroVal;
				}
				
			}else{
			for(int x=lastVal+1; x<=nonZeroVal; x++){
				
				int occurCount = 1;
				for(;(occurCount<=minOccur || (minLastState <= nonZeroIdx && occurCount<=maxOccur && x==nonZeroVal))&& (minLastState <arr.length) && (arr[minLastState] ==0 || arr[minLastState] == x); occurCount++, minLastState++){
					arr[minLastState] = x;
				}
				if(occurCount <3){
					solvable = false;
					break; 
				}
			}
			}
			if(minLastState > i){
				i = minLastState-1;
			}
			if(!solvable)break; 
			lastVal = nonZeroVal;
		}
		if(arr[arr.length -1] ==0){
			int noOfInts = arr.length - minLastState; 
			int itr = 1;
			if(arr.length - minLastState >= 2) lastVal ++;
			for(int x =minLastState; x<arr.length; x++ ){
				if(itr > 2 && arr.length-x >= 2){
					itr = 1;
					lastVal++;
				}
				arr[x] = lastVal;
				itr ++;
			}
		}
		if(!solvable)System.out.println(-1);
		else System.out.println(Arrays.toString(arr));
		return false;
	}
	
	
	//Utility functions 
	public static int greater(int i, int j){
		return i>=j?i:j;
	}
	
	
	
}
