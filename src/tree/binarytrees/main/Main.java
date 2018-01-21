package tree.binarytrees.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import tree.binarytrees.bst.BST;
import tree.binarytrees.utilities.Utilities;

public class Main 
{

	public static void main(String[] args) 
	{
		BST bst = new BST();
		int[] data = {14,10,13,12,11,16,19,17,18};

		for(int i=0;i<data.length;i++)
		 {
		 	bst.addNode(data[i]);
		 }

		//List<Integer> list=Utilities.postOrderTraversal(bst.getParent());

		//System.out.println("Level of the tree is : "+ Utilities.treeLevel(bst));
		
		System.out.println("Printing Tree : \n" + Utilities.printBinaryTree(bst));
	}
	
	public static long benchmarkPostOrderTraversal(BST bst)
	{
		long result = 0;
		int count = 5;
		
		for(int i=0 ; i<count ; i++)
		{
			long start = System.nanoTime();
			Utilities.postOrderTraversal(bst.getParent());
			long end = System.nanoTime();
			
			result += end-start;
		}
		
		return result/count;
	}
	
	public static long benchmarkPostOrderTraversalRecursively(BST bst)
	{
		long result = 0;
		int count = 5;
		List<Integer> resultList = new ArrayList<>();
		
		for(int i=0 ; i<count ; i++)
		{
			long start = System.nanoTime();
			Utilities.postOrderTraversalRecursively(bst.getParent(),resultList);
			long end = System.nanoTime();
			
			result += end-start;
		}
		
		return result/count;
	}

}
