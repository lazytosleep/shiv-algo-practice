package coreJava.misc;

import java.util.LinkedList;
import java.util.Queue;

public class ThreadPool {
	
	int poolSize;
	Queue workQueue;
	Worker[] worker;
	
	public ThreadPool(int poolSize){
		this.poolSize = poolSize;
		workQueue = new LinkedList();
		worker = new Worker[poolSize];
		for(int i=0; i<poolSize; i++){
			worker[i] = new Worker();
			worker[i].start();
		}
	}
	
	public void addTask(Task task){
		synchronized (workQueue) {
		  workQueue.add(task);
		  workQueue.notifyAll();
		}
	}
	
	class Worker extends Thread{
		//Inside this run work would be acquired and executed
		@Override
		public void run() {
			Task task  = null;
			while(true){
				synchronized(workQueue){
					while(workQueue.isEmpty()){
						try {
							workQueue.wait();
						} catch (InterruptedException e) {

						}
					}
					task = (Task)workQueue.poll();
				}
				//tun the task
				task.workToDo();
			}
		}
	}
	//generally task implements runnable
	class Task{
		String work ;
		Task(String work){
			this.work = work;
		}
		public void workToDo(){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
			}
			System.out.println(Thread.currentThread().getName() + " :: "+work);
		}
	}
	
	public static void main(String[] args) {
		ThreadPool pool = new ThreadPool(5);
		for(int i=0; i<20; i++){
			ThreadPool.Task t = pool.new Task("task "+i);
			pool.addTask(t);
		}
		
	}

}
