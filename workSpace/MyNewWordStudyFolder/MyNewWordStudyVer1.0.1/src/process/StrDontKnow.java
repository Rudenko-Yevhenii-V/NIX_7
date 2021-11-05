package process;

public class StrDontKnow {
	static String s = "";

	public String getS() {
		return s;
	}

	public void setS(String s) {
		
		StrDontKnow.s = StrDontKnow.s + "\n" + s;
		
		System.out.println("StrDontKnow+++++" + " " + StrDontKnow.s);
	}

	
	

}
