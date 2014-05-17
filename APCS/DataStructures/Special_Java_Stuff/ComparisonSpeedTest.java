import java.util.*;

public class ComparisonSpeedTest{
	private TreeMap<Integer,Integer> tm;
	private TreeSet<Integer> ts;
	private HashMap<Integer,Integer> hm;
	private HashSet<Integer> hs;
	private int total;
	Random randKey,randVal;

	public ComparisonSpeedTest(int total){
		init();
		this.total = total;
		testSpeed();
	}

	public void testSpeed(){
		randKey = new Random(9999);
		randVal = new Random(999);
		long l = System.currentTimeMillis();
		for(int x=0;x<total;x++){
			ts.add(new Integer(randVal.nextInt(total)));
		}
		System.out.print("Treeset: ");
		System.out.println(System.currentTimeMillis()-l);

		randVal = new Random(999);
		l = System.currentTimeMillis();
		for(int x=0;x<total;x++){
			tm.put(new Integer(randKey.nextInt(total)),new Integer(randVal.nextInt(total)));
		}
		System.out.print("Treemap: ");
		System.out.println(System.currentTimeMillis()-l);

		randKey = new Random(9999);
		randVal = new Random(999);
		l = System.currentTimeMillis();
		for(int x=0;x<total;x++){
			hm.put(new Integer(randKey.nextInt(total)),new Integer(randVal.nextInt(total)));
		}
		System.out.print("Hashmap: ");
		System.out.println(System.currentTimeMillis()-l);

		randVal = new Random(999);
		l = System.currentTimeMillis();
		for(int x=0;x<total;x++){
			hs.add(new Integer(randVal.nextInt(total)));
		}
		System.out.print("Hashset: ");
		System.out.println(System.currentTimeMillis()-l);
	}

	public void init(){
		tm = new TreeMap<Integer,Integer>();
		ts = new TreeSet<Integer>();
		hm = new HashMap<Integer,Integer>();
		hs = new HashSet<Integer>();
	}

	public static void main(String[] args) {
		try{
			ComparisonSpeedTest cst = new ComparisonSpeedTest(Integer.parseInt(args[0]));


		}catch(Exception e){}
	}

}