import java.util.LinkedList;



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
	 * @throws EmptyQueue when there is no student in the queue.
	 */
	public void dequeue() throws EmptyQueue{
		if(!participants.isEmpty()){
			participants.pop();
		}
		else throw new EmptyQueue();
	}

	
}
