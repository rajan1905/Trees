package tree.binarytrees.node;

public class Node<E>
{
	private E data;
	private Node<E> leftChild;
	private Node<E> rightChild;
	private boolean isTraversed;
	private Node<E> parent;
	
	public E getData() 
	{
		return data;
	}
	
	public void setData(E data) 
	{
		this.data = data;
	}
	
	public Node<E> getLeftChild() 
	{
		return leftChild;
	}
	
	public void setLeftChild(Node<E> leftChild)
	{
		this.leftChild = leftChild;
	}
	
	public Node<E> getRightChild() 
	{
		return rightChild;
	}
	
	public void setRightChild(Node<E> rightChild) 
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
	
	public Node<E> getParent() 
	{
		return parent;
	}
	
	public void setParent(Node<E> parent) 
	{
		this.parent = parent;
	}
}
