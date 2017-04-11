import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class CircularLinkedList {
	static List<Node> spiltCircular(Node root){
		List<Node> nodes = new ArrayList<Node>();
		Node sPoint = root;
		Node fPoint = root;
		//Node c1 = root;
		do{
			sPoint = sPoint.next;
			fPoint = fPoint.next.next;
		}while(fPoint.next!=root && fPoint.next.next!=root);
		if(fPoint.next.next==root){
			fPoint = fPoint.next;
			//sPoint = sPoint.next;
		}
		Node c2 = sPoint.next;
		sPoint.next = root;
		fPoint.next = c2;
		nodes.add(root);
		nodes.add(c2);
		return nodes;
	}
	static void printLoopedLinkedList(Node root) {
		if(root==null){
			return ;
		}
		Node cur = root;
		//HashSet<Node> set = new HashSet<Node>();
		 do{
				//set.add(root);
				System.out.print(cur.value + " ");
				cur = cur.next;
		}while (cur!=root);
		System.out.println(cur.value+" ");
		System.out.println("****************");
	}
	public static void main(String[] args) {
		GenericLinkedList list = new GenericLinkedList(1);
		//Node n = new Node(4);
		list.insertAtEnd(4);
		list.insertAtEnd(5);
		list.insertAtEnd(6);
		list.insertAtEnd(7);
		list.insertAtEnd(list.getRoot());

		printLoopedLinkedList(list.getRoot());
		List<Node> nodes = spiltCircular(list.getRoot());
		for(Node n:nodes){
			printLoopedLinkedList(n);
		}
	}

}
