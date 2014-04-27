package ds;

import java.util.Arrays;

public class Heap {
	
	
	int[] heap = null;
	Heap(int [] heap){
		this.heap = heap;
	}
	
	void heapSort(){
		buildMaxHeap();
		for(int i= heap.length-1 ;i>2; i--){
			exchange(1,i);
			maxHeapify(1,i);
		}
	}
	
	void exchange(int i, int j){
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}
	
	//assumes left and right sub heap are correct but current idx may not confirm to max heap
	void maxHeapify(int idx, int length){
		int compIdx=0;
		int min = 0, minIdx  = idx;
		
		if(idx ==0){
			compIdx = 1;
		}else{
			compIdx = idx;
		}
		if(2*compIdx <length && heap[idx] < heap[2*compIdx]){
			min = heap[2*compIdx];
			minIdx = 2 *compIdx;
		}
		if((2*compIdx + 1)<length && heap[2*compIdx +1] > heap[idx]){
			min = heap[2*compIdx +1];
			minIdx = 2 *compIdx + 1;
		}
		if(minIdx !=idx){
			heap[minIdx] = heap[idx];
			heap[idx] = min;
			maxHeapify(minIdx, length);
		}
	}
	
	void buildMaxHeap(){
		for(int i=heap.length/2; i>=0;i--){
			maxHeapify(i, heap.length);
		}
	}
	
	public static void main(String[] args) {
		Heap heap = new Heap(new int[]{4,8,2,15,3,19,6});
		heap.heapSort();
		System.out.println(Arrays.toString(heap.heap));
	}

}
