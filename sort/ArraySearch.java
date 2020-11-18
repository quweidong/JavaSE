package sort;

import java.util.Scanner;
/*
* 二分法查找：
* 二分法查找算法基于排序的基础之上（没有排序的数据是无法查找的）
* 二分法查找的终止条件：一直折半，直到中间的那个元素正好是被查找的元素
* */
public class ArraySearch {
    public static void main(String[] args) {
        System.out.println("请输入要查找的数");
        Scanner s = new Scanner(System.in);
        int target = s.nextInt();
        int[] number = {1, 23, 43, 55, 77};
        int value = ArrayUtil(number, target);
        System.out.println(target + "元素的下标是" + value);
    }

    public static int ArrayUtil(int[] number, int target) {
        int begin = 0;
        int end = number.length - 1;
        while (begin <= end) {
            if (target < number[(begin + end) / 2]) {
                end = ((begin + end) / 2) - 1;
            } else if (target > number[(begin + end) / 2]) {
                begin = ((begin + end) / 2) + 1;
            } else {
                return (begin + end) / 2;
            }
        }
        System.out.println("该数字不存在");
        return -1;
    }
}
