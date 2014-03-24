public class Driver{
	
	public static void main(String[] args) {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		System.out.println(list);

		list.add(new Integer(1), 0);
		list.add(new Integer(2), list.length());
		list.add(new Integer(3), 1);
		list.remove(list.length()-1);

		System.out.println("length: " + list.length());
		System.out.println(list);
		System.out.println();


	}

}