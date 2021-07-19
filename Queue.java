// This class implements the Queue
public class Queue<V> implements QueueInterface<V>{

    //TODO Complete the Queue implementation
    private NodeBase<V>[] queue;
    private int capacity, currentSize, front, rear;
	
    public Queue(int capacity) {    
    	this.capacity = capacity;
    	currentSize = 0;
    	front = -1;
    	rear = -1;
    	queue = new NodeBase[capacity];
    }

    public int size() {    	
    	return currentSize;    	    
    }

    public boolean isEmpty() {
    	return currentSize==0;   
    }
	
    public boolean isFull() {
    	return currentSize==capacity;    
    }

    public void enqueue(Node<V> node) {
    	if (isFull()) {
    		return;
    	}
    	else if ((front == -1) && (rear == -1)) {
    		front = 0;
    		rear = 0;
    		queue[rear] = node;
    		currentSize = currentSize +1;
    	}
    	else {
    		rear = (rear + 1)%capacity;
    		queue[rear] = node;
    		currentSize = currentSize +1;
    	}
    	
    }

    public NodeBase<V> dequeue() {
    	int temp = front;
    	if (isEmpty()){
    		return null;    		
    	}
    	else if (front == rear) {
    		front = -1;
    		rear = -1;
    	}
    	else {
    		front = (front+1)%capacity;
    	}
    	currentSize = currentSize -1;
    	return queue[temp];
    
    }

}