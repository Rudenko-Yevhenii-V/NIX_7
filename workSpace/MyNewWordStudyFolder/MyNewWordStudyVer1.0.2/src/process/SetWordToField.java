package process;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class SetWordToField {

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

			 int maxCount;

			maxCount = lls.length;

			if(count < maxCount){
				s = lls[count];
				count++;
			}else{
				
			s = "Empty";
					}

			return s;
			
			
		}
	public String getS() throws Exception {
		s = takeOneWord();
		return s;
	}


	public void setS(String s) {
		this.s = s;
	}

}
