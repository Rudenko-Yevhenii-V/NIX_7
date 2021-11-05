package process;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class ReadToStudy {

	String[] sar;
	private String[] wordDictionaryArray;
	
	static String s = "";
	LinkedList<String> lls;
	public static void ReadDictionary() throws FileNotFoundException {	
		
				
		    
			
			Scanner in = new Scanner(new File("Text/toStudy.txt"));
			while(in.hasNext())
			s += in.nextLine();	
			in.close();
			System.out.println(s);
//			String[] wordDictionaryArray = s.split(" ");
//			
//			Collections.addAll(lls, wordDictionaryArray);
			
			
			
    }
	public static String getS() throws IOException {
		ReadDictionary();
		return s;
	}

	public static void setS(String s) {
		ReadDictionary.s = s;
	}
//	public LinkedList<String> getLls() {
//		return lls;
//	}
//	public void setLls(LinkedList<String> lls) {
//		this.lls = lls;
//	}
	
	

}
