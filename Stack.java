//数组模拟栈数据结构
public class Test {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push("你好");
        myStack.push(new Object());
        myStack.push("1");
        myStack.push("2");
        myStack.push("3");
        myStack.push("4");
        myStack.push("5");
        myStack.pop();
        myStack.pop();
        myStack.pop();
        myStack.pop();
        myStack.pop();
        myStack.pop();
        myStack.push("1");
        myStack.pop();
        myStack.pop();
    }
}

class MyStack {
    Object[] elements;
    int index;

    public MyStack() {
        index = -1;
        elements = new Object[5];
    }

    public void push(Object object) {
        if (index >= 4) {
            System.out.println("栈已满，压栈失败");
            return;
        }
        index ++;
        elements[index] = object;
        System.out.println("压栈成功，压入" + object +"，栈针指向" + index);
    }

    public void pop() {
        if(index <= -1){
            System.out.println("栈已空，弹栈失败");
           return;
        }
        System.out.print("弹栈成功，弹出" + elements[index]);
        elements[index] = null;
        index --;
        System.out.println("，栈针指向" + index);

    }
}
