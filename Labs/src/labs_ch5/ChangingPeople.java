package labs_ch5;
import villa7.Print;
public class ChangingPeople {

	private static Print p = new Print();
	
	public static void main(String[] args) {
		Person p1 = new Person("Sally", 13);
		Person p2 = new Person("Sam", 15);
		
		int age = 21;
		String name = "Jill";
		
		p.nl("\nParameter Passing... Original Values...");
		p.nl("person1: " + p1);
		p.nl("person2: " + p2);
		p.nl("age: " + age + "\tname: " + name + "\n");
		
		changePeople(p1, p2, age, name);
		
		p.nl("\nValues after calling changePeople...");
		p.nl("person1: " + p1);
		p.nl("person2: " + p2);
		p.nl("age: " + age + "\tname: " + name + "\n");
		
	}
	public static void changePeople(Person p1, Person p2, int age, String name) {
		p.nl("\nInside changePeople... Original parameters...");
		p.nl("person1: " + p1);
		p.nl("person2: " + p2);
		p.nl("age: " + age + "\tname: " + name + "\n");
		
		p2.changeName(name);
		p2.changeAge(age);
		name = "Jack";
		age = 101;
		p1.changeName(name);
		p1.changeAge(age);
		
		p.nl("\nInside changePeople... Changed values...");
		p.nl("person1: " + p1);
		p.nl("person2: " + p2);
		p.nl("age: " + age + "\tname: " + name + "\n");
		
	}
}
