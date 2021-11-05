package process;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ReadDictionary {
	


	String[] sar;
	private String[] wordDictionaryArray;
	
	static String s = "";
	public ReadDictionary() throws FileNotFoundException {	
		  
				
		    
			
			Scanner in = new Scanner(new File("Text/Main.txt"));
			while(in.hasNext())
			s += in.nextLine();	
			in.close();
//			String[] wordDictionaryArray = s.split(" ");
//			for (int i = 0; i < wordDictionaryArray.length; i++) 
//				{
//				}
			
			
			
    }
	public static String getS() {
		
		return s;
	}
	public static void setS(String s) {
		ReadDictionary.s = s;
	}
	

	
			

}


