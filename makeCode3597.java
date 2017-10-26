// SINGH AMBUJ  cs610 3597 PrP option1 : Huffman Coding

import java.util.*;
import java.lang.*;
import java.io.*;

public final class makeCode3597 {
	
public final notLeaf3597 root;
private List<List<Integer>> coded;
	
	public makeCode3597(notLeaf3597 root, int maxlimit) {
		this.root = root;
		
		coded = new ArrayList<List<Integer>>();  
		
		for (int i = 0; i < maxlimit; i++)
		coded.add(null);
		makelist(root, new ArrayList<Integer>()); 
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		toString("", sb, root);
		return sb.toString();
	}
	
	
	
	private static void toString(String pre, StringBuilder sb, Node3597 node) {
		
		if (node instanceof notLeaf3597) {
			notLeaf3597 intNode = (notLeaf3597)node;
			
			toString(pre + "0", sb, intNode.leftChild);
			toString(pre + "1", sb, intNode.rightChild);
			
		} else if (node instanceof leaf3597) 
		{
			sb.append(String.format("code is  %s: sym is  %d%n", pre, ((leaf3597)node).symbol));
		} else 
		{
			throw new AssertionError("Invalid node");
		}
	}
	
	private void makelist(Node3597 node, List<Integer> pre) {
		if (node instanceof notLeaf3597) {
			notLeaf3597 intNode = (notLeaf3597)node;
			
			pre.add(0);
			makelist(intNode.leftChild , pre);
			pre.remove(pre.size() - 1);
			
			pre.add(1);
			makelist(intNode.rightChild, pre);
			pre.remove(pre.size() - 1);
			
		} else if (node instanceof leaf3597) {
			leaf3597 leaf = (leaf3597)node;
			coded.set(leaf.symbol, new ArrayList<Integer>(pre));
			
		} else {}
			
		
	}
	
	
	public List<Integer> calcode(int sym) {
		if (sym < 0)
			throw new IllegalArgumentException("Invalid entry made");
		else if (coded.get(sym) == null)
			throw new IllegalArgumentException("NULL");
		else
			return coded.get(sym);
	}

	
}