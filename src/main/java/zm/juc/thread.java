package zm.juc;


public class thread {
    public static void main(String[] args) {
        System.out.println("mian");
        Runnable runnable= () -> System.out.println("thread");
        Thread thread=new Thread(runnable, "test");
        thread.start();
    }
}
