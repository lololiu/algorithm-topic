
/**
 * 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排列，每一列都按照从上到下递增的顺序
 * 排列，请完成一个函数，输入这样一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 思路: 从右上角那个整数开始比较，要找的数比它小则列数减一，比它大则行数减一，然后继续比较下一个右上角的整数
 */

public class no2 {

	public static boolean findNum(int[][] array, int row, int comuln, int num) {
		if (row < 0 || comuln < 0)
			return false;
		int rTemp = 0, cTemp = comuln - 1;
		while (rTemp < row && cTemp >= 0) {
			if (array[rTemp][cTemp] == num)
				return true;
			else if (array[rTemp][cTemp] > num)
				cTemp--;
			else
				rTemp++;
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] arrays = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
		System.out.println("find result: " + findNum(arrays, 4, 4,16));
	}
}