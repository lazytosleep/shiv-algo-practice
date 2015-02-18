
public class Recursion {
	public static void main(String[] args) {
		System.out.println(reverse("ABCDEF"));
		
	}
	
	//String reverse with recursion
	public static String reverse(String str){
		if(str.length() <= 1) return str;
		int mid = (str.length()/2)-1;
        return reverse(str.substring(mid+1, str.length())) + reverse(str.substring(0,mid+1));		
	}
	

}
