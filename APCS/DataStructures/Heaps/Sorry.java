import java.util.ArrayList;
import java.util.Random;

public class Sorry{
	


	public static void test1(Random r, int size){
		RunningMedian rm = new RunningMedian();
		for(int x=0;x<size;x++){
			int randInt = r.nextInt(100);
			rm.add(randInt);
			System.out.print("added: "+randInt + ", median is: "+rm.median() + " ");
			System.out.print(rm);
		}
	}

	public static void test2(Random r, int size){
		RunningMedian rm = new RunningMedian();
		for(int x=0;x<size;x++){
			int randInt = r.nextInt(100);
			rm.add(randInt);
			System.out.print("added: "+randInt + ", median is: "+rm.median());
			System.out.print(" "+rm);
			if(r.nextInt(100)<20 && rm.size()>2){
				System.out.println();
				System.out.print("Removed median ");
				System.out.print(rm.remove());
				System.out.print(". ");
				System.out.print(rm);
				System.out.print(" new median is: ");
				System.out.print(rm.median());
			}
		}
	}



	public static void main(String[] args) {
		int size = 0;
		try{
			size = Integer.parseInt(args[0]);
			for(int x=1;x<args.length;x++){
				Random r = new Random(Integer.parseInt(args[x]));
				System.out.print("Output test1");
				test1(r,size);
				System.out.println();
				System.out.print("Output test2");
				test2(r,size);
				System.out.println();
				System.out.println("############################################################################");

			}
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("lol you derped");
			e.printStackTrace();
		}
	}
}

