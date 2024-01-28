public class YangHui {

    // YangHui类的main方法：程序的入口点
    public static void main(String[] args){
        int n = 13; // 杨辉三角的层数，可以修改这个值来生成不同大小的杨辉三角
        int[][] yanghui = new int[n][]; // 声明一个二维数组来存储杨辉三角

        // 外层循环：遍历杨辉三角的每一层
        for (int i = 0; i < n; i++) {
            yanghui[i] = new int[i+1]; // 初始化当前层的数组大小为i+1
            // 内层循环：计算当前层的每一个元素
            for (int j = 0; j < i+1; j++) {
                if (j == 0 || j == i){ // 如果是当前层的第一个或最后一个元素
                    yanghui[i][j] = 1; // 则设置为1
                } else { // 否则，它是上一层相邻两个元素之和
                    yanghui[i][j] = yanghui[i-1][j-1] + yanghui[i-1][j];
                }
            }
        }

        // 打印杨辉三角
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < yanghui[i].length; j++) {
                System.out.print(yanghui[i][j]+ "\t"); // 打印当前元素，后面跟一个制表符以便对齐
            }
            System.out.println(); // 每打印完一层后换行
        }
    }
}
