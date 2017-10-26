// SINGH AMBUJ  cs610 3597 PrP option1 : Huffman Coding

import java.util.*;
import java.lang.*;
import java.io.*;

public final class decoding3597 {
	
private read3597 inp;
public makeCode3597 encrptree;
	
	
public decoding3597(read3597 input) {
inp = input;
	}
	
 public int read() throws IOException {
	if (encrptree == null)
	throw new NullPointerException("Code tree is null");
		
	notLeaf3597 latnode = encrptree.root;
	while (true) {
			
	int temp = inp.readNoEof();
	Node3597 nextNode;
			
	if      (temp == 0) nextNode = latnode.leftChild;
	else if (temp == 1) nextNode = latnode.rightChild;
	else throw new AssertionError("Invalid value ");
			
	if (nextNode instanceof leaf3597)
	return ((leaf3597)nextNode).symbol;
	
	else if (nextNode instanceof notLeaf3597)
	latnode = (notLeaf3597)nextNode;
			
	else{}
	
	}
	}
	
}