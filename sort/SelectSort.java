package sort;

import java.util.Scanner;
/*
* 选择排序：
* 每一次从这堆参与比较的数据当中找出最小值
* 拿着这个最小值和“参与比较的这堆数据最前面的元素”交换位置
* 选择排序比冒泡排序好在：每一次的交换位置都是有意义的
* */
public class SelectSort {
    public static void main(String[] args) {
        int cout = 0;
        Scanner s = new Scanner(System.in);
        int[] number = new int[5];
        for (int i = 0; i < number.length; i ++){
            number[i] = s.nextInt();
        }
        for (int i = 0; i < number.length - 1; i ++){
            int k = i;
            for (int j = i + 1; j < number.length; j ++){
                if (number[j] < number[k]){
                    k = j;
                }
            }
            if (k != i) {
                int temp = number[i];
                number[i] = number[k];
                number[k] = temp;
            }
        }
        for (int i = 0; i < number.length; i ++){
            System.out.println(number[i]);
        }
    }
}
