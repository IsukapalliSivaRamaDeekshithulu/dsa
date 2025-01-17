package binaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class problemsOnBinaryTree {

	// problem-1 which is maximum in binarytree iterative way[same logic for min
	// value and searching an element in a binarytree]
	int maxElement(BinaryTreeNode root) {

		int result = Integer.MIN_VALUE;
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			BinaryTreeNode temp = queue.remove();
			if (result < temp.data)
				result = temp.data;
			// is it need to check temp!=null
			if (temp.left != null)
				queue.add(temp.left);
			if (temp.right != null)
				queue.add(temp.right);
		}
		return result;

	}

	// max value using recursion
	int maxElementRecursion(BinaryTreeNode root) {
		int maxValue = Integer.MIN_VALUE;
		if (root != null) {
			int left = maxElementRecursion(root.left);
			int right = maxElementRecursion(root.right);
			maxValue = left > right ? left : right;
			if (root.data > maxValue)
				maxValue = root.data;
		}
		return maxValue;
	}

	// min vaue using recurssion
	int minElementRecursion(BinaryTreeNode root) {
		int minValue = Integer.MAX_VALUE;
		if (root != null) {
			int left = minElementRecursion(root.left);
			int right = minElementRecursion(root.right);
			minValue = left > right ? right : left;
			if (root.data < minValue)
				minValue = root.data;
		}
		return minValue;
	}

	// searchelement recursion
	Boolean searchElementRecursion(BinaryTreeNode root, int num) {
		if (root == null)
			return false;
		if (root.data == num)
			return true;
		return searchElementRecursion(root.left, num) || searchElementRecursion(root.right, num);
	}

	// size in recursion
	int sizeRecursion(BinaryTreeNode root) {
		if (root == null)
			return 0;
		int left = sizeRecursion(root.left);
		int right = sizeRecursion(root.right);
		return 1 + left + right;
	}

	// max height or depth in recursion
	int maxHeightOrDepthRecursion(BinaryTreeNode root) {
		if (root == null)
			return 0;
		int left = maxHeightOrDepthRecursion(root.left);
		int right = maxHeightOrDepthRecursion(root.right);
		return left > right ? left + 1 : right + 1;
	}

}
