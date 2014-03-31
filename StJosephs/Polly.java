import java.util.*;
import java.io.File;

public class Polly{
	private int day;

	public static String scanPolly(String filename){
		try{
			Scanner sc = new Scanner(new File(filename)).useDelimiter("\n");
			int day = sc.nextInt();
			String input = "",output = "";
			while(sc.hasNext()){
				input = sc.next();
				output += findPermutations(input);
			}
			sc.close();
			return output;
		}catch(Exception e){
			System.out.println("File not found.");
			e.printStackTrace();
		}
		return "";
	}
	public static String findPermutations(String s){
		//Only look for adjacent strings. Set length and starting point and look for multiples.
		for(int length=1;length<=s.length()/2;length++){
			String s1 = s.substring(s.length()-length, s.length());
			String s2 = s.substring(s.length()-(2*length),s.length()-length);
			if(s1.equals(s2)){
				return s1 + " " + countPermutations(s,s1)+"\n";
			}
		}
		return "Polly had a bad day\n";
	}
	public static int countPermutations(String s, String s1){
		int total = 0;
		int length = s1.length();
		while(s.length()-(total+1)*length >= 0){
			String s2 = s.substring(s.length()-(total+1)*length,s.length()-(total)*length);
			if(s1.equals(s2)){
				total++;
			}else{
				break;
			}
		}
		return s.length()-(total)*length;
	}
	public static void main(String[] args) {
		System.out.println(scanPolly("PollyIn.txt"));
	}
}