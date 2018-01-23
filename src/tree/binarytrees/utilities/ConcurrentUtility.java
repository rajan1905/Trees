package tree.binarytrees.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import tree.binarytrees.node.Node;
import tree.interfaces.Tree;

public class ConcurrentUtility 
{
	public static final ConcurrentUtility INSTANCE = new ConcurrentUtility();
	private static ExecutorService threadPool = Executors.newCachedThreadPool();
	
	class PostOrderTraversal implements Callable<List<Integer>>
	{
		Node node;
		
		public PostOrderTraversal(Node n) 
		{
			node = n;
		}
		
		@Override
		public List<Integer> call() throws Exception 
		{
			return Utilities.postOrderTraversal(node);
		}
		
	}
	
	
	public static List<Integer> postOrderTraversalConcurrent(Tree tree) throws InterruptedException, ExecutionException
	{
		List<Integer> result = new ArrayList<>();
		Node root = tree.getRoot();
		
		Callable<List<Integer>> processLeftTree = INSTANCE.new PostOrderTraversal(root.getLeftChild());
		Callable<List<Integer>> processRightTree = INSTANCE.new PostOrderTraversal(root.getRightChild());
		
		Future<List<Integer>> leftTreeResult = threadPool.submit(processLeftTree);
		Future<List<Integer>> rightTreeResult = threadPool.submit(processRightTree);
		
		result.addAll(leftTreeResult.get());
		result.addAll(rightTreeResult.get());
		result.add(root.getData());
		
		return result;
	}
	
}
