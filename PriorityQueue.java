 
public class PriorityQueue<V> implements QueueInterface<V>{

    private NodeBase<V>[] queue;
    private int capacity, currentSize, front;
	
    public PriorityQueue(int capacity) {  
    	this.capacity = capacity;
    	currentSize = 0;
    	front = -1;
    	queue = new NodeBase[capacity];
    }

    public int size() {
    	return currentSize;
    }

    public boolean isEmpty() {
    	return currentSize == 0;

    }
	
    public boolean isFull() {
    	return currentSize == capacity;
    }

    public void enqueue(Node<V> node) {
    	if (isFull()) {
    		return;
    	}
    	else if(front == -1) {
    		front = 0;
    		queue[front] = node;
    		currentSize++;
    	}
    	else {
    			int priority = node.getPriority();
    			int i=front;
    			int prioritycur = queue[front].getPriority();
    			while(i>=0 && priority>prioritycur) {
    				queue[i+1] = queue[i];
    				i=i-1;
    				if (i>=0) {prioritycur = queue[i].getPriority();}
    			}
    			queue[i+1] = node; 			
    			front = front+1;
    			currentSize++;
    	}
    }

    // In case of priority queue, the dequeue() should 
    // always remove the element with minimum priority value
    public NodeBase<V> dequeue() {
    	if (isEmpty()) {
    		return null;
    	}
    	else if (front ==0) {
    		int temp = front;
    		front = -1;
    		currentSize--;
    		return queue[temp];
    	}
    	else {
    		int temp = front;
    		front--;
    		currentSize--;
    		return queue[temp];
    	}

    }

    public void display () {
	if (this.isEmpty()) {
            System.out.println("Queue is empty");
	}
	for(int i=0; i<currentSize; i++) {
            queue[i].show();
	}
    }
}

