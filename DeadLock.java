package homework18;
//实现死锁
public class Test {
    public static void main(String[] args) {
        Lei l1 = new Lei("A");
        Lei l2 = new Lei("B");
        MyThread1 myThread1 = new MyThread1(l1,l2);
        MyThread2 myThread2 = new MyThread2(l1,l2);
        myThread1.start();
        myThread2.start();
    }
}
class MyThread1 extends Thread{
    Lei l1;
    Lei l2;
    public MyThread1(Lei l1,Lei l2){
        this.l1 = l1;
        this.l2 = l2;
    }
    public void run(){
       synchronized (l1){
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           synchronized (l2){
               l1.doSome();
               l2.doSome();
           }
       }
    }
}
class MyThread2 extends Thread{
    Lei l1;
    Lei l2;
    public MyThread2(Lei l1,Lei l2){
        this.l1 = l1;
        this.l2 = l2;
    }
    public void run(){
        synchronized (l2){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (l1){
                l1.doSome();
                l2.doSome();
            }
        }
    }
}
class Lei{
    String name;
    public Lei(){}
    public Lei(String name) {
        this.name = name;
    }

    public void doSome(){
        System.out.println(name);
    }
}
