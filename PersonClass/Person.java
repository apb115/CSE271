import java.security.InvalidParameterException;

public  class Person {
	//=============================================== Properties
	private int id;
	private String name;
	private int age;
	private String gender;
	
	//=============================================== Constructors
	
	//=============================================== Methods
	
	//=============================================== Getters / Setters
	
	public int getId() {	return id;   }
	public String getName() {	return name;	}
	public int getAge() {	return age;	}
	public String getGender() {	return gender;	}

	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		if (age < 0  || age > 100) throw new InvalidParameterException("Age " + age + " is out of bounds");
		this.age = age;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}


}
