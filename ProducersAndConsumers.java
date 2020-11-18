package homework20;
//使用生产者和消费者模式实现，交替输出：
//	假设只有两个线程，输出以下结果：
//		t1-->1
//		t2-->2
//		t1-->3
//		t2-->4
//		t1-->5
//		t2-->6
//		....
//
//		要求：必须交替，并且t1线程负责输出奇数。t2线程负责输出偶数。
//		两个线程共享一个数字，每个线程执行时都要对这个数字进行：++
//
//		public class Num {
//			int i;
//		}
//
//		synchronized(num){
//			if(num是奇数){
//				num.wait();
//			}
//			// 输出偶数
//			// notifyAll()
//		}
//
//		synchronized(num){
//			if(num是偶数){
//				num.wait();
//			}
//			// 输出奇数
//			// notifyAll();
//		}
public class Test {
    public static void main(String[] args) {
        Number number = new Number(1);
        Thread thread1 = new Thread(new Producer(number));
        Thread thread2 = new Thread(new Customer(number));
        thread1.setName("t1");
        thread2.setName("t2");
        thread1.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();
    }
}
class Producer implements Runnable{
    private Number number;
    public Producer(){}
    public Producer(Number number){
        this.number = number;
    }
    @Override
    public void run() {
        while (true){
            synchronized (number){
                if (number.getNumber() % 2 == 0){
                    try {
                        number.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + "-->" + number.getNumber());
                int num = number.getNumber();
                number.setNumber(++ num);
                number.notify();
            }
        }
    }
}
class Customer implements Runnable{
    private Number number;
    public Customer(){}
    public Customer(Number number){
        this.number = number;
    }
    @Override
    public void run() {
        while (true){
            synchronized (number){
                if (number.getNumber() % 2 == 1){
                    try {
                        number.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + "-->" + number.getNumber());
                int num = number.getNumber();
                number.setNumber(++ num);
                number.notify();
            }
        }
    }
}
class Number{
    private int number;
    public Number(){}
    public Number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
