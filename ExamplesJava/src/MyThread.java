public class MyThread implements Runnable{
    void print(int i){
        System.out.println("I am a thread " + i);
    }
    @Override
    public void run() {
        int i;
        
        try {
            for (i = 0; i < 10; i++) {
                Thread.sleep(150);
                this.print(i);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
