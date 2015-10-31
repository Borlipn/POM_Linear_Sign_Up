package core;

//import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
import org.junit.Ignore;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
//import org.openqa.selenium.support.ui.Select;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)


public class Sign_up_selenium_junits {
	
	static WebDriver driver = new FirefoxDriver();
	String text_case_id_01 = "test01_verify_title";
	String text_case_id_03 = "test10_verify_submit_form";
	String text_case_id_04 = "test11_verify_content_quotes";
	String text_case_id_05 = "test12_verify_content_current_city";
	String text_case_id_06 = "test13_verify_current_weather_image";
	String text_case_id_07 = "test131_verify_content_temperature";
	String text_case_id_08 = "test14_verify_content_date"; 
	String text_case_id_09 = "test15_verify_content_os";
	String text_case_id_10 = "test16_verify_content_browser";
	static String url = "http://learn2test.net/qa/apps/sign_up/v0/";
	String title_sign_up_expected = "Welcome to Sign Up";
	String fname = "Peter";
	String lname = "Loop";
	String email = "PeterL@gmail.com";
	String phone = "415 555-1212";
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterClass
	public static void setUpAfterClass() throws Exception {
		driver.quit();
	}
	
	@Before 
	public void setUpBefore() throws Exception {
		driver.get(url);
	}
	
	@After 
	public void setUpAfter() throws Exception {
	}
	
	@Test
	public void test01_verify_title() throws Exception {
		String title_sign_up_actual = driver.getTitle();

		if (title_sign_up_expected.equals(title_sign_up_actual)) {
			System.out.println("Test Case ID: \t\t" + text_case_id_01 + " - PASSED");
			System.out.println("Title Expected/Actual: \t" + title_sign_up_expected + "/" + title_sign_up_actual);
			System.out.println("=======================================");
		} else {
			System.out.println("Test Case ID: \t\t" + text_case_id_01 + " - FAILED");
			System.out.println("Title Expected/Actual: \t" + title_sign_up_expected + "/" + title_sign_up_actual);
			System.out.println("=======================================");
		}
	}
	
	@Test
	public void test02_05_verify_link() throws IOException {
		String csvFile_weblink = "./src/main/resources/WebLinks.csv";
		BufferedReader br_weblink = null;
		String line_weblink = null;
		String SplitBy_weblink = ",";
	    String test_case_id = null;
	    String title_expected = null;
	    String element_id = null;
	    

	    br_weblink = new BufferedReader(new FileReader(csvFile_weblink));
		
	    while ((line_weblink = br_weblink.readLine()) != null) {

			String[] csv_weblink = line_weblink.split(SplitBy_weblink);

			test_case_id = csv_weblink[0];
			title_expected = csv_weblink[1];
			element_id = csv_weblink[2];
			
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 driver.getWindowHandle();
		 driver.findElement(By.id(element_id)).click();
		
		
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 ArrayList<String> allTabs = new ArrayList<String>(driver.getWindowHandles());
		 driver.switchTo().window(allTabs.get(1));
		  
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 String title_actual = driver.getTitle();
		 driver.close();
		 driver.switchTo().window(allTabs.get(0));

		 if (title_expected.equals(title_actual)) {
		 	System.out.println("Test Case ID: \t\t" + test_case_id + " - PASSED");
		 	System.out.println("Title Expected/Actual: \t" + title_expected + "/" + title_actual);
		 	System.out.println("=======================================");
		 	} else {
			System.out.println("Test Case ID: \t\t" + test_case_id + " - FAILED");
			System.out.println("Title Expected/Actual: \t" + title_expected + "/" + title_actual);
			System.out.println("=======================================");
		}}
	    br_weblink.close(); 
	}
	
