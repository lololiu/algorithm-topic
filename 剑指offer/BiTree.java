/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历
 * 和中序遍历的结果中都不含重复的数字。
 *／
public class BiTree {

	class TreeNode {
		private String content;
		private TreeNode leftChild;
		private TreeNode rightChild;

		public TreeNode(String content, TreeNode left, TreeNode right) {
			this.content = content;
			this.leftChild = left;
			this.rightChild = right;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public void setLeftChild(TreeNode left) {
			this.leftChild = left;
		}

		public TreeNode getLeftChild() {
			return leftChild;
		}

		public void setRightChild(TreeNode right) {
			this.rightChild = right;
		}

		public TreeNode getRightChild() {
			return rightChild;
		}
	}

	// --------------- 二叉树遍历 --------------------

	public TreeNode createBiTree() {
		TreeNode a = new TreeNode("A", null, null);
		TreeNode b = new TreeNode("B", null, null);
		TreeNode f = new TreeNode("F", null, null);
		TreeNode c = new TreeNode("C", a, b);
		TreeNode e = new TreeNode("E", null, f);
		TreeNode d = new TreeNode("D", c, e);
		return d;
	}

	public void preorder(TreeNode tree) {
		if(tree==null) return;
		visit(tree);
		if (tree.getLeftChild() != null)
			preorder(tree.getLeftChild());
		if (tree.getRightChild() != null)
			preorder(tree.getRightChild());
	}

	public void inorder(TreeNode tree) {
		if(tree==null) return;
		if (tree.getLeftChild() != null)
			inorder(tree.getLeftChild());
		visit(tree);
		if (tree.getRightChild() != null)
			inorder(tree.getRightChild());
	}

	public void postorder(TreeNode tree) {
		if (tree.getLeftChild() != null)
			postorder(tree.getLeftChild());
		if (tree.getRightChild() != null)
			postorder(tree.getRightChild());
		visit(tree);
	}

	public void visit(TreeNode tree) {
		if(tree==null||tree.getContent()==null) return;
		System.out.print(tree.getContent()+" ");
	}

	// ------------- 重建二叉树 -----------------

	public TreeNode rebuildBiTree(String[] preorderList, String[] inorderList) {
		if (preorderList == null || inorderList == null || preorderList.length <= 0 || inorderList.length <= 0) {
			return null;
		}
		TreeNode rootNode = new TreeNode(preorderList[0], null, null);
		int k = -1;
		for (int i = 0; i < inorderList.length; i++) {
			if (inorderList[i] == preorderList[0]) {
				k = i;
			}
		}
		if (k == -1) {
			throw new RuntimeException("输入不合法");
		}

		String[] leftInorderList = new String[k];
		String[] rightInorderList = new String[inorderList.length - k - 1];
		for (int m = 0; m < inorderList.length; m++) {
			if (m < k) {
				leftInorderList[m] = inorderList[m];
			}
			if (m > k) {
				rightInorderList[m - k - 1] = inorderList[m];
			}
		}

		String[] leftPreorderList = new String[leftInorderList.length];
		String[] rightPreorderList = new String[rightInorderList.length];
		for (int j = 1; j < preorderList.length; j++) {
			if (j < leftPreorderList.length + 1) {
				leftPreorderList[j - 1] = preorderList[j];
			}
			if (j >= leftPreorderList.length + 1) {
				rightPreorderList[j - leftPreorderList.length - 1] = preorderList[j];
			}
		}

		rootNode.leftChild = rebuildBiTree(leftPreorderList, leftInorderList);
		rootNode.rightChild = rebuildBiTree(rightPreorderList, rightInorderList);

		return rootNode;
	}

	public static void main(String[] args) {
		BiTree biTree = new BiTree();
		// TreeNode tree=biTree.createBiTree();
		// biTree.preorder(tree);

		String[] preArray = new String[] { "D", "C", "A", "B", "E", "F" };
		String[] inArray = new String[] { "A", "C", "B", "D", "E", "F" };
		TreeNode node = biTree.rebuildBiTree(preArray, inArray);
		biTree.preorder(node);
		System.out.println("");
		biTree.inorder(node);
		System.out.println("");
	}

}
