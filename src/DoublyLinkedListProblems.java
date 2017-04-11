public class DoublyLinkedListProblems {
	static DNode<Integer> mergerDlinkedList(DNode<Integer> r1, DNode<Integer> r2) {
		if(r1==null && r2==null){
			return null;
		}
		DoublyLinkedList<Integer> dNode = null;
		while (r1 != null && r2 != null) {
			if (r1.value < r2.value) {
				if (dNode == null) {
					dNode = new DoublyLinkedList<Integer>(r1.value);
				}else{
					dNode.insertAtEnd(r1.value);
				}
				r1= r1.next;
			} else {
				if (dNode == null) {
					dNode = new DoublyLinkedList<Integer>(r2.value);
				}else{
					dNode.insertAtEnd(r2.value);
				}
				r2 = r2.next;
			}
		}
		while (r1 != null && r2 == null) {
			if (dNode == null) {
				dNode = new DoublyLinkedList<Integer>(r1.value);
			}else{
				dNode.insertAtEnd(r1.value);
			}
			r1= r1.next;
		}
		while(r2 != null && r1 == null){
			if (dNode == null) {
				dNode = new DoublyLinkedList<Integer>(r2.value);
			}else{
				dNode.insertAtEnd(r2.value);
			}
			r2=r2.next;
		}

		return dNode.getRoot();
	}
	
	static void printDoublyLinkedList(DNode root) {
		while (root != null) {
			System.out.print(root.value + " ");
			root = root.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		DoublyLinkedList<Integer> dLink1 = new DoublyLinkedList<Integer>(1);
		dLink1.insertAtEnd(4);
		dLink1.insertAtEnd(5);
		dLink1.insertAtEnd(12);
		dLink1.insertAtEnd(18);
		dLink1.printDoublyLinkedList(dLink1.getRoot());
		
		DoublyLinkedList<Integer> dLink2 = new DoublyLinkedList<Integer>(3);
		dLink2.insertAtEnd(6);
		dLink2.insertAtEnd(10);
		dLink2.insertAtEnd(15);
		dLink2.insertAtEnd(22);
		dLink2.printDoublyLinkedList(dLink2.getRoot());
		
		DNode<Integer> dMerge = mergerDlinkedList(dLink1.getRoot(), dLink2.getRoot());
		printDoublyLinkedList(dMerge);
	}
}
