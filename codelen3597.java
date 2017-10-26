// SINGH AMBUJ  cs610 3597 PrP option1 : Huffman Coding

import java.util.*;
import java.lang.*;
import java.io.*;



public final class codelen3597 {
	
private int[] totalcode;
	
public codelen3597(int[] codeLens) {
	totalcode = codeLens.clone();

	Arrange3597 ar = new Arrange3597();
	totalcode =  ar.arrange(totalcode);
		
		int currentLevel = totalcode[totalcode.length - 1];
		int numNodesAtLevel = 0;
		
		for (int i = totalcode.length - 1; i >= 0 && totalcode[i] > 0; i--) 
		{
		int tot = totalcode[i];
		while (tot < currentLevel) {
			
			numNodesAtLevel /= 2;
				currentLevel--;
			} 
		
			numNodesAtLevel++;
		}
		while (currentLevel > 0) {
			if (numNodesAtLevel % 2 != 0)
				throw new IllegalArgumentException("Invalid tree");
		
			numNodesAtLevel /= 2;
			currentLevel--;
		}
		
	
		System.arraycopy(codeLens, 0, totalcode, 0, codeLens.length);
	}
	
	
	public codelen3597(makeCode3597 tree, int symbolLimit) {
	  totalcode = new int[symbolLimit];
		buildCodeLengths(tree.root, 0);
	}
	
	
	
	private void buildCodeLengths(Node3597 node, int down)
	{
		if (node instanceof notLeaf3597)
		{
			notLeaf3597 internalNode = (notLeaf3597)node;
			
			buildCodeLengths(internalNode.leftChild , down + 1);
			buildCodeLengths(internalNode.rightChild, down + 1);
		} 
		
		else if (node instanceof leaf3597) 
		{
			int symbol = ((leaf3597)node).symbol;
		
		
			totalcode[symbol] = down;
		} else {
		
		}
	}
		
	public int maxlimit() {
		return totalcode.length;
	}
	
 public int totallen(int symbol) {
		return totalcode[symbol];
	}
 
 private static int max(int[] array) {
		int result = array[0];
		for (int x : array)
			result = Math.max(x, result);
		return result;
	}
	
	public makeCode3597 binaryheap3597() {
		List<Node3597> nodes = new ArrayList<Node3597>();
		for (int i = max(totalcode); i >= 0; i--) {  
		List<Node3597> newNodes = new ArrayList<Node3597>();
			
		
	 if (i > 0) {
	 for (int j = 0; j < totalcode.length; j++) 
	 {
	 if (totalcode[j] == i)
	newNodes.add(new leaf3597(j));
	}
	}
			
			
	for (int j = 0; j < nodes.size(); j += 2)
	newNodes.add(new notLeaf3597(nodes.get(j), nodes.get(j + 1)));
	nodes  = newNodes;
		}
		
	return new makeCode3597((notLeaf3597)nodes.get(0), totalcode.length);
	}

}