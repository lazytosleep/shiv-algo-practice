package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BallGame {


	int arr[] = null;

	int max = 0;
	int loopMax = 0;
	int inc = -1;

	void solve(int x){

		for(int i=0; i<arr.length;i++){
			if(findColour(i) == x && findColour(i +1) == x ){
				loopMax = 0;
				//loopMax+=3;
				findMax(i, i+1,true);
				if(loopMax >max)
					max = loopMax;
				while(findColour(i)==x)i++;
				i--;
			}
		}

		System.out.println(max==0?0:max-1);
	}

	void findMax(int left, int right, boolean firstCall){

		int leftMax = 0;
		int rightMax = 0;
		if(findColour(left) == findColour(right)){
			leftMax+=2;
			left = left-1;
			right = right +1;
		}


		while(findColour(left) == findColour(left+1)){
			leftMax +=1; 
			left = left-1;
		}

		while(findColour(right) == findColour(right-1)){
			rightMax +=1; 
			right = right +1;
		}
		int localMax = leftMax + rightMax;
		if(firstCall)localMax +=1;
		if(localMax >=3 ){
			loopMax += localMax; 
			findMax(left, right, false);
		}

	}

	int findColour(int idx){
		if(idx>=0 && idx < arr.length)
			return arr[idx];
		else return inc--;	           
	}

	void init(int n){

	}

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		int arrSize = reader.nextInt();
		int noOfColours = reader.nextInt();
		int thisCol = reader.nextInt();
		BallGame bg = new BallGame();
		bg.arr = new int[arrSize];
		for(int i=0; i<arrSize; i++){
			bg.arr[i] = reader.nextInt();
		}
		bg.solve(thisCol);

	}


	static class InputReader {
		private BufferedReader reader;
		private StringTokenizer stt;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public String nextLine() {
			try {
				return reader.readLine().trim();
			} catch (IOException e) {
				return null;
			}
		}

		public String nextString() {
			while (stt == null || !stt.hasMoreTokens()) {
				stt = new StringTokenizer(nextLine());
			}
			return stt.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(nextString());
		}

	}

}
