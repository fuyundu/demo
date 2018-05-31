package java8.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class SortPerson {
	public static void main(String[] args) {
		Person p1 = new Person("t", 11);
		Person p2 = new Person("b", 21);
		Person p3 = new Person("c", 31);
		Person p4 = new Person("d", 41);
		Person p5 = new Person("e", 51);
		Person p6 = new Person("f", 42);
		Person p7 = new Person("g", 32);
		Person p8 = new Person("h", 22);
		Person p9 = new Person("i", 12);
		
		Person[] people = { p1, p2, p3, p4, p5, p6, p7, p8, p9 };

		System.out.println(people[3]);
		
		Comparator<Person> byAge2 = Comparator.comparing(p -> p.getAge());
		
		Arrays.sort(people, byAge2);
		
		System.out.println(people[0]);
		System.out.println(people[1]);
		System.out.println(people[2]);
		System.out.println(people[3]);
		
	}
}
