// SINGH AMBUJ  cs610 3597 PrP option1 : Huffman Coding

import java.util.*;
import java.lang.*;
import java.io.*;

public final class CalFrequency3597 {
	
private static class validnode implements Comparable<validnode> {
		
    public final Node3597 node;
	public final int lowestSymbol;
	public final long frequency;  
		
		
	public validnode(Node3597 nd, int lowSym, long freq) {
		node = nd;
		lowestSymbol = lowSym;
		frequency = freq;
	}
		
		public int compareTo(validnode other) {
			if (frequency < other.frequency)
				return -1;
			else if (frequency > other.frequency)
				return 1;
			else if (lowestSymbol < other.lowestSymbol)
				return -1;
			else if (lowestSymbol > other.lowestSymbol)
				return 1;
			else
				return 0;
		}
		
	}
	
private int[] fre;

public CalFrequency3597(int[] freqs) {
fre = freqs.clone();  
	}
	
public int getSymbolLimit() {
return fre.length;
}
	
public int get(int symbol) {
return fre[symbol];
	}
	
	
public void set(int symbol, int freq) {
fre[symbol] = freq;
}
	
public void increment(int symbol) {
fre[symbol]++;
}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < fre.length; i++)
			sb.append(String.format("%d\t%d%n", i, fre[i]));
		return sb.toString();
	}
	
	
	public makeCode3597 codeprep3597() {
	Queue<validnode> pq = new PriorityQueue<validnode>();
	
	for (int i = 0; i < fre.length; i++) {
	if (fre[i] > 0)
	pq.add(new validnode(new leaf3597(i), i, fre[i]));
		}
		
		
for (int i = 0; i < fre.length && pq.size() < 2; i++) {
if (fre[i] == 0)
pq.add(new validnode(new leaf3597(i), i, 0));
}
			
  while (pq.size() > 1) {
    validnode x = pq.remove();
    validnode y = pq.remove();
    pq.add(new validnode(
    new notLeaf3597(x.node, y.node),
     Math.min(x.lowestSymbol, y.lowestSymbol), x.frequency + y.frequency));
	}
		

	return new makeCode3597((notLeaf3597)pq.remove().node, fre.length);
	}
	
}