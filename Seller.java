import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Seller<V> extends SellerBase<V> {
	int catalogSize;
	
    public Seller (int sleepTime, int catalogSize, Lock lock, Condition full, Condition empty, PriorityQueue<V> catalog, Queue<V> inventory) {
    	setSleepTime(sleepTime);
    	this.lock = lock;
    	this.full = full;
    	this.empty = empty;
    	this.catalog = catalog;
    	this.inventory = inventory;
    	this.catalogSize = catalogSize;
    	
    }
    
    public void sell() throws InterruptedException {
    	
	try {
		lock.lock();
		while(catalog.isFull()) {
			full.await();
		}
		if(inventory.isEmpty()) {
						
		}
		else{
		Node<V> elem = (Node<V>) inventory.dequeue();
		catalog.enqueue(elem);
		empty.signalAll(); 
		}
		
	} catch(Exception e) {
            e.printStackTrace();
	} finally {
		lock.unlock();
	}		
    }
}
