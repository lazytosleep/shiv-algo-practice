
public class Search {

	public static void main(String[] args) {
		int[] arr = new int[]{1,5,9,13,14,25,60};
		System.out.println(BS_NoRecur(arr, 2)+"");
		arr = new int[]{2,5,9,13,14,14,1,2};
		System.out.println(BS_RotatedSortedArray(arr, 14));
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
	
	
}
