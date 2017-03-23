package threads;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ramesh BG
 *
 */
public class CustomBlockingQueueImpl<E> {
    
    private Object internalLock = new Object();
    
    private List<E> list = new ArrayList<E>();
    
    private int MAX_SIZE = 10;
    
    public CustomBlockingQueueImpl(int maximumSize) {
        this.MAX_SIZE= maximumSize;
    }
    
    public CustomBlockingQueueImpl() {
        
    }
    
    public void add(E newElement) throws InterruptedException {
        synchronized (internalLock) {
            if(this.list.size() == MAX_SIZE) {
                internalLock.wait();
            }
            System.out.println("Added Element is "+newElement);
            list.add(newElement);
            System.out.println("Queue Contents are "+this.list);
            System.out.println("Queue size is "+this.list.size());
            internalLock.notifyAll();
        }
    }
    
    public E remove() throws InterruptedException  {
        E removedElement = null;
        synchronized (internalLock) {
            if(this.list.size() == 0) {
                internalLock.wait();
            }
            removedElement = list.remove(this.list.size() - 1);
            internalLock.notifyAll();
        }
        return removedElement;
    }
}
