public class StackCustom {
	Node top;
	Node minNode;

	public Node getTop() {
		return top;
	}

	public Node getMinNode() {
		return minNode;
	}

	public StackCustom() {

	}

	public StackCustom(int val) {
		Node n = new Node(val);
		top = n;
		minNode = new Node(val);
	}

	Node push(int val) {
		Node n = new Node(val);
		// this.top = getTop();
		n.next = top;
		top = n;
		if (minNode == null) {
			minNode = new Node(val);
		} else if (val <= minNode.value) {
			Node mNode = new Node(val);
			mNode.next = minNode;
			minNode = mNode;
		}

		return top;
	}

	int pop() {
		// this.top = getTop();
		Node popN = top;
		if (popN.value == minNode.value) {
			minNode = minNode.next;
		}
		top = top.next;
		return popN.value;
	}

	int getMin() {
		// this.top = getTop();
		return minNode.value;
	}

	void printStack() {
		// this.top = getTop();
		Node cur = top;
		while (cur != null) {
			System.out.print(cur.value + " ");
			cur = cur.next;
		}
		System.out.println();
	}

}
