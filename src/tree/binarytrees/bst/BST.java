package tree.binarytrees.bst;

import java.util.ArrayList;
import java.util.List;

import tree.binarytrees.node.Node;
import tree.interfaces.Tree;

public class BST implements Tree
{
	private Node root = null;
	private List<Node> leafNodes = new ArrayList<>();
	private int nodesCount = 0;
	
	public int getNodesCount() 
	{
		return nodesCount;
	}

	public boolean addNode(int data)
	{
		boolean result = false;
		Node traverse = null;
		
		Node node = new Node();
		node.setData(data);
		
		if(root == null)
		{
			root = node;
		}
		else
		{	
			traverse = root;
			
			while(traverse.getData() != data && !result)
			{
				if(data < traverse.getData())
				{
					if(traverse.getLeftChild() == null)
					{
						traverse.setLeftChild(node);
						node.setParent(traverse);
						result = true;
					}
					else
					{
						traverse = traverse.getLeftChild();
					}
				}
				
				if(data > traverse.getData())
				{
					if(traverse.getRightChild() == null)
					{
						traverse.setRightChild(node);
						node.setParent(traverse);
						result = true;
					}
					else
					{
						traverse = traverse.getRightChild();
					}
				}
			}
		}
		
		// Compute leaf nodes as they are added
		// The logic being whenever a new Node is added its a leaf node,
		// so add it to the list. As new Node comes check whether the 
		// added node has any parent int the list. If it has any parent 
		// remove from the list
		
		leafNodes.add(node);
		
		if(leafNodes.contains(node.getParent()))
		{
			leafNodes.remove(node.getParent());
		}
		
		if(result == true)
		{
			nodesCount++;
		}
		
		return result;
	}
	
	public boolean deleteNode(int data)
	{
		boolean deleted = false;
		
		return deleted;
	}
	
	public List<Node> getLeafNodes() 
	{
		return leafNodes;
	}

	public Node getRoot() 
	{
		return root;
	}
}
