package binaryTreeNode;

import java.util.*;

public class BinaryTreeTraversal {

	// recursion
	static void preOrderTraversal(BinaryTreeNode node) {
		if (node != null) {
			System.out.println(node.data);
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
	}

	static void inOrderTraversal(BinaryTreeNode node) {
		if (node != null) {
			inOrderTraversal(node.left);
			System.out.println(node.data);
			inOrderTraversal(node.right);
		}
	}

	static void postOrderTraversal(BinaryTreeNode node) {
		if (node != null) {
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.println(node.data);
		}
	}

	// iterative
	public static ArrayList<Integer> preOrderTraversalIt(BinaryTreeNode cur) {
		ArrayList<Integer> preOrder = new ArrayList<>();
		Stack<BinaryTreeNode> stack = new Stack<>();

		while (cur != null || !stack.isEmpty()) {
			while (cur != null) {
				stack.push(cur);
				preOrder.add(cur.data);
				cur = cur.left;
			}
			cur = stack.pop();
			cur = cur.right;
		}

		return preOrder;
	}

	static ArrayList<Integer> inOrderTraversalIt(BinaryTreeNode cur) {
		ArrayList<Integer> inOrder = new ArrayList<>();
		Stack<BinaryTreeNode> stack = new Stack<>();

		while (cur != null || !stack.isEmpty()) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			inOrder.add(cur.data);
			cur = cur.right;
		}

		return inOrder;
	}

	static ArrayList<Integer> postOrderTraversalIt(BinaryTreeNode cur) {
		ArrayList<Integer> postOrder = new ArrayList<>();
		Stack<BinaryTreeNode> stack = new Stack<>();

		while (cur != null || !stack.isEmpty()) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			BinaryTreeNode temp = stack.peek().right;
			if (temp == null) {
				temp = stack.peek();
				stack.pop();
				postOrder.add(temp.data);
				while (!stack.isEmpty() && temp == stack.peek().right) {
					temp = stack.peek();
					stack.pop();
					postOrder.add(temp.data);
				}
			} else {
				cur = temp;
			}
		}

		return postOrder;
	}
 
	//levelOrderIterativeway 
	static ArrayList<ArrayList<Integer>> levelOrderTraversal(BinaryTreeNode root) {

		if (root == null) {
			return null;
		}

		ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> cur = new ArrayList<>();
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);

		while (!queue.isEmpty()) {
			BinaryTreeNode temp = queue.peek();
			if (temp != null) {
				cur.add(temp.data);
				queue.remove();
				if (temp.left != null)
					queue.add(temp.left);
				if (temp.right != null)
					queue.add(temp.right);
			} else {
				ArrayList<Integer> ccur = new ArrayList<>(cur);
				answer.add(ccur);
				cur.clear();
				if (!queue.isEmpty())
					queue.add(null);
			}
		}
		return answer;

	}
	
	static ArrayList<Integer> boundryLevelTraversal(BinaryTreeNode node) {

		ArrayList<Integer> result = new ArrayList<>();
		if (node == null) {
			return result;
		}

		if (!isLeaf(node)) {
			result.add(node.data);
		}

		addLeftBoundary(node, result);
		addLeaf(node, result);
		addRightBoundary(node, result);

		return result;
	}

	private static void addRightBoundary(BinaryTreeNode node, ArrayList<Integer> result) {
		ArrayList<Integer> temp = new ArrayList<>();
		BinaryTreeNode current = node.right;
		while (current != null) {
			if (!isLeaf(current)) {
				temp.add(current.data);
			}
			if (current.right != null) {
				current = current.right;
			} else {
				current = current.left;
			}
		}

		for (int i = temp.size() - 1; i >= 0; i--) {
			result.add(temp.get(i));
		}

	}

	private static void addLeaf(BinaryTreeNode node, ArrayList<Integer> result) {
		// TODO Auto-generated method stub
		if (isLeaf(node)) {
			result.add(node.data);
			return;
		}

		if (node.left != null) {
			addLeaf(node.left, result);
		}
		if (node.right != null) {
			addLeaf(node.right, result);
		}

	}

	private static void addLeftBoundary(BinaryTreeNode node, ArrayList<Integer> result) {

		BinaryTreeNode current = node.left;
		while (current != null) {
			if (!isLeaf(current)) {
				result.add(current.data);
			}
			if (current.left != null) {
				current = current.left;
			} else {
				current = current.right;
			}
		}

	}

	private static boolean isLeaf(BinaryTreeNode node) {
		return node.left == null && node.right == null;
	}

	// zigzagTraversal
	static List<List<Integer>> zigZagLevelOrder(BinaryTreeNode root) {

		List<List<Integer>> result = new ArrayList<>();

		if (root == null) {
			return result;
		}

		Queue<BinaryTreeNode> nodesQueue = new LinkedList<>();
		nodesQueue.add(root);
		boolean leftToRight = false;

		while (!nodesQueue.isEmpty()) {
			int size = nodesQueue.size();

			List<Integer> row = new ArrayList<>();

			for (int i = 1; i <= size; i++) {
				BinaryTreeNode node = nodesQueue.poll();

				row.add(node.data);

				if (node.left != null) {
					nodesQueue.add(node.left);
				}
				if (node.right != null) {
					nodesQueue.add(node.right);
				}
			}

			if (leftToRight)
				Collections.reverse(row);
			leftToRight = !leftToRight;
			result.add(row);
		}

		return result;
	}
	
	////diagonal 
	static ArrayList<Integer>  diagnoalTraversal(BinaryTreeNode root){
		ArrayList<Integer> result=new ArrayList<Integer>();
		if(root == null) {
			return result;
		}
		
		Queue<BinaryTreeNode> queue=new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty() ) {
			BinaryTreeNode temp=queue.poll();
			while(temp != null) {
				result.add(temp.data);
				if(temp.left!=null) queue.add(temp.left);
				temp=temp.right;
			}
			
		}
		
		
		return result;
	}

   
}
