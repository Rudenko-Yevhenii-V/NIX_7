package process;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;


public class WriteNewWordToStudy {
	String s = null;
	
	public WriteNewWordToStudy(String str1) {
		s = str1;
		while(str1.contains("  ")) {
			String replace = str1.replace("  ", " ");
			str1=replace;
		}
		str1 = str1 + "\n";
		File file=new File("Text/toStudy.txt");
		file.mkdirs();
		try
		{
		    BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		    bw.write(str1);
		    bw.close();
		} catch (IOException e)
		{
		    e.printStackTrace();
		}
	    }
	
	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}
	
 }
	
		
	
	
	
	


