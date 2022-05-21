package helper;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class ReadData {


    public static void captureScreenshoot(WebDriver driver,String ScreenshootName){


        Path path= Paths.get("./screenshoots",ScreenshootName+".png");
        try {
            Files.createDirectories(path.getParent());
            FileOutputStream out=new FileOutputStream(path.toString());
            out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
            out.close();
        } catch (IOException e) {
            System.out.println("Test is failed");
        }


    }

}
