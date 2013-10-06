
public class Search {

	public static void main(String[] args) {
		int[] arr = new int[]{1,5,9,13,14,25,60};
		System.out.println(BS_NoRecur(arr, 2)+"");
		arr = new int[]{1,-1,2,3,-1,2};
		System.out.println(BS_RotatedSortedArray(arr, 14));
		System.out.println(BS_RotatedFindMin(arr));
		System.out.println(maxContiSubArray(arr, 0, arr.length-1));
		int occ=0, winner = 0;
		arr = new int[]{1,1};
		int[] winnerFre = new int[2];
		majorityElement(arr, 0, arr.length-1, winnerFre);
		System.out.println("Occu " +occ + " Winner "+winner );
	}
	public static int BS_NoRecur(int[] arr, int findMe){
		int start = 0; 
		int end = arr.length -1;
		while(start <= end){
			int mid = (start + end)/2;
			if(findMe == arr[mid]){
				return mid;
			}
			if(findMe > arr[mid]) start = mid + 1;
			else end = mid -1;
		}
		return -1; 
	}
	
	public static int BS_RotatedSortedArray(int [] arr, int findMe){
		int start = 0;
		int end = arr.length -1;
		while(start <= end){
			int mid = (start + end)/2;
			if(findMe == arr[mid]) return mid;
			if((findMe > arr [mid] && findMe > arr[start]) || (findMe < arr[mid]) && findMe <= arr[end] ) start = mid+1;
			else end = mid -1;
		}
		return -1;
	}
	
	//Q::Find min in rotated arr
	//If array is rotated till mid then only min could be found in mid+1 segment, other conditions goes to else
	public static int BS_RotatedFindMin(int [] arr){
		int start = 0;
		int end = arr.length -1;
		int min = 0;
		while(start <= end){
			int mid = (start + end)/2;
			if(arr[start]>= arr[end] && arr[mid] >= arr[end]){
				min = mid;
				start = mid +1;
			}else{
				min = mid;
				end = mid -1;
			}
		}
		return arr[min];
	}
	//::End
	
	//Q::Find max contiguous sub array
	public static int maxContiSubArray(int [] arr, int start, int end){
		if(start >= end)return arr[start];
		int mid = (start + end)/2;
		int max=0;
		int fHalf = maxContiSubArray(arr, start, mid);
		int sHalf = maxContiSubArray(arr, mid+1, end);
		int cMid = MaxInMidCrossing(arr, start, mid, end);
		if(fHalf >= sHalf && fHalf >= cMid) max = fHalf;
		if(sHalf >= cMid && sHalf >= fHalf) max = sHalf;
		if(cMid >= sHalf && cMid >= fHalf) max = cMid;
		return max;
	}
	
	public static int MaxInMidCrossing(int[] arr, int start, int mid, int end){
		int max =0, leftSum =0, rightSum =0 , sum = 0;
		for(int i=mid; i>=start; i--){
			sum = sum + arr[i];
			if(leftSum < sum ) leftSum = sum;
		}
		sum =0;
		for(int i= mid+1; i<=end; i++){
			sum = sum + arr[i];
			if(rightSum < sum)rightSum = sum;
		}
		max = rightSum + leftSum;
		return max;
	}
	//::End
	
	//Q::Majority element in sorted array
	public static void majorityElement(int[] arr, int start, int end, int[] winnerFre ){
		if(start >=end){
			winnerFre[1] = 1;
			winnerFre[0] = arr[start];
			return; 
		}
		int maj =0;
		int mid = (start + end)/2;
		int oc1 =0, oc2 =0, oc3=0, w1 =0, w2 = 0, w3 = 0;
		/*majorityElement(arr, start, mid, oc1, w1);
		majorityElement(arr, mid+1, end, oc2, w2);
		crossMidPoint(arr, start, mid, end, oc3, w3);
		
		if(oc1 >= oc2 && oc1 >=oc3){
			if(w1 == w2)
				occurence = oc1+oc2;
			if(w1 == w3)
				occurence = occurence+oc3;
			winner = w1;
		}
		if(oc2 >= oc3 && oc2 >=oc1){
			if(w2 == w3)
				occurence = oc2+oc3;
			if(w2 == w1)
				occurence = occurence+oc1;
			winner = w2;
		}
		if(oc3 >= oc2 && oc3 >=oc1){
			if(w3 == w2)
				occurence = oc3+oc2;
			if(w3 == w1)
				occurence = occurence+oc1;
			winner = w3;
		}*/
		
	}
	
	public static void crossMidPoint(int[] arr, int start, int mid, int end, int occ, int winner){
		
		for(int i=mid; i>=0 && arr[i]== arr[mid]; i--){
			occ++;
		}
		for(int i=mid+1; i<= end && arr[i]==arr[mid]; i++){
			occ++;
		}
		if(occ>0)winner = arr[mid];
		
	}
	
	//Q: no of occurence in sorted array
	
}
