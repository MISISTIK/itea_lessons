package less02;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

public class Cat extends Animal implements Externalizable{
	private int age;
	public Cat(){}
	public Cat(String name,int age) {
		super(name);
		this.age=age;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Cat [age=" + age + ", toString()=" + super.toString() + "]";
	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(getName());
		out.writeInt(age);
		
	}
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		setName((String)in.readObject());
		age=in.readInt();
		
	}
	
	

}
