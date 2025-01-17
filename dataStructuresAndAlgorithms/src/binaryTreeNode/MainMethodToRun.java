package binaryTreeNode;

import java.util.ArrayList;

public class MainMethodToRun {

	public static void main(String[] args) {
		System.out.println("creating an sample tree ");
		
        BinaryTreeNode one=new BinaryTreeNode(1);
        BinaryTreeNode two=new BinaryTreeNode(2);
        BinaryTreeNode three=new BinaryTreeNode(3);
        BinaryTreeNode four=new BinaryTreeNode(4);
        BinaryTreeNode five=new BinaryTreeNode(5);
        BinaryTreeNode six=new BinaryTreeNode(6);
        BinaryTreeNode seven=new BinaryTreeNode(7);
        BinaryTreeNode eight=new BinaryTreeNode(8);
        BinaryTreeNode nine=new BinaryTreeNode(9);
        BinaryTreeNode ten=new BinaryTreeNode(10);
        one.left=two;
        one.right=three;
        two.left=four;
        three.left=five;
        three.right=six;
        four.left=seven;
        four.right=eight;
        two.right=nine;
        nine.left=ten;
        
        ArrayList<Integer> result=BinaryTreeTraversal.preOrderTraversalIt(one);
        System.out.println(result);
        ArrayList<Integer> result1=BinaryTreeTraversal.inOrderTraversalIt(one);
        System.out.println(result1);
        ArrayList<Integer> result2=BinaryTreeTraversal.postOrderTraversalIt(one);
        System.out.println(result2);
        

	}

}
