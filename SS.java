import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class SS {
	static int[] arr;
	public static void main(String[] args) {
		    arr = new int[]{111,12,15,33,52,46,78,59,68,32,23,11,9,1234};
			RS();
		    //new SS().ms(arr);
			System.out.println(Arrays.toString(arr));
			BS(9,0,arr.length-1);
		
	}
	public void ss(int[] arr){
		for(int i=0; i<arr.length; i++){
			for(int j=i+1; j<arr.length; j++){
				if(isGreater(i,j)){
					swap(i,j);
				}
			}
		}
	}
	public void ms(int[] arr){
		int end = arr.length-1;
		merge(0,end, arr);
	}
	public void merge(int start,int end, int[] sorted){
		int len = end-start +1;
		if(start==end){
			return;
		}
		int[] aux = new int[len];
		int j =0;
		for(int i=start; i<=end; i++){
			aux[j++] = sorted[i];
		}
		int mid = len/2-1;
		merge(0,mid, aux);
		merge(mid+1, len-1, aux);
		int idx1 = 0;
		int idx2 = mid+1;
		for(int i=start; i<=end; i++){
			if(idx1>mid)sorted[i] = aux[idx2++];
			else if(idx2==len)sorted[i] =aux[idx1++];
			else if(aux[idx1]>aux[idx2]) sorted[i]=aux[idx2++];
			else sorted[i] = aux[idx1++];
		}
	}
	public static void BS(int findMe,int start, int end){
		int mid = (start+end)/2;
		if(findMe == arr[mid]){
			System.out.println("Index of "+findMe+ " is "+mid);
		}else if(start >= end){
			System.out.println("Not Found");
			return;
		}else if(findMe>arr[mid]){
			BS(findMe, mid+1, end);
		}else if(findMe < arr[mid]){
			BS(findMe, start, mid-1);
		}
	}
	
	public static void RS(){
		List<List<Integer>> buckets = new ArrayList<List<Integer>>(10);
		int j=0;
		for(j=0; j<10; j++){
			buckets.add(new ArrayList<Integer>());
		}
		for(j=1; ; j++){
			for(int i=0; i<arr.length; i++){
				int bucketNo = getBucketNo(arr[i], j);
				(buckets.get(bucketNo)).add(arr[i]);
			}
			if(buckets.get(0).size() == arr.length)
				break;
			//lets dequeue
			int idx =0;
			for(List<Integer> li: buckets){
				if(li!=null){
					Iterator<Integer> itr = li.listIterator();
					while(itr.hasNext()){
						arr[idx++] = itr.next();
						itr.remove();
					}
				}
			}		
		}
	}
	
	static int getBucketNo(int number, int pos){
		return (int) (number/Math.pow(10, pos-1))%10;
	}
	
	public void is(int[] arr){
		for(int i=0; i<arr.length; i++){
			for(int j=i;j>0 && !isGreater(j, j-1);j--){
				swap(j,j-1);
			}
		}
	}
	public void swap(int x, int y){
		int temp = arr[y];
		arr[y] = arr[x]; arr[x]=temp;
	}
	public boolean isGreater(int x, int y){
		if(arr[x]>arr[y]) return true;
		return false;
	}
	
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
