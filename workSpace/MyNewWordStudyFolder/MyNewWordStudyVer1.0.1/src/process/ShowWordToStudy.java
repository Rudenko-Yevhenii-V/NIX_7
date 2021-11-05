package process;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ShowWordToStudy {
		
	String s;
	String setWord = "";
	String[] textArray;
	String[] wordDictionaryArray;
	
			public ShowWordToStudy(String s) 
			{
				this.s = s;
			}
			public ShowWordToStudy(String[] textArray) 
			{
				
			this.textArray = textArray;
				
			}
			public  void check() throws IOException {
				ReadDictionary rd = new ReadDictionary();
				s = rd.getS();
				String[] wordDictionaryArray = s.split(" ");
														
				for (int i = 0; i < textArray.length; i++) {
					for (int j = 0; j < wordDictionaryArray.length; j++) {
						if(textArray[i].equalsIgnoreCase(wordDictionaryArray[j])){
							textArray[i] = "";
						}
					}
					
				}
				for (int i = 0; i < textArray.length; i++) {
					setWord = setWord + " " + textArray[i];
				}
				
			}
			public String getSetWord() {
			//??????? ??????? ??????
				while(setWord.contains("  ")) {
					String replace = setWord.replace("  ", " ");
					setWord=replace;
				}
			//??????? ??????? ??????
				
				WriteNewWordToStudy wrts = new WriteNewWordToStudy(setWord);
//!!!!!!!!!!!!! write to txt  WriteNewWordToStudy wrt = new WriteNewWordToStudy(setWord);
				return setWord;
			}
			
				
			
		
}