	@Test
	public void test06_09_verify_Errors() throws IOException {
		String csvFile_errs = "./src/main/resources/Errors_messages.csv";
		BufferedReader br_errs = null;
		String line_errs = null;
		String SplitBy_errs = ",";
	    String test_case_id_err = null;
	    String err_message_expected = null;
	    String err_message_actual = null;
	    int i=0;

	    br_errs = new BufferedReader(new FileReader(csvFile_errs));
	    
        while ((line_errs = br_errs.readLine()) != null) {
	    		i= i + 1;
	    		String[] csv_errs = line_errs.split(SplitBy_errs);
		
				test_case_id_err = csv_errs[0];
				err_message_expected = csv_errs[1];
				err_message_actual = csv_errs[2];

				driver.findElement(By.id("id_submit_button")).click();
				err_message_actual = driver.findElement(By.id("ErrorLine")).getText();

		if (err_message_expected.equals(err_message_actual)) {
			System.out.println("Test Case ID: \t\t" + test_case_id_err + " - PASSED");
			System.out.println("Error Expected/Actual: \t" + err_message_expected + "/" + err_message_actual);
			System.out.println("=======================================");
		} else {
			System.out.println("Test Case ID: \t\t" + test_case_id_err + " - FAILED");
			System.out.println("Error Expected/Actual: \t" + err_message_expected + "/" + err_message_actual);
			System.out.println("======================================="); 	}
		 if (i == 1) {
        	 driver.findElement(By.id("id_fname")).sendKeys(fname); 
         } else if (i == 2) {
				driver.findElement(By.id("id_lname")).sendKeys(lname);
         } else if (i == 3) {
			driver.findElement(By.id("id_email")).sendKeys(email);
         } else if (i == 4) {
			driver.findElement(By.id("id_phone")).sendKeys(phone);
         }}
	    br_errs.close();
	    driver.findElement(By.id("id_reset_button")).click();
	    }
		
	    @Test
		public void test10_verify_submit_form() throws Exception {
	    	driver.findElement(By.id("id_fname")).sendKeys(fname);
			driver.findElement(By.id("id_lname")).sendKeys(lname);
			driver.findElement(By.id("id_email")).sendKeys(email);
			driver.findElement(By.id("id_phone")).sendKeys(phone);
			driver.findElement(By.id("id_g_radio_01")).click();
			Select sel = new Select(driver.findElement(By.tagName("select")));
	        	   sel.selectByIndex(6);
	        driver.findElement(By.id("id_checkbox")).click();// Drop down combo box 
	        
			driver.findElement(By.id("id_submit_button")).click();
			
	
			String fname_conf_actual = driver.findElement(By.id("id_fname_conf")).getText();
			String lname_conf_actual = driver.findElement(By.id("id_lname_conf")).getText();
			String email_conf_actual = driver.findElement(By.id("id_email_conf")).getText();
			String phone_conf_actual = driver.findElement(By.id("id_phone_conf")).getText();
							
	
			if (fname.equals(fname_conf_actual) && lname.equals(lname_conf_actual) && email.equals(email_conf_actual) && phone.equals(phone_conf_actual)) {
			System.out.println("Test Case ID: \t\t" + text_case_id_03 + " - PASSED");
			System.out.println("First Expected/Actual: \t" + fname + "/"+ fname_conf_actual);
			System.out.println("Last Expected/Actual: \t" + lname + "/" + lname_conf_actual);
			System.out.println("Email Expected/Actual: \t" + email + "/" + email_conf_actual);
			System.out.println("Phone Expected/Actual: \t" + phone + "/" + phone_conf_actual);
			System.out.println("=======================================");
					} else {
			System.out.println("Test Case ID: \t\t" + text_case_id_03 + " - FAILED");
			System.out.println("First Name Expected/Actual: \t" + fname + "/"+ fname_conf_actual);
			System.out.println("Last Name Expected/Actual: \t" + lname + "/" + lname_conf_actual);
			System.out.println("Email Address Expected/Actual: \t" + email + "/" + email_conf_actual);
			System.out.println("Phone Number Expected/Actual: \t" + phone + "/" + phone_conf_actual);
			System.out.println("=======================================");
					}
			
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			//driver.findElement(By.id("id_back_button")).click(); 
	    			}
			
