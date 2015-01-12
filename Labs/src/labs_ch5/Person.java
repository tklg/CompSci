package labs_ch5;

public class Person {

	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public void changeName(String name) {
		this.name = name;
	}
	public void changeAge(int age) {
		this.age = age;
	}
	public String toString() {
		return name + " - Age " + age;
	}
	
}
