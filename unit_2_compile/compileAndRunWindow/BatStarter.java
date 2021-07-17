import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BatStarter {
           public  void  start(String s, JTextArea jTextArea){
               String s1 = s;
               int count = 1;
               try {
                 Process process = Runtime.getRuntime().exec(s1);
                   StringBuilder output = new StringBuilder();
                   BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                   String line;
                   while((line = reader.readLine()) != null){
                       count++;
                       if(count == 3){
                           output.append(line + "\n");
                       }
                       output.append(line + "\n");
                   }
                   int exitVal = process.waitFor();
                   if(exitVal == 0){
                       System.out.println("Success");
                       jTextArea.setText(output.toString());
                       System.out.println(output);
                   }else {
                       System.out.println("Something wrong");
                   }

               } catch (IOException | InterruptedException e) {
                   e.printStackTrace();
               }
           }
}