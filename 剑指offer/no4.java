/***
 * 给出一个链表的头结点，要求从尾到头反向打印出链表的值
 *
 * 思路： 1.使用栈先存储结点，再依次后进先出pop出值
 *        2.递归思想 要注意递归层级过深会导致函数调用栈溢出问题
 */
public class no4 {

	public static class ListNode {
		ListNode nextNode;
		int value;

		public ListNode(ListNode node, int value) {
			this.nextNode = node;
			this.value = value;
		}
	}

	public static void printListReverse(ListNode list) {
		if (list == null)
			return;
		if (list.nextNode != null) {
			printListReverse(list.nextNode);
		}
		System.out.print(list.value + " ");
	}

	public static void main(String[] args) {
		ListNode node = new ListNode(null, 0);
		ListNode node1 = new ListNode(node, 1);
		ListNode node2 = new ListNode(node1, 2);
		ListNode node3 = new ListNode(node2, 3);
		ListNode node4 = new ListNode(node3, 4);
		ListNode node5 = new ListNode(node4, 5);
		ListNode node6 = new ListNode(node5, 6);
		ListNode node7 = new ListNode(node6, 7);
		ListNode node8 = new ListNode(node7, 8);

		printListReverse(node8);
		System.out.println("\n");
		printListReverse(node);
		System.out.println("\n");
		printListReverse(node6);
	}
}
