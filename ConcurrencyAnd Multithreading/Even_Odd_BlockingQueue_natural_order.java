package ConcurrencyAndThread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Abhijit.Biswas
 * Even-odd --> Natural order output
 * Instead of ArrayBlockingQueue , we can use our own Blocking Queue
 */
public class Even_Odd_BlockingQueue_natural_order {
    public static void main(String[] args) {
        BlockingQueue queue = new ArrayBlockingQueue(1);
        NewProduserr producer = new NewProduserr(queue);
        NewConsumerr consumer = new NewConsumerr(queue);
        Thread prod = new Thread(producer);
        Thread cons = new Thread(consumer);
        prod.start();
        cons.start();

    }
}

class NewProduserr implements Runnable {
    BlockingQueue bQueue;

    public NewProduserr(BlockingQueue bQueue) {
        this.bQueue = bQueue;
    }

    public void run() {
        try {
            for (int i = 1; i < 11; i++) {
                bQueue.put("abc");
                if (i % 2 != 0)
                    System.out.println("Produser.run() : " + i);
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class NewConsumerr implements Runnable {
    BlockingQueue bQueue;

    public NewConsumerr(BlockingQueue bQueue) {
        this.bQueue = bQueue;
    }

    public void run() {
        try {
            for (int i = 1; i < 11; i++) {
                if (i % 2 == 0)
                    System.out.println("Consumer.run() : " + i);
                bQueue.take();
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
