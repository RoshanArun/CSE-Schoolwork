package HW6;

public class MyQueue<E> extends Main2 {
	private int length;
	private MyNode front, back;

	public MyQueue() {
		length = 0;
		front = null;
		back = null;
	}

	/**
	 * @param v
	 */
	public void enqueue(E v) {
		MyNode node = new MyNode(v);
		if (length == 0) {
			front = node;
		} else {
			back.setLink(node);

		}
		back = node;
		length++;
	}

	public E dequeue() {
		E result = (E) front.getData();
		front = front.getLink();
		length--;

		if (length == 0) {
			back = null;
		}
		return result;
	}

	public String toString() {
		String end = "";
		MyNode current = front;
		while (current != null) {
			end = end + current.toString() + "\n";
			current = current.getLink();
		}

		return end;
	}
}
