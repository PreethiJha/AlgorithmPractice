public class LinkedListCustom {
	
	/*static Node reverseLinkedList(Node cur, Node prev) {
		if (cur == null || cur.next == null) {
			root1 = cur;
			cur.next = prev;
			return null;
		}

		Node nextNode = cur.next;
		cur.next = prev;
		reverseLinkedList(nextNode, cur);

		return root1;
	}*/

	//Reverse a linked list
	static Node reverse(Node root) {
		if (root == null || root.next == null) {
			return root;
		}
		Node temp = null;
		Node prev = null;
		Node cur = root;
		while (cur != null) {
			temp = cur.next;
			cur.next = prev;
			prev = cur;
			cur = temp;
		}
		return prev;
	}

	//Merge Sorted Linked List - Iteratively
	static Node mergeSortedLinkedList(Node r1, Node r2) {
		Node newRoot = null;
		Node cur = null;
		if (r1 == null) {
			return r2;
		}
		if (r2 == null) {
			return r1;
		}

		while (r1 != null || r2 != null) {
			Node n = null;
			if (r1 != null && r2 != null) {
				if (r1.value < r2.value) {
					n = new Node(r1.value);
					r1 = r1.next;
				} else {
					n = new Node(r2.value);
					r2 = r2.next;
				}

			} else if (r2 == null && r1 != null) {
				n = new Node(r1.value);
				r1 = r1.next;
			}

			else if (r1 == null && r2 != null) {
				n = new Node(r2.value);

				r2 = r2.next;
			}

			if (newRoot == null) {
				newRoot = n;
				cur = newRoot;
			} else {
				cur.next = n;
				cur = cur.next;
			}

		}

		return newRoot;
	}

	//Recursive Merge of Linked List
	static Node mergeLinkedList(Node r1, Node r2) {
		Node newRoot = null;
		Node cur = null;
		Node n = null;
		if (r1 == null) {
			return r2;
		}
		if (r2 == null) {
			return r1;
		}
		if (r1 != null && r2 != null) {
			if (r1.value < r2.value) {
				n = new Node(r1.value);
				r1 = mergeLinkedList(r1.next,r2);
			} else {
				n = new Node(r2.value);
				r2 = mergeLinkedList(r1,r2.next);
			}
		}
		if (newRoot == null) {
			newRoot = n;
			cur = newRoot;
		} 
		else {
			cur.next = n;
			cur = cur.next;
		}
		return newRoot;
	}
	
	static Node reverseEveryKNodes(Node root,int k){
		if(root==null || root.next==null){
			return root;
		}
		Node next = null;
		Node cur = root;
		Node prev = null;
		
		int cnt = 0;
		//Reverse every k element
		while(cur!=null && cnt<k){
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
			cnt++;
		}
		//Old root is still there in the same position so point next k elements to
			if(next!=null){
				Node nextK = reverseEveryKNodes(next, k);
				root.next = nextK;
			}
		
		
		return prev;
	}
	
	private static void printLinkedList(Node root){
		Node temp = root;
		while(temp!=null){
			System.out.print(temp.value+" ");
			temp = temp.next;
		}
		System.out.println("");
		System.out.println("=======================");
	}
	
	static Node kthRotationOfLinkedList(Node root,int k){
		int cnt = 1;
		Node temp = null;
		Node cur = root;
		while(cur!=null && cnt<k){
			cur = cur.next;
			cnt ++;
		}
		
		Node newRoot = cur.next;
		cur.next = null;
		temp = newRoot;
		while(temp.next!=null){
			temp = temp.next;
		}
		temp.next = root;
		return newRoot;
		
	}
	
	static Node getLexographicalOrderLinkedList(Node root){
		Node left = null;
		Node right = null;
		Node lRoot = null;
		Node rRoot = null;
		while(root!=null){
			int val = root.value;
			if(val%2==0){
				if(left==null){
					left = root;
					lRoot = root;
				}else{
					left.next = root;
					left = left.next;
				}
				
			}else{
				if(right==null){
					right = root;
					rRoot = root;
				}else{
					right.next = root;
					right = right.next;
				}
			}
			root= root.next;
		}
		left.next = rRoot;
		return lRoot;
	}

	public static void main(String[] args) {
		/*GenericLinkedList list1 = new GenericLinkedList(84);
		Node r = list1.insertAtFront(64);
		r=list1.insertAtFront(59);
		r=list1.insertAtFront(46);
		r=list1.insertAtFront(32);
		r=list1.insertAtFront(21);
		list1.printLinkedList(r);
		
		GenericLinkedList list2 = new GenericLinkedList(100);
		Node r1=list2.insertAtFront(99);
		r1=list2.insertAtFront(68);
		r1=list2.insertAtFront(38);
		r1=list2.insertAtFront(26);
		r1=list2.insertAtFront(10);
		list2.printLinkedList(r1);*/
		
		//Merge Sorted Linked List  - Non Recursive
		/*Node merge = mergeSortedLinkedList(list1.getRoot(), list2.getRoot());
		printLinkedList(merge);*/
		
		//Merge Sorted Linked List  - Recursive - Not working
		/*Node merge = mergeSortedLinkedList(list1.getRoot(), list2.getRoot());
		printLinkedList(merge);*/
		
		//Reverse every K Nodes 
		/*Node revKNodes = reverseEveryKNodes(list1.getRoot(),2);
		printLinkedList(revKNodes);*/
		
		//Reverse a linked list
		/*Node revNodes = reverse(list1.getRoot());
		printLinkedList(revNodes);*/
		GenericLinkedList list = new GenericLinkedList(2);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		list.insertAtEnd(6);
		list.insertAtEnd(10);
		list.insertAtEnd(45);
		list.printLinkedList(list.getRoot());
		/*Node newRoot = kthRotationOfLinkedList(list.getRoot(),4);
		printLinkedList(newRoot);*/
		Node newRoot = getLexographicalOrderLinkedList(list.getRoot());
		printLinkedList(newRoot);
	}

}
