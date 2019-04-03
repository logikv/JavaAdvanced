package MFP;

public class Mfp implements Print, Scan, Runnable {

    private boolean scanFree = true;
    private boolean printFree = true;


    @Override
    public void run() {

    }

    public void print() {
        if (printFree) {
            printFree = !printFree;
            System.out.println("Printing file: start");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Printing file: done");
            printFree = !printFree;
            return;
        }
        System.out.println("Printing file: queue is busy");
    }

    public void scan() {
        if (scanFree) {
            scanFree = !scanFree;
            System.out.println("Scanning to file: start");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Scanning to file: done");
            scanFree = !scanFree;
            return;
        }
        System.out.println("Scanning to file: queue is busy");
    }

    public static void main(String[] args) {
        Mfp mfp = new Mfp();
        for (int i = 0; i < 10; i++) {
            mfp.scan();
            mfp.print();
        }
    }
}
