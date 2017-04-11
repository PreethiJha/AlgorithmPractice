import java.util.HashSet;

public class LoopLinkedList {

	static boolean detectTheLoop(Node root){
		if(root==null || root.next==null){
			return false;
		}
		Node sNext = root;
		Node dNext = root;
		do{
			sNext = sNext.next;
			if(dNext.next!=null){
			dNext = dNext.next.next;
			}
		}while(dNext!=sNext && dNext!=null);
		if(dNext==sNext){
			return true;
		}
		return false;
	}

	static void printLoopedLinkedList(Node root) {
		HashSet<Node> set = new HashSet<Node>();
		while (root != null) {
			if (!set.contains(root)) {
				set.add(root);
				System.out.print(root.value + " ");
				root = root.next;
			} else {
				System.out.print(root.value + " ");
				break;
			}

		}
		System.out.println();
	}

	public static void main(String[] args) {

		GenericLinkedList list = new GenericLinkedList(1);
		Node n = new Node(4);
		Node root = list.insertAtEnd(n);
		root = list.insertAtEnd(5);
		root = list.insertAtEnd(6);
		root=list.insertAtEnd(n);

		printLoopedLinkedList(root);
		System.out.println();
		boolean isLoop = detectTheLoop(root);
		System.out.println("Detected Loop =" + isLoop);
	}

}
