package tree.interfaces;

import java.util.List;

import tree.binarytrees.node.Node;

public interface Tree 
{
	public boolean addNode(int data);
	public boolean deleteNode(int data);	
	public List<Node> getLeafNodes();
	public Node getParent();
	public int getNodesCount(); 
}
