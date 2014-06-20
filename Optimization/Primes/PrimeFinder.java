public class PrimeFinder{

	public static void main(String[] args) {
		try{
			int n = Integer.parseInt(args[0]);
			double timeStart = System.nanoTime()/1000000000.0;
			int result = findNthPrime(n);
			System.out.println("Time: " + ((System.nanoTime()/1000000000.0)-timeStart) + " seconds");


			System.out.println(result);
		} catch (ArrayIndexOutOfBoundsException e){
			e.printStackTrace();
		}
	}

	public static int findNthPrime(int n){ //Baseline method
		int[] primes = new int[n];
		int num=2,pos=0;

		while(primes[n-1]==0){
			if(checkPrime(num,primes)){
				primes[pos++] = num;
				//System.out.println(num);
			}
			num++;
		}

		return primes[n-1];

	}

	public static boolean checkPrime(int n,int[]primes){
		for(int p : primes){
			if(p==0){
				break;
			}
			if(p>(int)Math.sqrt(n)){
				break;
			}
			if((p * (n/p))==n){
				return false;
			}
		}
		return true;
	}

}
