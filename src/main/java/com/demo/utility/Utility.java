package com.demo.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.demo.main.WebDriverManager;
import com.google.common.io.Files;

public class Utility extends WebDriverManager{
	
	public static FileInputStream f;
	public static XSSFWorkbook w;
	public static XSSFSheet s;

	public static String getRandomEmail() {
		Random r = new Random();
		return "qauser" + r.nextInt() + "@gmail.com";
	
	}
	
	public static int getRandomInt() {
		Random r = new Random();
		return r.nextInt();
	}
	

	public static Properties getPropertiesFile() {
		FileReader reader = null;
		try {
			reader = new FileReader(System.getProperty("user.dir") + "/src/test/resources/" + "config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Properties pr = new Properties();
		try {
			pr.load(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pr;
	}

	public static String readExcelData(int i, int j) {


		String output = "";
		try {
			String userDir = System.getProperty("user.dir") + "/src/test/resources/";
            f = new FileInputStream(userDir + "UserData.xlsx");
			w = new XSSFWorkbook(f);
		
			s = w.getSheet("Sheet1");
			Row r = s.getRow(i);
			Cell c = r.getCell(j);
			output = c.getStringCellValue();
			
		} catch (Exception e) {

		}
		return output;

	}
	
	/*public static void waitfor(int value) {
		try {
			Thread.sleep(value * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	public  static Double getPrice(WebElement el) {
		return Double.parseDouble(el.getText().replace("$", ""));
	}
	public static void screenshot(String testName) throws IOException {
		String finaldate = java.time.Clock.systemUTC().instant().toString().replace(":", "_");

		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		String extention = ".png";
		String filename = testName.concat("_" + finaldate).concat(extention);
		File DestFile = new File(System.getProperty("user.dir") + "/src/test/resources/screenshots/" + filename);
		Files.copy(SrcFile, DestFile);
	}

	

}
