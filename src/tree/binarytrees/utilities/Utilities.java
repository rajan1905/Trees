package tree.binarytrees.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import tree.binarytrees.node.Node;

/**
 *  This class is a Utility class for BinaryTree
 *  and it's variations.
 * @param <E>
 */
public class Utilities 
{
	/**
	 * Calculates the number of child this particular {@link Node}
	 * has.
	 * 
	 * @param node
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static int countChild(Node node)
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
	@SuppressWarnings("rawtypes")
	public static boolean hasLeftChild(Node node)
	{
		return node.getLeftChild() != null;
	}
	
	/**
	 * Checks for the right child of this {@link Node}.
	 * 
	 * @param node
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean hasRightChild(Node node)
	{
		return node.getRightChild() != null;
	}
	
	/**
	 * 
	 * @param node
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List postOrderTraversal(Node node)
	{
		List result = new ArrayList<>();
		Stack<Node> stack = new Stack<>();
		Node nextNode = null;
		
		if(countChild(node) == 0)
		{
			result.add(node.getData());
		}
		else
		{
			stack.push(node);
			
			while((!stack.isEmpty() && !(countChild(node) == 0)))
			{
				if(hasRightChild(node))
				{
					stack.push(node.getLeftChild());
					nextNode = node.getLeftChild();
				}
				
				if(hasLeftChild(node))
				{
					stack.push(node.getRightChild());
					
					if(nextNode == null)
						nextNode = node.getRightChild();
				}
				
				node.setIsTraversed(true);
				
				if(nextNode == null)
				{
					Node poppedNode = null;
					
					while(true)
					{
						poppedNode = stack.pop();
						
						if(poppedNode.getIsTraversed() == false)
						{
							stack.push(poppedNode);
							node = poppedNode;
							break;
							
						}
						result.add(poppedNode);
					}
				}
				else
				{
					node = nextNode;
					nextNode = null;
				}
			
			}
		}
		return result;		
	}
	
}
