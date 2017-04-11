public class DNode<T> {
	T value;
	DNode next;
	DNode prev;

	public DNode(T value) {
		this.value = value;
		this.next = null;
		this.prev = null;
	}
}
