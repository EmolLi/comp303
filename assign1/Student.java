
public class Student {
	private String name;
	private int age;
	private int ID;

	
	/**
	 * This is the constructor for Student.
	 * @param name The name of the student.
	 * @param age The age of the student.
	 * @param ID The ID number of the student.
	 * @throws AgeTooSmall when the person is less than 15 years.
	 * @throws InvalidID when the ID number is invalid (not begins with 22)..
	 */
	public Student(String name, int age, int ID) throws AgeTooSmall, InvalidID{
		if (age<15) throw new AgeTooSmall();
		if (ID>=22000 && ID<23000) throw new InvalidID();

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
