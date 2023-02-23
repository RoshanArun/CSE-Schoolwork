package HW6;

public class MyStack<E> extends Main2 {
	private MyNode top;
	private int length;

	public MyStack() {
		length = 0;
		top = null;
	}

	public void push(E data) {
		MyNode temp = new MyNode(data);
		temp.setLink(top);
		top = temp;
		length++;
	}

	public E pop() {
		E result = (E) top.getData();
		top = top.getLink();
		length--;
		return result;
	}

	public int size() {
		return length;
	}

	public String toString() {
		String end = "";
		MyNode current = top;
		while (current != null) {
			end = end + current.toString() + "\n";
			current = current.getLink();
		}

		return end;
	}
}