			@Test
			public void test11_verify_content_quotes() throws IOException {
				String quote = driver.findElement(By.id("id_quotes")).getText();
				if (quote != null && quote.length() < 103 && quote.length() > 36) {
					System.out.println("Test Case ID: \t\t" + text_case_id_04 + " - PASSED");
					System.out.println("Quote length: " + quote.length());
					System.out.println("=======================================");
				} else {
					System.out.println("Test Case ID: \t\t" + text_case_id_04 + " - FAILED");
					System.out.println("Quote length: " + quote.length());
					System.out.println("=======================================");
				} 
			}
			
			
			@Test
			public void test12_verify_content_current_city() throws Exception {
				String current_city = driver.findElement(By.id("id_current_location")).getText();
				if (current_city != null && current_city.length() > 4) {
					System.out.println("Test Case ID: \t\t" + text_case_id_05 + " - PASSED");
					System.out.println("Current_city name is: " + current_city);
					System.out.println("=======================================");
				} else {
					System.out.println("Test Case ID: \t\t" + text_case_id_05 + " - FAILED");
					System.out.println("Current_city name is NOT present! ");
					System.out.println("=======================================");
				} 
			}
			
			@SuppressWarnings("unused")
			@Test  
			public void test13_verify_current_weather_image() throws Exception {
				
				boolean current_weather_image = driver.findElement(By.xpath("//html/body/form/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td[5]/table/tbody/tr[2]/td[1]/img")).isDisplayed();
				if (current_weather_image = true) {
					System.out.println("Test Case ID: \t\t" + text_case_id_06 + " - PASSED");
					System.out.println("Current weather image is displayed ");
					System.out.println("=======================================");
				} else {
					System.out.println("Test Case ID: \t\t" + text_case_id_06 + " - FAILED");					
					System.out.println("Current_city name is NOT present! ");
					System.out.println("=======================================");
				} 
			}
			
			
			@Test
			public void test131_verify_content_temperature() throws Exception {
				String temperature = driver.findElement(By.id("id_temperature")).getText();
				if (temperature != null ) {
					System.out.println("Test Case ID: \t\t" + text_case_id_07 + " - PASSED");
					System.out.println("Current temperature is: " + temperature);
					System.out.println("=======================================");
				} else {
					System.out.println("Test Case ID: \t\t" + text_case_id_07 + " - FAILED");
					System.out.println("Current temperature is NOT present! ");
					System.out.println("=======================================");
				} 
			}
			
			@Test
			public void test14_verify_content_date() throws Exception {
				
				//Construct date/time object
			     Date dNow = new Date();
			      SimpleDateFormat ft = new SimpleDateFormat ("MMMM dd, yyyy ");
			      String expected_date = ft.format(dNow).toString();
			     			      
				String actual_date = driver.findElement(By.id("timestamp")).getText();
				if (expected_date.equals(actual_date)) {
					System.out.println("Test Case ID: \t\t" + text_case_id_08 + " - PASSED");
					System.out.println("Date Expected/Actual: \t" + expected_date + "/" + actual_date);
					System.out.println("=======================================");
				} else {
					System.out.println("Test Case ID: \t\t" + text_case_id_08 + " - FAILED");
					System.out.println("Date Expected/Actual: \t" + expected_date + "/" + actual_date);
					System.out.println("=======================================");
				} 
			}
			
			@SuppressWarnings("unused")
			@Test
			public void test15_verify_content_os() throws Exception {
				String os = driver.findElement(By.id("os_browser")).getText();
				int index = os.indexOf("&"); //separated os and browser
				if (os != null ) {
					System.out.println("Test Case ID: \t\t" + text_case_id_09 + " - PASSED");
					System.out.println("Local Operation System is: " + os.substring(0, index) );
					System.out.println("=======================================");
				} else {
					System.out.println("Test Case ID: \t\t" + text_case_id_09 + " - FAILED");
					System.out.println("Local Operation System is NOT displayed! ");
					System.out.println("=======================================");
				} 
			}
			
			@SuppressWarnings("unused")
			@Test
			public void test16_verify_content_browser() throws Exception {
				String br = driver.findElement(By.id("os_browser")).getText();
				int Index = br.indexOf("&");
				if (br != null ) {
					System.out.println("Test Case ID: \t\t" + text_case_id_10 + " - PASSED");
					System.out.println("Browser is: " + br.substring(Index + 1));
					System.out.println("=======================================");
				} else {
					System.out.println("Test Case ID: \t\t" + text_case_id_10 + " - FAILED");
					System.out.println("Browser is NOT displayed! ");
					System.out.println("=======================================");
				} 
			}
		}
	
			
		

  
