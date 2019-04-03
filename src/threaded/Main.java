package threaded;


public class Main {

    public static void main(String[] args) {
        PingPong pingPong = new PingPong();

        Thread t1 = new Thread(new PingThread(pingPong));
        Thread t2 = new Thread(new PongThread(pingPong));

        t1.start();
        t2.start();

    }

}

class PingPong {

    boolean flag = true;

    public synchronized void ping() {
        System.out.println("Ping");
    }

    public synchronized void pong() {
        System.out.println("Pong");
    }
}

class PingThread implements Runnable {

    private PingPong pingPong;

    public PingThread(PingPong pingPong) {
        this.pingPong = pingPong;
    }

    @Override
    public void run() {
        while (pingPong.flag) {
            this.pingPong.ping();

            try {
                Thread.sleep(2000);
                wait();
                pingPong.flag = false;
            } catch (IllegalMonitorStateException | InterruptedException e) {
                System.out.println("Thread interrupted" + e);
            }
        }
        System.out.println(pingPong.flag);
        notifyAll();

    }
}

class PongThread implements Runnable {


    private PingPong pingPong;

    public PongThread(PingPong pingPong) {
        this.pingPong = pingPong;
    }

    @Override
    public void run() {
        while (!pingPong.flag) {
            try {
                this.pingPong.pong();
                Thread.sleep(2000);
                wait();
            } catch (IllegalMonitorStateException | InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted" + e);
            }
        }

        pingPong.flag = true;
        notifyAll();

    }
}
