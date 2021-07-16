package src.nix.ry.rudenko.rOffice;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
public class RyExel {

    public void CreateExel(){
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("NIX7");

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("files/NIX7ExeleFile.xls");
            workbook.write(fileOutputStream);
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println(" Exel created");
    }
}
