
public class QueueCust<T> {
	QNode<T> top;
	QNode<T> rear;
	
	
	
	public QueueCust(QNode<T> top) {
		super();
		this.top = top;
		this.rear = top;
	}



	QNode<T> enqueue(T value){
		QNode<T> newTop = new QNode<T>(value);
		newTop.next = top;
		rear.next = newTop;
		top = newTop;
		return newTop;
	}
	
	T dequeue(){
		if(rear==null){
			return null;
		}
		QNode<T> dequeNode =null;
		if(rear!=null){
			dequeNode = rear;
			rear = rear.next;
		}
		return dequeNode.value;
	}
	

}
