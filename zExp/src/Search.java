
public class Search {

	
	public int BS_NoRecur(int[] arr, int findMe){
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
}
