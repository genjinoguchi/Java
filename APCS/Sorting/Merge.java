

public class Merge{

	public static int[] merge(int[] a, int[]b){
		int[] c = new int[a.length+b.length];
		int aint=0, bint=0;
		for(int x=0;x<c.length;x++){
			//System.out.println(b.length-bint);
			if(aint==a.length){
				while(bint<b.length)c[x]=b[bint++];
			}else if(bint==b.length){
				while(aint<a.length)c[x]=a[aint++];
			}else{
				//System.out.println(aint + " " + bint);
				if(a[aint]<b[bint]){
					c[x]=a[aint++];
				}else{
					c[x]=b[bint++];
				}
			}
			System.out.println(c[x]);
		}
		return c;
	}

	public static void msort(int[]a){
		if(a.length>1){}

			//Split the arrays
			int[] part1 = new int[a.length/2];
			int[] part2 = new int[a.length-part1.length];
			System.arraycopy(a, 0, part1, 0, part1.length);
			System.arraycopy(a, part1.length, part2, 0, part2.length);
			msort(part1);
			msort(part2);

			a = merge(part1, part2);

		}


	}




	public static void main(String[] args) {
		int[] foo = {0,2,4,6,8,10};
		int[] blah = {1, 3, 5, 7, 9};
		int[] total = merge(foo,blah);
	}

}