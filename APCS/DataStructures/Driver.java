public class Driver{
	
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.add("Hello", 0);
		list.add("Goodbye", 0);
		list.add("First",0);
		System.out.println(list);

		System.out.println(list.find("Goodbye"));
	}

}