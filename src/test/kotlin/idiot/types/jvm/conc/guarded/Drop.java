package idiot.types.jvm.conc.guarded;

public class Drop {

    private String message;

    public synchronized String get() {
        while (this.message == null) { // while to guard against unconditional/spurious wakes
            try {
                wait();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
        String message = this.message;
        this.message = null;
        notifyAll();
        return message;
    }

    public synchronized void put(String message) {
        while (this.message != null) {
            try {
                wait();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
        this.message = message;
        notifyAll();
    }
}
