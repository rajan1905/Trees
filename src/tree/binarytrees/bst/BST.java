package tree.binarytrees.bst;

import tree.binarytrees.node.Node;
import tree.interfaces.Tree;

public class BST implements Tree
{
	private Node parent = null;
	
	public boolean addNode(int data)
	{
		boolean result = false;
		Node traverse = null;
		
		Node node = new Node();
		node.setData(data);
		
		if(parent == null)
		{
			parent = node;
		}
		else
		{	
			traverse = parent;
			
			while(traverse.getData() != data && !result)
			{
				if(data < traverse.getData())
				{
					if(traverse.getLeftChild() == null)
					{
						traverse.setLeftChild(node);
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
						result = true;
					}
					else
					{
						traverse = traverse.getRightChild();
					}
				}
			}
		}
		
		return result;
	}
	
	public Node getParent() 
	{
		return parent;
	}
}
