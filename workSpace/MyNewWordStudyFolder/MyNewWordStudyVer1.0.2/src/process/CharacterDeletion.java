package process;

public class CharacterDeletion {
	
	static String st = " FFFFFF ";
	static String st2 = "";

	public CharacterDeletion(String s) {
				char [] myCharArray = s.toCharArray(); //
					for (int i = 0; i < myCharArray.length; i++)
			{
			if(myCharArray[i] == '.' || myCharArray[i] == ',' || myCharArray[i] == '!'
						|| myCharArray[i] == '?' || myCharArray[i] == '(' || myCharArray[i] == ')' 
						|| myCharArray[i] == ':' || myCharArray[i] == ';' || myCharArray[i] == '+' 
						|| myCharArray[i] == '%' || myCharArray[i] == '{' || myCharArray[i] == '}' 
						|| myCharArray[i] == '[' || myCharArray[i] == ']' || myCharArray[i] == '='
						|| myCharArray[i] == '"' || myCharArray[i] == '-' || myCharArray[i] == '|'
						|| myCharArray[i] == '1' || myCharArray[i] == '2' || myCharArray[i] == '3' 
						|| myCharArray[i] == '4' || myCharArray[i] == '5' || myCharArray[i] == '6' 
						|| myCharArray[i] == '7' || myCharArray[i] == '8' || myCharArray[i] == '9'
					|| myCharArray[i] == '«' || myCharArray[i] == '»')

				{
					myCharArray[i] = (' ');
				}

			}
		
		String str = String.valueOf(myCharArray);
		
		
		while(str.contains("\n")) {
			String replace = str.replace("\n", " ");
			str=replace;
		}
		
		String[] array = str.split(" ");
		
		
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if(array[i].equals(array[j])){
					array[j] = " ";
				}
			}
		}
		for (int i = 0; i < array.length; i++) {
			st2 = st2 + " " +  array[i];
		}
		while(st2.contains("  ")) {
			String replace = st2.replace("  ", " ");
			st2=replace;
		}
		
		st= st2;
	}

	public static String getSt() {
		return st;
	}

	public static void setSt(String st) {
		CharacterDeletion.st = st;
	}
	
	
}
