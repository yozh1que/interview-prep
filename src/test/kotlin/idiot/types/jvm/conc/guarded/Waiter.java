package idiot.types.jvm.conc.guarded;

import java.util.concurrent.atomic.AtomicBoolean;

public class Waiter {

    public AtomicBoolean condition = new AtomicBoolean(false);
    public Worker worker = new Worker();

    public class Worker {
        public synchronized void waitAndProceed() {
            while(!condition.get()) {
                System.out.println("Condition doesn't suffice");
                try {
                    wait();
                    System.out.println("Awakened");
                } catch (InterruptedException e) {
                    System.out.println("Interrupted");
                    return;
                }
            }
            System.out.println("Completed");
        }

        public synchronized void notifyCondition() {
            notifyAll();
        }
    }
}
