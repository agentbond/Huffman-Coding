// SINGH AMBUJ  cs610 3597 PrP option1 : Huffman Coding

import java.util.*;
import java.lang.*;
import java.io.*;

public final class read3597 {
	
 private InputStream inp;
 private int recbyte;
 private int bitsleft;
	
 public read3597(InputStream in) {
	inp = in;
	recbyte = 0;
	bitsleft = 0;
	}


	public int read() throws IOException {
		if (recbyte == -1)
		return -1;
		
		if (bitsleft == 0) {
		recbyte = inp.read();
		
		if (recbyte == -1)
			return -1;
			bitsleft = 8;
		}
		
		bitsleft--;
		return (recbyte >>> bitsleft) & 1;
	}
	

	public int readNoEof() throws IOException {
		int get = read();
		if (get != -1)
			return get;
		else
			throw new EOFException();
	}
	
 public void close() throws IOException {
		inp.close();
		recbyte = -1;
		bitsleft = 0;
	}
	
}