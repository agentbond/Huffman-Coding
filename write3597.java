// SINGH AMBUJ  cs610 3597 PrP option1 : Huffman Coding

import java.util.*;
import java.lang.*;
import java.io.*;

public final class write3597 {
	
	private OutputStream outp;
	private int recbyte;
	private int compbits;
	
   public write3597(OutputStream out) {
		outp = out;
		recbyte = 0;
		compbits = 0;
	}
	
	public void write(int l) throws IOException {
		recbyte = (recbyte << 1) | l;
		compbits++;
		if (compbits == 8) {
			outp.write(recbyte);
			recbyte = 0;
			compbits = 0;
		}
	}
	
	
	public void close() throws IOException {
		while (compbits != 0)
			write(0);
		outp.close();
	}
	
}