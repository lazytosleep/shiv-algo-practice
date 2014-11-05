package coreJava.misc;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class MiscThreading {

}

//Web server running request in thread taken from pool
class WebServer{
	
	Executor pool = Executors.newFixedThreadPool(100);
	
	void serve() throws Exception{
		ServerSocket ss = new ServerSocket(80);
		//TODO shutdown check
		while(true){
			Socket socket = ss.accept();
			Runnable task = new Runnable(){
				@Override
				public void run() {
					//handle request on socket
				}
			};
			pool.execute(task);
		}
	}
}

//create blocked map using syncronizers

class BloackingSyncedMap{
	
	Semaphore sp = new Semaphore(100);
	Set<String> set = Collections.synchronizedSet(new HashSet());
	
	public void add(String str){
		try {
			sp.acquire();
		} catch (InterruptedException ignoreit) {
		}
		set.add(str);
	}
	
	public void remove(String str){
		set.remove(str);
		sp.release();
	}
	
}

//Write micro benachmark without using iteration,rather than doing iteration just run number of threads

class Microbenchmark{
	
	CountDownLatch startLatch = new CountDownLatch(1);
	CountDownLatch endLatch = new CountDownLatch(100);
	
	void profile(final Runnable task) throws InterruptedException{
		
		for(int i=0; i<100; i++){
			Runnable run = new Runnable(){
				@Override
				public void run() {
					try {
						startLatch.await();
					} catch (InterruptedException e) {
						
					}
					task.run();
					endLatch.countDown();
				}
			};
			Thread th = new Thread(run);
			th.start();
			startLatch.countDown();
			endLatch.await();
			
			
		}
		
		
	}
	
}



//returning a result from task running on different thread
