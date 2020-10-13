import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class LoginUsingDatabase
	{

		public static void main(String[] args) throws SQLException
			{
				// TODO Auto-generated method stub

				String host = "localhost";
				String port = "3306";
				/*
				 * DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				 * capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				 */

				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\Destiny\\Downloads\\Softwares\\ChromeDriver_Version_85\\chromedriver_win32\\chromedriver.exe");

				// @SuppressWarnings("deprecation")
				WebDriver driver = new ChromeDriver();

				Connection connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/student",
						"root", "root");
				System.out.println("*****Connection Established*****");
				Statement statement = connection.createStatement();
				ResultSet rst = statement.executeQuery("select * from stud where name='srushti'");
				rst.next();
				driver.get("https://login.salesforce.com/?locale=au");
				driver.findElement(By.xpath("//input[@id='username']")).sendKeys(rst.getString("name"));
				driver.findElement(By.cssSelector("#password")).sendKeys(rst.getString("location"));
				;
				driver.findElement(By.cssSelector("#Login")).click();

			}

	}
