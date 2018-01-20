package tree.binarytrees.node;

public class Node<E>
{
	private E data;
	private Node<?> leftChild;
	private Node<?> rightChild;
	private Node<?> isTraversed;
	private Node<?> parent;
	
	public E getData() 
	{
		return data;
	}
	
	public void setData(E data) 
	{
		this.data = data;
	}
	
	public Node<?> getLeftChild() 
	{
		return leftChild;
	}
	
	public void setLeftChild(Node<?> leftChild)
	{
		this.leftChild = leftChild;
	}
	
	public Node<?> getRightChild() 
	{
		return rightChild;
	}
	
	public void setRightChild(Node<?> rightChild) 
	{
		this.rightChild = rightChild;
	}
	
	public Node<?> getIsTraversed() 
	{
		return isTraversed;
	}
	
	public void setIsTraversed(Node<?> isTraversed)
	{
		this.isTraversed = isTraversed;
	}
	
	public Node<?> getParent() 
	{
		return parent;
	}
	
	public void setParent(Node<?> parent) 
	{
		this.parent = parent;
	}
}
