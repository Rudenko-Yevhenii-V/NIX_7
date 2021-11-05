import com.gtranslate.Language;
import com.gtranslate.Translator;
import org.w3c.dom.ls.LSOutput;

public class Test {


    public static void main(String[] args) {
       int a = 3 ;
       int b  = 2;
       int minVal = (a < b) ? a : b;

        Translator translate = Translator.getInstance();
        String text = translate.translate("I am programmer", Language.ENGLISH, Language.RUSSIAN);
        System.out.println(text); //Eu sou programador
        System.out.println(minVal);
    }
}

