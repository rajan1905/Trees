package tree.binarytrees.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;

import tree.binarytrees.bst.BST;
import tree.binarytrees.utilities.ConcurrentUtility;
import tree.binarytrees.utilities.Utilities;

public class Main 
{

	public static void main(String[] args)
	{
		BST bst = new BST();
		/*int[] data = {14,10,13,12,11,16,19,17,18};

		for(int i=0;i<data.length;i++)
		 {
		 	bst.addNode(data[i]);
		 }*/
		
		Random random = new Random();
		int size = 10000000/2;
		for(int i=0;i<size;i++)
			bst.addNode(random.nextInt(size));
		
		
		//List<Integer> list=Utilities.postOrderTraversal(bst.getParent());

		//System.out.println("Level of the tree is : "+ Utilities.treeLevel(bst));
		benchmarkPostOrderTraversal(bst);
		try {
			benchmarkPostOrderTraversalThreaded(bst);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void benchmarkPostOrderTraversal(BST bst)
	{
		long result = 0;
		int count = 1;
		
		for(int i=0 ; i<count ; i++)
		{
			long start = System.currentTimeMillis();
			Utilities.postOrderTraversal(bst.getRoot());
			long end = System.currentTimeMillis();
			
			result += end-start;
			
			System.out.println("Non Threaded with time : " +result/(count));
		}
	}
	
	public static void benchmarkPostOrderTraversalThreaded(BST bst) throws InterruptedException, ExecutionException
	{
		long result = 0;
		int count = 1;
		
		for(int i=0 ; i<count ; i++)
		{
			long start = System.currentTimeMillis();
			ConcurrentUtility.postOrderTraversalConcurrent(bst);
			long end = System.currentTimeMillis();
			
			result += end-start;
			System.out.println("Threaded with time : " +result/(count));
		}
	}
	
	public static long benchmarkPostOrderTraversalRecursively(BST bst)
	{
		long result = 0;
		int count = 5;
		List<Integer> resultList = new ArrayList<>();
		
		for(int i=0 ; i<count ; i++)
		{
			long start = System.nanoTime();
			Utilities.postOrderTraversalRecursively(bst.getRoot(),resultList);
			long end = System.nanoTime();
			
			result += end-start;
		}
		
		return result/count;
	}

}
