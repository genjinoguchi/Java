import java.util.*;
import java.io.File;

public class Polly{
	private int day;
	ArrayList<PossibleLessonSequence>possible;
	String input, output;

	public String scanPolly(String filename){
		try{
			Scanner sc = new Scanner(new File(filename));
			int day = sc.nextInt();
			for(int x=0;x<day;x++){
				input = sc.nextLine();
				output = "";
				possible.clear();
				findPermutations(input);
				System.out.println(x);
				System.out.println(possible);
			}

			sc.close();
			return output;
		}catch(Exception e){
			System.out.println("File not found.");
			e.printStackTrace();
		}
		return "";
	}
	public  matchAndRemove(PossibleLessonSequence s, int sindex){//Count duplicates of s and add them to s.
		int total = 0;
		for(int x=sindex-1;x>=0;x--){
			if(possible.get(x).compareTo(s)==0){
				possible.remove(x);
				total++;
			}
		}


		
	}
	public void findPermutations(String s){
		//Only look for adjacent strings. Set length and starting point and look for multiples.
		for(int end = s.length();end>=0;end--){
			
		}
	}

	private class PossibleLessonSequence implements Comparable<PossibleLessonSequence>{
		private String lesson;
		private int occurrences = 1;

		public PossibleLessonSequence(String s){
			lesson = s;
		}
		public int compareTo(PossibleLessonSequence p){
			if(p.lesson.equals(lesson)){
				return 0;
			}else{
				return -1;
			}
		}

	}


}