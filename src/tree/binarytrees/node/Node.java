package tree.binarytrees.node;

public class Node
{
	private int data;
	private Node leftChild;
	private Node rightChild;
	private boolean isTraversed;
	private Node parent;
	
	public int getData() 
	{
		return data;
	}
	
	public void setData(int data) 
	{
		this.data = data;
	}
	
	public Node getLeftChild() 
	{
		return leftChild;
	}
	
	public void setLeftChild(Node leftChild)
	{
		this.leftChild = leftChild;
	}
	
	public Node getRightChild() 
	{
		return rightChild;
	}
	
	public void setRightChild(Node rightChild) 
	{
		this.rightChild = rightChild;
	}
	
	public boolean getIsTraversed() 
	{
		return isTraversed;
	}
	
	public void setIsTraversed(boolean isTraversed)
	{
		this.isTraversed = isTraversed;
	}
	
	public Node getParent() 
	{
		return parent;
	}
	
	public void setParent(Node parent) 
	{
		this.parent = parent;
	}
	
	@Override
	public String toString()
	{
		return data+"";
	}
}
