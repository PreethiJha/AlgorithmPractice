public class DoublyLinkedList<T> {
	DNode root;
	private DNode endPointer;

	public DNode getRoot() {
		return root;
	}

	public DoublyLinkedList(T root) {
		super();
		DNode<T> r = new DNode<T>(root);
		DoublyLinkedList(r);
	}

	public void DoublyLinkedList(DNode<T> root) {
		this.root = root;
		endPointer = root;
	}

	DNode<T> insertAtFront(T val) {
		DNode<T> d = new DNode<T>(val);
		return insertAtFront(d);
	}

	DNode<T> insertAtFront(DNode<T> val) {
		root = getRoot();
		val.next = root;
		root.prev = val;
		return val;
	}

	DNode<T> insertAtEnd(T val) {
		DNode<T> d = new DNode<T>(val);
		return insertAtEnd(d);
	}

	DNode<T> insertAtEnd(DNode<T> val) {
		endPointer.next = val;
		val.prev = endPointer;
		endPointer = val;
		return root;
	}

	void printDoublyLinkedList(DNode root) {
		while (root != null) {
			System.out.print(root.value + " ");
			root = root.next;
		}
		System.out.println();
	}

}
