package ConcurrencyAndThread;
/*
Abhijit.Biswas
ReentrantLock Custom design
Created a interface LockCustom
 */
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

/*
Same like custom Lock interface we have created
 */
interface LockCustom {
    void lock();
    void unlock();
    boolean tryLock();
    Condition newCondition();

}


public class ReentrantLockCustom implements LockCustom {
    int lockHoldCount;
    //Id of thread which is currently holding the lock.
    long IdOfThreadCurrentlyHoldingLock;

    /**
     * Creates an instance of ReentrantLock.
     * Initially lock hold count is 0.
     */
    ReentrantLockCustom() {
        lockHoldCount = 0;
        ReentrantLock rl = new ReentrantLock();
    }
    /**
     * Acquires the lock if it is not held by another thread.
     * And sets lock hold count to 1.
     * If current thread already holds lock then lock hold
     * count is increased by 1.
     * If the lock is held by another thread then the current
     * thread waits for another thread to release lock.
     */

    @Override
    public synchronized void lock() {
        //Acquires the lock if it is not held by another thread.
        // And sets lock hold count to 1.
        if (lockHoldCount == 0) {
            lockHoldCount++;
            IdOfThreadCurrentlyHoldingLock = Thread.currentThread().getId();
        }
        //If current thread already holds lock then lock hold
        // count is increased by 1.
        else if (lockHoldCount > 0
                && IdOfThreadCurrentlyHoldingLock == Thread.currentThread().getId()) {
            lockHoldCount++;
        }
        //If the lock is held by another thread then the current
        // thread waits for another thread to release lock.
        else {
            try {
                wait();
                lockHoldCount++;
                IdOfThreadCurrentlyHoldingLock = Thread.currentThread().getId();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public synchronized void unlock() {
        //current thread is not holding the lock, throw IllegalMonitorStateException.
        if (lockHoldCount == 0)
            throw new IllegalMonitorStateException();
        lockHoldCount--; //decrement lock hold count by 1
        //if lockHoldCount is 0, lock is released, and
        //one waiting thread is notified.
        if (lockHoldCount == 0)
            notify();
    }

    @Override
    public synchronized boolean tryLock() {
        //Acquires the lock if it is not held by another thread and
        //returns true
        if (lockHoldCount == 0) {
            lock();
            return true;
        }
        //If lock is held by another thread then method return false.
        else
            return false;
    }

    @Override
    public Condition newCondition() {
        //basically in newCondition we can write condition for like wait(),notify(),notifyAll() , means own custom condition.
        //or write a class who will extends condition class and override the methods and write own logics. And finally return object of that class
        return new Condition() {
            @Override
            public void await() throws InterruptedException {

            }

            @Override
            public void awaitUninterruptibly() {

            }

            @Override
            public long awaitNanos(long nanosTimeout) throws InterruptedException {
                return 0;
            }

            @Override
            public boolean await(long time, TimeUnit unit) throws InterruptedException {
                return false;
            }

            @Override
            public boolean awaitUntil(Date deadline) throws InterruptedException {
                return false;
            }

            @Override
            public void signal() {

            }

            @Override
            public void signalAll() {

            }

        };
    }
}

