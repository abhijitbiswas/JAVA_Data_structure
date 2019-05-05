package ConcurrencyAndThread;

//import java.util.LinkedList;

import java.util.LinkedList;
import java.util.List;

/**
 * Abhijit.Biswas
 * Custom Blocking Queue
 */

interface BlockingQueueCustom<Object> {

    /**
     * Inserts the specified element into this queue only if space is available
     * else waits for space to become available.
     */
    void put(Object item) throws InterruptedException;

    /**
     * Retrieves and removes the head of this queue only if elements are
     * available else waits for element to become available.
     */
    Object take() throws InterruptedException;
}

public class LinkedBlockingQueueCustom<Object> implements BlockingQueueCustom {
    private List<Object> queue;
    private int max;

    public LinkedBlockingQueueCustom(int queueNum) {
        this.max = queueNum;
        queue = new LinkedList<Object>();
    }

    @Override
    public synchronized Object take() throws InterruptedException {

        if (queue.size() == 0) {
            this.wait();
        }
        this.notifyAll();
        return queue.remove(0);
    }

    @Override
    public synchronized void put(java.lang.Object item)
            throws InterruptedException {

        if (queue.size() == max) {
            this.wait();
        }

        queue.add((Object) item);
        this.notifyAll();
    }
}


