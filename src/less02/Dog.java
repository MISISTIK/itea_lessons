package less02;

import java.io.Serializable;

public class Dog implements Cloneable,Serializable{
private String name;
private int age;
private Owner owner;
public Dog(String name, int age) {
	super();
	this.name = name;
	this.age = age;
}

public Owner getOwner() {
	return owner;
}

public void setOwner(Owner owner) {
	this.owner = owner;
}
@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

@Override
public String toString() {
	return "Dog [name=" + name + ", age=" + age + ", owner=" + owner + "]";
}



}
