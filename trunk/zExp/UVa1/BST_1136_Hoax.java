package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;

//Need a DS where insertion and deletion is equally fast and should be sorted...first two is
//met by hashmap but to ocmply with third use treemap
//And take care of duplicates
public class BST_1136_Hoax {
	
	
	public static void main(String[] args) {
		InputReader scn = new InputReader(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int nos = scn.nextInt();
		while(nos > 0){
			long cost =0;
			TreeMap<Long, List> tm = new TreeMap<Long, List>();
			for(int i=0; i<nos; i++){
				int bills = scn.nextInt();
				for(int j=0; j<bills; j++){
					int entry = scn.nextInt();
					List<Long> li = tm.get(new Long(entry));
					if(li == null)li = new ArrayList<Long>();
					li.add(new Long(entry));
					tm.put(new Long(entry), li);
				}
				List<Long> last = tm.lastEntry().getValue();
				List<Long> first = tm.firstEntry().getValue();
				cost += (last.remove(0)- first.remove(0));
				if(last.isEmpty()){
					tm.remove(tm.lastEntry().getKey());
				}
				if(first.isEmpty()){
					if(tm.firstEntry() !=null)
					tm.remove(tm.firstEntry().getKey());
				}
			}
			pw.println(cost);
			nos = scn.nextInt();
		}
		
		pw.close();
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
