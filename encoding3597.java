// SINGH AMBUJ  cs610 3597 PrP option1 : Huffman Coding

import java.util.*;
import java.lang.*;
import java.io.*;

public final class encoding3597 {
private write3597 output;

public makeCode3597 codeTree;
	
public encoding3597(write3597 o) {
 output = o;
}
		
public void write(int s) throws IOException {
	
List<Integer> bitlist = codeTree.calcode(s);
for (int i : bitlist)
output.write(i);
	}
	
}