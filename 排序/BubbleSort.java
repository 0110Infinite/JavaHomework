

public class BubbleSort {
	public static void main (String[] args) {
		int[] array = {2, 4, 8, 6, 18, 55, 1};
		bubbleSort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
	public static void bubbleSort(int[] array) {	
		// 检查数组是否为null
		if (array == null) {
			System.out.println("该数组不存在");
			return;
		}
		int len = array.length;
		for (int i = 0; i < len - 1; i++) {
			// 重置swap标志为false
			boolean swap = false;
			// 进行一次冒泡，把当前最大的数移动到正确的位置
			for (int j = 0; j < len - i - 1; j++) {
				//len - 1是防止下标越界；
				//再减去i是因为没一次外循环就找到一个最大值
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					// 表示发生了交换
					swap = true;
				}
			}
			// 如果一次交换都没有发生，说明数组已经排序完成
			if (swap == false) {
				return ;
			}
		}
	}
}
