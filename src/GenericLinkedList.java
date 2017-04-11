
public class GenericLinkedList {
	Node root;
	Node endPointer;
	
	public Node getRoot() {
		return root;
	}
	
	public GenericLinkedList(Node n) {
		root = n;
		endPointer=n;
	}
	
	public GenericLinkedList(int val) {
		root = new Node(val);
		endPointer = root;
	}
	
	Node insertAtFront(int val){
		Node n = new Node(val);
		return insertAtFront(n);
	}
	
	Node insertAtFront(Node n){
		n.next = root;
		root = n;
		return n;
	}
	
	Node insertAtEnd(int val){
		Node n = new Node(val);
		return insertAtEnd(n);
	}
	
	Node insertAtEnd(Node n){
		endPointer.next = n;
		endPointer = n;
		return root;
	}
	
	void printLinkedList(Node n){
		Node temp = n;
		while(temp!=null){
			System.out.print(temp.value+" ");
			temp = temp.next;
		}
		System.out.println("=======================");
	}
}
