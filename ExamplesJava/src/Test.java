public class Test {
    public static void main(String[] args) {
        MyThread ob = new MyThread();
        Thread thread = new Thread(ob, "NameOfThread");
        thread.start();

        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("I am the Main thread " + i);
                Thread.sleep(100);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
