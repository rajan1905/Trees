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
		int nodesCount = 100;
		Random random = new Random();
		
		for(int i=0;i<nodesCount;i++)
		{
			bst.addNode(random.nextInt(1000));
		}
		
		System.out.println("Iterative Post Order Traversal took time : "+benchmarkPostOrderTraversal(bst));
		System.out.println("Recursively Post Order Traversal took time : "+benchmarkPostOrderTraversalRecursively(bst));
	}
	
	public static long benchmarkPostOrderTraversal(BST bst)
	{
		long result = 0;
		int count = 10;
		
		for(int i=0 ; i<count ; i++)
		{
			
		}
		
		return result/10;
	}
	
	public static long benchmarkPostOrderTraversalRecursively(BST bst)
	{
		long result = 0;
		int count = 10;
		
		for(int i=0 ; i<count ; i++)
		{
			
		}
		
		return result/10;
	}

}
