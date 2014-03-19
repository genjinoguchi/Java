import java.util.*;

public class Foo{

	public static void blah(Person p, String s){
		p.setName(s);
		change(p,"c");
	}

	public static void hurr(int n){
		n++;
	}

	public static void change(Person p, String s){
		p.setName(s);
	}

	public static class Person{
		private String name = "a";

		public void setName(String s){
			name = s;
		}

		public String toString(){
			return name;
		}

	}


	public static void main(String[] args) {
		Person p = new Person();
		blah(p,"b");
		System.out.println(p);

		Person a = new Person(), b = new Person(), c = new Person();
		a = b;
		b = c;
		b.setName("Goodbye");
		//c.setName("hello");
		System.out.println("a" + a);
		System.out.println("b" + b);
		System.out.println("c" + c);

		int n=1;
		hurr(n);
		System.out.println(n);

	}



}