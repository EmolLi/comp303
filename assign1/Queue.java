import java.util.LinkedList;


//Do I need to submit javadoc? There are weird characters in the doc
public class Queue {
	private LinkedList<Student> participants;
	
	public Queue(){
		participants = new LinkedList<Student>();
	}
	

	/**
	 * This method is used to put student in the queue.
	 * @param s Student to put in the queue.
	 */
	public void enqueue(Student s){
		participants.add(s);
	}

	/**
	 * This method is used to remove the first  student in the queue from the queue.
	 * @throws Exception when there is no student in the queue.
	 */
	public void dequeue() throws Exception{
		if(!participants.isEmpty()){
			participants.pop();
		}
		else throw new Exception("Empty queue");
	}
	

	
}
