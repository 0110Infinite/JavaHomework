public class BubbleSort {

    // BubbleSort类的main方法：程序的入口点
    public static void main(String[] args) {
        int[] array = {2, 4, 8, 6, 18, 55, 1}; // 定义一个待排序的整数数组
        bubbleSort(array); // 调用bubbleSort方法进行排序
        for (int i = 0; i < array.length; i++) { // 遍历打印排序后的数组
            System.out.print(array[i] + " ");
        }
    }

    // bubbleSort方法：实现冒泡排序算法
    public static void bubbleSort(int[] array) {
        // 检查数组是否为null
        if (array == null) {
            System.out.println("该数组不存在");
            return;
        }
        int len = array.length; // 获取数组的长度
        for (int i = 0; i < len - 1; i++) { // 外层循环控制排序的轮数
            boolean swap = false; // 设置一个标志，用于检测本轮是否发生了交换
            // 内层循环进行实际的比较和交换操作
            for (int j = 0; j < len - i - 1; j++) {
                // 比较相邻的两个元素，如果它们的顺序错误就交换它们
                if (array[j] > array[j + 1]) {
                    int temp = array[j]; // 使用临时变量来存储array[j]
                    array[j] = array[j + 1]; // 把array[j + 1]的值赋给array[j]
                    array[j + 1] = temp; // 把临时变量的值赋给array[j + 1]，完成交换
                    swap = true; // 表示发生了交换
                }
            }
            // 如果一轮比较中没有发生交换，说明数组已经排序完成，可以提前结束排序
            if (swap == false) {
                return;
            }
        }
    }
}
