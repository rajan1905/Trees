package tree.binarytrees.main;

import java.util.List;

import tree.binarytrees.bst.BST;
import tree.binarytrees.utilities.Utilities;

public class Main 
{

	public static void main(String[] args) 
	{
		BST bst = new BST();
		int[] data = {14,10,13,12,11,16,19,17,18};
		
		for(int i=0;i<data.length;i++)
		{
			bst.addNode(data[i]);
		}
		
		List<Integer> list=Utilities.postOrderTraversal(bst.getParent());
		
		System.out.println(list);
	}

}
