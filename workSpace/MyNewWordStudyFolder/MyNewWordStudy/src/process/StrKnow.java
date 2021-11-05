package process;

public class StrKnow {
	public static String s = "";

	public String getS() {
		return s;
	}

	public void setS(String s) {
		
		StrKnow.s = StrKnow.s + " " + s;
		System.out.println("StrKnow+++++" + StrKnow.s);
	}



	
	
	
}
