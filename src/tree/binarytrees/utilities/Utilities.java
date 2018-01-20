package tree.binarytrees.utilities;

import java.util.ArrayList;
import java.util.List;

import tree.binarytrees.node.Node;

/**
 *  This class is a Utility class for BinaryTree
 *  and it's variations.
 * @param <E>
 */
public class Utilities<E> 
{
	/**
	 * Calculates the number of child this particular {@link Node}
	 * has.
	 * 
	 * @param node
	 * @return
	 */
	public static int countChild(Node<?> node)
	{
		int result = 0;
		
		if(node.getLeftChild() != null)
			result++;
		
		if(node.getRightChild() != null)
			result++;
		
		return result;
	}
	
	/**
	 * Checks for the left child of this {@link Node}.
	 * 
	 * @param node
	 * @return
	 */
	public static boolean hasLeftChild(Node<?> node)
	{
		return node.getLeftChild() != null;
	}
	
	/**
	 * Checks for the right child of this {@link Node}.
	 * 
	 * @param node
	 * @return
	 */
	public static boolean hasRightChild(Node<?> node)
	{
		return node.getRightChild() != null;
	}
	
	/**
	 * 
	 * @param node
	 * @return
	 */
	public List<E> postOrderTraversal(Node<?> node)
	{
		List<E> result = new ArrayList<>();
		
		return result;		
	}
	
}
