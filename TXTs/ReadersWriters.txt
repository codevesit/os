import java.util.concurrent.Semaphore;
class ReadersWriters {	static Semaphore readLock = new Semaphore(1);
    static Semaphore writeLock = new Semaphore(1);
    static int readCount = 0;
    static class Read extends Thread {
        public void run() {
            try {	readLock.acquire();
                readCount++;
                if (readCount == 1) {	writeLock.acquire();	}
                readLock.release();
                System.out.println("Thread "+Thread.currentThread().getName() + " is READING");
                Thread.sleep(250);
                System.out.println("Thread "+Thread.currentThread().getName() + " has FINISHED READING");
                readLock.acquire();
                readCount--;
                if(readCount == 0) {	 writeLock.release();	}
                readLock.release();	}
 catch (InterruptedException e) {}	}	 }
    static class Write extends Thread {
        public void run() {
            try {	writeLock.acquire();
                System.out.println("Thread "+Thread.currentThread().getName() + " is WRITING");
                Thread.sleep(500);
                System.out.println("Thread "+Thread.currentThread().getName() + " has FINISHED WRITING");
                writeLock.release();	}
catch (InterruptedException e) {}	}	}
    public static void main(String[] args) {
        Read read = new Read();
        Write write = new Write();
        Thread t1 = new Thread(read);	 t1.setName("1");
        Thread t2 = new Thread(read);	 t2.setName("2");
        Thread t3 = new Thread(write);	 t3.setName("3");
        Thread t4 = new Thread(read);	 t4.setName("4");
        t1.start();		t3.start();	t2.start();	t4.start();  }	}
