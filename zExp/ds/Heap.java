package ds;

import java.util.Arrays;

public class Heap {
	int[] heap = null;
	int length  = 0;
	Heap(int [] heap){
		this.heap = heap;
		length = heap.length;
	}
	
	void heapSort(){
		buildMaxHeap();
		for(int len = length ;len>1;){
			exchange(0,len-1);
			maxHeapify(0,--len);
		}
	}
	
	void exchange(int i, int j){
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}
	
	//assumes left and right sub heap are correct but current idx may not confirm to max heap
	void maxHeapify(int idx, int length){
		int oneIdx=idx+1;
		int max = heap[idx], maxID  = idx;
		if(2*oneIdx <=length && max < heap[2*oneIdx -1]){
			max = heap[2*oneIdx-1];
			maxID = 2 *oneIdx-1;
		}
		if((2*oneIdx + 1)<=length && heap[2*oneIdx] > max){
			max = heap[2*oneIdx];
			maxID = 2 *oneIdx;
		}
		if(maxID !=idx){
			heap[maxID] = heap[idx];
			heap[idx] = max;
			maxHeapify(maxID, length);
		}
	}
	
	void buildMaxHeap(){
		for(int i=heap.length/2; i>=0;i--){
			maxHeapify(i, heap.length);
		}
	}
	
	public static void main(String[] args) {
		Heap heap = new Heap(new int[]{4,5,13,1,8,22,2,15,3,17,11});
		heap.heapSort();
		System.out.println(Arrays.toString(heap.heap));
	}

}
