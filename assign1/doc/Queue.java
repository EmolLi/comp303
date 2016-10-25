import java.util.LinkedList;
//do I need to implement LInkedLIst myself?

//Do I need to submit javadoc? There are weird characters in the doc
public class Queue {
	private LinkedList<Student> participants;
	
	public Queue(){
		participants = new LinkedList<Student>();
	}
	
	//return type?
	/**
	 * This method is used to put student in the queue.
	 * @param s Student to put in the queue.
	 */
	public void enqueue(Student s){
		participants.add(s);
	}
	//does he dequeues because he is now the front of the line or he doesn't want to wait anymore?

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
	
	//other methods?
	
}
