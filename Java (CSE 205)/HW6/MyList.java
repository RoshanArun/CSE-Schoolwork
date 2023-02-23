package HW6;

public class MyList<E> extends Main2 {
	private MyNode head;
	private MyNode tail;

	int size = 0;

	public void insertFirst(E v) {
		MyNode new_node = new MyNode(v);
		if (head == null) {
			head = new_node;
			tail = new_node;
		} else {
			MyNode temp = head;
			head = new_node;
			head.link = temp;
		}
		size++;
	}

	public void insertAt(int pos, E v) {
		MyNode newNode = new MyNode(v);
		if (pos < 0 || pos > size + 1) {
			System.out.println("Invalid Position");
		}
		if (head == null) {
			head = newNode;
			tail = newNode;
		}

		MyNode current = this.head;
		MyNode previous = null;

		int i = 0;

		while (i < pos) {
			previous = current;
			current = current.link;

			if (current == null) {
				break;
			}
			i++;
		}

		newNode.setLink(current);
		;
		previous.setLink(newNode);
		size++;
	}

	public void insertLast(E v) {
		MyNode nnode = new MyNode(v);
		if (head == null) {
			tail = nnode;
			head = nnode;
		} else {
			tail.setLink(nnode);
			tail = nnode;
		}
		size++;
	}

	public void removeFirst() {
		MyNode currNode = head;
		head = currNode.getLink();
	}

	public void removeAt(int index) {
		MyNode currNode = head, prev = null;
		if (index == 0 && currNode != null) {
			head = currNode.getLink();
			size--;
		}

		int counter = 0;
		while (currNode != null) {
			if (counter == index) {
				prev.setLink(currNode.getLink());
				System.out.println("Element deleted at index " + index);
				size--;
				break;
			} else {
				prev = currNode;
				currNode = currNode.getLink();
				counter++;
			}
		}
		if (currNode == null) {
			System.out.println("elment at index " + index + " do not exist!");
		}
	}

	public void removeLast() {
		if (head == null) {
			System.out.println("List is empty");
		} else {
			if (head != tail) {
				MyNode currNode = head;
				while (currNode.link != tail) {
					currNode = currNode.link;
				}
				tail = currNode;
				tail.link = null;
				size--;
			} else {
				head = null;
				tail = null;
			}
		}
	}

	public void printAll() {
		MyNode current = head;

		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		System.out.println("Adding nodes to the start of the list: ");
		while (current != null) {
			System.out.println(current.data + " ");
			current = current.link;
		}
		System.out.println();
	}
}
