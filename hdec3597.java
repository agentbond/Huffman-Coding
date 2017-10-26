// SINGH AMBUJ  cs610 3597 PrP option1 : Huffman Coding

import java.util.*;
import java.lang.*;
import java.io.*;

public final class hdec3597 {
	
public static void main(String[] args) throws IOException {
	
  if (args.length != 1) {
    System.err.println("Please provide correct input parameters");
     System.exit(1);
    return;
	}
		
	//	henc3597 hencobject = new henc3597();
	//	File file;
	//	hencobject.name(file);
		
		//file = inFile;
		String s=args[0];
		s=s.substring(0,s.lastIndexOf("."));
		File encoded  = new File(args[0]);
		File decoded = new File(s);
		
		
		
		FileInputStream fi = new FileInputStream(encoded);
		BufferedInputStream bi = new BufferedInputStream(fi);
		read3597 in = new read3597(bi);
		
		FileOutputStream fo =	new FileOutputStream(decoded);
		
		OutputStream out = new BufferedOutputStream(fo);
		
		
		try {
			codelen3597 compcode = readtable(in);
			
			makeCode3597 code = compcode.binaryheap3597();
			
			decodefile(code, in, out);
		} finally {
			out.close();
			in.close();
		}
	}
static codelen3597 readtable(read3597 in) throws IOException {
	 int[] totalcode = new int[257];
	 
	  for (int i = 0; i < totalcode.length; i++) {
		  
		int value = 0;
		for (int j = 0; j < 8; j++)
		value = (value << 1) | in.readNoEof();
		
		totalcode[i] = value;
			}
	  return new codelen3597(totalcode);
		}


static void decodefile(makeCode3597 cd, read3597 inp, OutputStream outst) throws IOException {
	decoding3597 dec = new decoding3597(inp);
	dec.encrptree = cd;
	
	while (true) {
	int symbol = dec.read();
	if (symbol == 256) 
		break;
	outst.write(symbol);
	}
}
	
}