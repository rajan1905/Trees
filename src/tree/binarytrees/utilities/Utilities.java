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
	public static boolean hasRightChild(Node node)
	{
		return node.getRightChild() != null;
	}
	
	/**
	 * 
	 * @param node
	 * @return
	 */
	public static List<Integer> postOrderTraversal(Node node)
	{
		List<Integer> result = new ArrayList<>();
		Stack<Node> stack = new Stack<>();
		Node nextNode = null;
		Node parent = node;
		boolean traversedAll = false;
		
		if(countChild(node) == 0)
		{
			result.add(node.getData());
		}
		else
		{
			stack.push(node);
			
			while(!traversedAll)
			{
				if(hasRightChild(node))
				{
					stack.push(node.getRightChild());
					nextNode = node.getRightChild();
				}
				
				if(hasLeftChild(node))
				{
					stack.push(node.getLeftChild());
					nextNode = node.getLeftChild();
				}
				
				node.setIsTraversed(true);
				
				if(nextNode == null)
				{
					Node poppedNode = null;
					boolean keepPopping = true;
					
					while(keepPopping)
					{
						poppedNode = stack.pop();
						
						if(poppedNode == parent)
						{
							traversedAll = true;
							keepPopping = false;
						}
						
						if(poppedNode.getIsTraversed() == false)
						{
							stack.push(poppedNode);
							node = poppedNode;
							keepPopping = false;					
						}
						else
						{
							result.add(poppedNode.getData());
						}
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
