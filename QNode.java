
public class QNode<T> {
	T value;
	QNode<T> next;

	public QNode(T value) {
		super();
		this.value = value;
		this.next = null;
	}

}
