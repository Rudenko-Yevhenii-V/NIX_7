package process;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class ReadToStudy {

	static String s = "";
	LinkedList<String> lls;
	public static void ReadDictionary() throws FileNotFoundException {
			Scanner in = new Scanner(new File("Text/toStudy.txt"));
			while(in.hasNext())
			s +=  in.nextLine();
			in.close();
    }
	public static String getS() throws IOException {
		ReadDictionary();
		return "studied it. let's check : \n" + s;
	}
	public static void setS(String s) {
		ReadDictionary.s = s;
	}
}
