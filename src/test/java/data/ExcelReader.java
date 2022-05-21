package data;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {


    public FileInputStream input;

    public FileInputStream readInput() throws FileNotFoundException {

        File path= new File(System.getProperty("user.dir")+"\\src\\test\\java\\data\\ExcelUserData.xlsx");
        FileInputStream input= new FileInputStream(path);
        return  input;

    }



    public  Object[][] readXSLS() throws IOException {

      FileInputStream  input=readInput();
        XSSFWorkbook workbook= new XSSFWorkbook(input);
        XSSFSheet sheet=workbook.getSheetAt(0);
        int TotalRows=sheet.getLastRowNum()+1;
        int col=4;
        String [][] arr=new String[ TotalRows][col];
        for (int i = 0; i < TotalRows ; i++) {

            for (int j = 0; j < col; j++) {

                XSSFRow row=sheet.getRow(i);
                arr [i][j]=row.getCell(j).toString();

            }

        }
        workbook.close();
        return  arr;
    }
}
