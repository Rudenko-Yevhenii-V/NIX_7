package process;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class SetWordToField {

	//public static void main(String[] args) {
		
	static int count = 0;
	static int countStop = 1;
	static String[] lls;
	
		
	ReadToStudy rts = new ReadToStudy();
		
		String s = " one";
		
		
		
		public String takeOneWord() throws Exception{
			
			if(countStop < 2){
				
			countStop++;
				
				s = rts.getS();
			
			lls = s.split(" ");
			
			}
			
			//int count = 0;
			 int maxCount;
			 
			//String[] wordDictionaryArray = s.split(" ");
			

			//s = "two";
			maxCount = lls.length;
			//System.out.println(" maxCount " + maxCount);
			if(count < maxCount){
				s = lls[count];
				count++;
				//System.out.println(" count  " + count);
				
			}else{
				
			s = "Empty";
		//	System.out.println("Empty");
			}
				
			
			//s = lls.getFirst();
										//System.out.println(s);
			return s;
			
			
		}
	public String getS() throws Exception {
		s = takeOneWord();
		return s;
	}


	public void setS(String s) {
		this.s = s;
	}
		
		
		// TODO Auto-generated method stub

	

}
