
public class Student {
	private String name;
	private int age;
	private int ID;
	//do I need accessor method for the attributes?
	
	/**
	 * This is the constructor for Student.
	 * @param name The name of the student.
	 * @param age The age of the student.
	 * @param ID The ID number of the student.
	 * @throws IllegalArgumentException when the person is less than 15 years or the ID number is invalid.
	 */
	public Student(String name, int age, int ID) throws IllegalArgumentException{
		if (age<15) throw new IllegalArgumentException("Age too small");
		if (ID>=22000 && ID<23000) throw new IllegalArgumentException("Invalid ID");

		this.name = name;
		this.age = age;
		this.ID = ID;
	}
	
	/**
	 * Return the age of the student.
	 * @return the age of the student.
	 */
	public int getAge(){
		return age;
	}
	//  do I need to use clone?
	//Is the last two accessors necessary?
	/**
	 * Return the name of the student.
	 * @return the name of the student.
	 */
	public String getName(){
		return new String(name);
	}
	
/**
 * Return the ID number of the student
 * @return the ID number of the student
 */
	public int getID(){
		return ID;
	}
}
