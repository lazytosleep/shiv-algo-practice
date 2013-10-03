
public class Search {

	public static void main(String[] args) {
		int[] arr = new int[]{1,5,9,13,14,25,60};
		System.out.println(BS_NoRecur(arr, 2)+"");
		arr = new int[]{1,-1,2,3,-1,2};
		System.out.println(BS_RotatedSortedArray(arr, 14));
		System.out.println(BS_RotatedFindMin(arr));
		System.out.println(maxContiSubArray(arr, 0, arr.length-1));
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
		int max =0;
		int leftSum = 0;
		int rightSum = 0;
		int sum = 0;
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
	
}
