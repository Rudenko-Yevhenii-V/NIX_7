package process;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class WriteNewWordToDictionary {
	
	public WriteNewWordToDictionary(String str1) {
		while(str1.contains("  ")) {
			String replace = str1.replace("  ", " ");
			str1=replace;
		}
		str1 = str1 + "\n";
	System.out.println(str1);
		String[] strList = str1.split(" ");
		for(String s:strList){
			if(s.equals(" ")){
				
			}
		}
	        ArrayList<String> str = new ArrayList<String>();
	        Collections.addAll(str, strList);
	    	for(String s:str){
				if(s.equals(" ")){
					str.remove(s);
				}
	    	}
			
	        
	        try
	        {
	            OutputStream f = new FileOutputStream("Text/Main.txt", true);
	            OutputStreamWriter writer = new OutputStreamWriter(f);
	            BufferedWriter out = new BufferedWriter(writer);
	            for(int i = 0; i < str.size(); i++)
	            {
	                out.write(str.get(i) + " ");
	                out.flush();
	            }
	        }
	        catch(IOException ex)
	        {
	            System.err.println(ex);
	        }
	}

}
