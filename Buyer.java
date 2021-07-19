import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Buyer<V> extends BuyerBase<V> {
    public Buyer (int sleepTime, int catalogSize, Lock lock, Condition full, Condition empty, PriorityQueue<V> catalog, int iteration) {
    	setSleepTime(sleepTime);
    	setIteration(iteration);
    	this.lock = lock;
    	this.full = full;
    	this.empty = empty;
    	this.catalog = catalog;
    	
    }
    public void buy() throws InterruptedException {
	try {
		lock.lock();
		//int size = catalog.size();
		while(catalog.isEmpty()) {
			empty.await();
		}
		Node<V> n = (Node<V>) catalog.dequeue();
		full.signalAll();
	    System.out.print("Consumed "); 
            n.show(); 
            // ...
	} catch (Exception e) {
            e.printStackTrace();
	} finally {
            lock.unlock();
	}
    }
}
