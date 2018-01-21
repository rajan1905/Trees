package tree.binarytrees.utilities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

import tree.binarytrees.bst.BST;
import tree.binarytrees.node.Node;
import tree.interfaces.Tree;

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
	 * Checks whether the {@link Node} is a leaf node
	 * with no childs.
	 * 
	 * @param node
	 * @return
	 */
	public static boolean isALeaf(Node node)
	{
		return countChild(node) == 0 ? true : false;
	}
	
	/**
	 * Iterates a Binary Tree by Post Order Traversal
	 * mechanics.
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
		
		if(isALeaf(node))
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
	
	
	public static void postOrderTraversalRecursively(Node node, List<Integer> result)
	{
		if(node != null)
		{
			postOrderTraversalRecursively(node.getLeftChild(), result);
			postOrderTraversalRecursively(node.getRightChild(), result);
			result.add(node.getData());
		}
	}
	
	/**
	 * Iterates a Binary Tree by Pre Order Traversal
	 * mechanics.
	 * 
	 * @param node
	 * @return
	 */
	public static List<Integer> preOrderTraversal(Node node)
	{
		List<Integer> result = new ArrayList<>();
		
		return result;		
	}
	
	public static List<Node> printBinaryTree(Tree node)
	{
		String tab = "\t";
		List<Node> levelList = new ArrayList<>();
		int index = 0;
		int base = 2;
		int travelledLevel = 0;
		Node parentNode = node.getParent();
		int treeLevel = treeLevel(node);
		
		levelList.add(parentNode);
				
		while(travelledLevel != treeLevel)
		{
			// For every level, index = level-1
			// Traverse all elements in that index region such that
			
			// For level = 1 index = 0 so add left and right childs 
			// of all elements for index = 0
			// For level = 2 index = 
			int indexRange = (int) Math.pow(base, travelledLevel);
			
			for(int i = 0 ; i < indexRange ; i++)
			{
				Node nodeToBeProcessed = levelList.get(index+i);
				
				if(nodeToBeProcessed != null)
				{
					if(hasLeftChild(nodeToBeProcessed))
					{
						levelList.add(nodeToBeProcessed.getLeftChild());
					}
					else
					{
						levelList.add(null);
					}
					
					if(hasRightChild(nodeToBeProcessed))
					{
						levelList.add(nodeToBeProcessed.getRightChild());
					}
					else
					{
						levelList.add(null);
					}	
				}
				else
				{
					levelList.add(null);
					levelList.add(null);
				}
			}
			
			index += indexRange;
			travelledLevel++;
		}
		
		int travelledToIndex = 0;
		
		for(int i = 0 ; i < treeLevel ; i++)
		{
			for(int space = 0 ; space < treeLevel-i ; space++)
			{
				System.out.print(tab);
			}
			
			for(int in = 0 ; in < Math.pow(base, i) ; in++)
			{
				Node nn = levelList.get(travelledToIndex + in);
				
				if(nn == null)
					System.out.print("-");
				else
					System.out.print(nn.getData());
				
				System.out.print(tab+tab);
				
			}
			System.out.println();
			travelledToIndex += Math.pow(base, i);
		}
		
		return levelList;
	}
	
	/*public static List<Node> breadthFirstSearch(Node parent , Node findNode)
	{
		
	}*/
	
	public static int treeLevel(Tree bst)
	{
		int level = 0;
		Node bstParentNode = bst.getParent();
		List<Node> leafNodes = bst.getLeafNodes();		
		
		Iterator<Node> listIterator = leafNodes.iterator();
		
		while(listIterator.hasNext())
		{
			Node leaf = listIterator.next();
			int levelFromPresentLeaf = 0;
			
			while(leaf.getParent() != bstParentNode)
			{
				levelFromPresentLeaf++;
				leaf = leaf.getParent();
			}
			
			if(levelFromPresentLeaf > level)
			{
				level = levelFromPresentLeaf + 1;
				levelFromPresentLeaf = 0;
			}
			
		}
		
		return level;
	}
	
}
