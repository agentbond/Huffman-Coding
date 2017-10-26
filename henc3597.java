// SINGH AMBUJ  cs610 3597 PrP option1 : Huffman Coding

import java.util.*;
import java.lang.*;
import java.io.*;

public final class henc3597 {

	public static void main(String[] args) throws IOException {
		
 if (args.length != 1) {
  System.err.println("Please provide correct input parameters");
  System.exit(1);
  return;
		}
		
	File  inFile= new File(args[0]);
	File outFile = new File(inFile+".huff");
	
				
	// For input
	FileInputStream fis = new FileInputStream(inFile);
	InputStream in = new BufferedInputStream(fis);
		
		
	// For output
	FileOutputStream fos = new FileOutputStream(outFile);
	BufferedOutputStream bos = new BufferedOutputStream(fos);
		
	write3597 out = new write3597(bos);
	
	
	CalFrequency3597 frequency = calculatefrequency3597(inFile);
		
	frequency.increment(256);  
		
		
	makeCode3597 code = frequency.codeprep3597();
		
		
	codelen3597 charcode = new codelen3597(code, 257);
	
	code = charcode.binaryheap3597();
		
	try {
	writeoutputcode3597(out, charcode);
	compressFile(code, in, out);
	}
	
	finally {
	out.close();
	in.close();
		}
	}
	
	static void compressFile(makeCode3597 code, InputStream in, write3597 out) throws IOException {
		encoding3597 encode = new encoding3597(out);
		encode.codeTree = code;
		while (true) {
			int b = in.read();
		  
			if (b == -1)
			break;
				
			encode.write(b);
			}
			encode.write(256);
		}
	
	static void writeoutputcode3597(write3597 out, codelen3597 charcode) throws IOException {
	
	for (int i = 0; i < charcode.maxlimit(); i++) {
	int value = charcode.totallen(i);
			
		
	for (int p = 7; p >= 0; p--)
	out.write((value >>> p) & 1);
		}
	} 
	
	private static CalFrequency3597 calculatefrequency3597(File file) throws IOException {
		
	CalFrequency3597 frequency = new CalFrequency3597(new int[257]);
	InputStream input = new BufferedInputStream(new FileInputStream(file));
	try {
	while (true) {
	int r = input.read();
	
	if (r == -1)
	break;
	
	frequency.increment(r);
	}
	}
	
	finally {
	input.close();
	}
	return frequency;
	}
	

}