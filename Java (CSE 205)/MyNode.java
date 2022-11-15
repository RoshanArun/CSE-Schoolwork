
public class MyNode <E> extends MyList{
	
	protected E data;
	protected MyNode link;
	
	public E getData() {
		return data;
	}
	
	public MyNode getLink() {
		return link;
	}
	
	public void setData(E data) {
		this.data = data;
	}
	
	public void setLink(MyNode node) {
		link = node;
	}
	
	public MyNode(){
		link = null;
	}
	
	public MyNode(E data){
		this.data = data;
		link = null;
	}

	public String toString() {
		return data + " ";
	}
}
