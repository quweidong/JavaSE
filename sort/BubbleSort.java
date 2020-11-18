package sort;

import java.util.Scanner;
/*
* 冒泡排序算法
* 每一次循环结束之后，都要找到最大的数据，放到参与比较的这堆数据的最右边（冒出最大的那个气泡），这个最大的数后续不需要参与比较
*核心：拿着左边的数字和右边的数字比对，当左边 > 右边的时候，交换位置
* */
public class BubbleSort {
    public static void main(String[] args) {
        int cout = 0;
        Scanner s = new Scanner(System.in);
        int[] number = new int[7];
        for (int i = 0; i < number.length; i ++){
            number[i] = s.nextInt();
        }
        for (int i = 0; i < number.length - 1; i ++){
            for(int j = 0; j < number.length - i - 1; j ++){
                if(number[j] > number[j + 1]){
                    int temp = number[j];
                    number[j] = number[j + 1];
                    number[j + 1] = temp;
                }
                cout ++;
            }
        }
        System.out.println("共循环" + cout);
        for (int i = 0; i < number.length; i ++){
            System.out.println(number[i]);
        }
    }
}
