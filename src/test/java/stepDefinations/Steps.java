package stepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {
	public WebDriver driver;


//	WebDriver WebDriverManager() throws IOException{
//	
//	FileInputStream fis = FileInputStream(System.getProperty("user.dir")+"\\SeleniumProjects\\veekshanAssignmnet");
//	Properties prop = new Properties();
//	prop.load(fis);
//	
//	return driver;
//	}

//	private FileInputStream FileInputStream(String string) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Given("user is on login page")
	public void user_is_on_login_page() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
	}

	@When("user enters username {string} and password {string}")
	public void user_enters_username_and_password(String username, String password) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[name='username']")).sendKeys(username);
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
		Thread.sleep(1000);
	}

	@And("clicks on login button")
	public void clicks_on_login_button() {
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}

	@Then("user is navigated to directory page")
	public void user_is_navigated_to_directory_page() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//ul/li[9]")).click();
	}

	@Then("user types {string} in name filed")
	public void user_types_ca_in_name_filed(String name) throws InterruptedException {
		Thread.sleep(2000);
		WebElement textbox = driver.findElement(By.cssSelector("input[placeholder='Type for hints...']"));
		textbox.sendKeys(name);
		textbox.click();
		Thread.sleep(1000);
		textbox.click();
		Thread.sleep(1000);
		for (int i = 0; i < 3; i++) {
			textbox.sendKeys(Keys.ARROW_DOWN);
		}
		textbox.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}

	@And("selects name, location")
	public void selects_name_location() throws InterruptedException {
		WebElement textboxTwo = driver.findElement(By.xpath("//form/div/div/div[3]/div/div/div/div/div[1]"));
		textboxTwo.click();
		Thread.sleep(2000);
		for (int i = 0; i < 3; i++) {
			textboxTwo.sendKeys(Keys.ARROW_DOWN);
		}
		textboxTwo.sendKeys(Keys.ENTER);
	}

	@When("clicks on search button")
	public void clicks_on_search_button() throws InterruptedException {
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(2000);
	}

	@Then("verify the username")
	public void verify_the_username() {
		String expectedName = driver
				.findElement(
						By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-directory-card-header --break-words']"))
				.getText();
		String originalName = "Cassidy Hope";
		Assert.assertEquals(expectedName, originalName, "Both names are matching");
	}

	@And("click on the profile icon")
	public void click_on_the_profile_icon() throws InterruptedException {
		driver.findElement(By.cssSelector("p.oxd-userdropdown-name")).click();
		Thread.sleep(1000);
	}

	@And("click on log out")
	public void click_on_log_out() {
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		
		driver.quit();
	}
	@Given("user is on landing page")
	public void user_is_on_landing_page() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		Thread.sleep(1000);

	}

	@When("logs in with user name and password")
	public void user_enters_user_name_and_password() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}

	@Then("click on admin")
	public void click_on_admin() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul/li[1]")).click();
		Thread.sleep(2000);
	}

	@And("select pay grades under job")
	public void select_pay_grades_under_job() throws InterruptedException {
		driver.findElement(By.cssSelector("div[class='oxd-topbar-body'] ul li:nth-child(2)")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@role='menu']/li[2]")).click();
		Thread.sleep(2000);
	}
	@Then("click on add button")
		public void click_on_add_button() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()=' Add ']")).click();
		Thread.sleep(2000);
	}

	@Then("type value in name filed")
	public void type_value_in_name_filed() throws InterruptedException {
		driver.findElement(By.cssSelector("form .oxd-input")).sendKeys("Grade 8");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()=' Save ']")).click();
	}

	@And("verify success message after saving")
	public void verify_success_message_after_saving() throws InterruptedException {
		Thread.sleep(2000);
		// add code for the screenshot

	}

	@Then("click on add in Assigned Currencies")
	public void click_on_add_in_assigned_currencies() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()=' Add ']")).click();
		Thread.sleep(2000);
	}

	@Then("select indian rupee in currency filed")
	public void select_indian_rupee_in_currency_filed() throws InterruptedException {
		WebElement currencybox = driver.findElement(By.xpath("//div[text()='-- Select --']"));
		currencybox.click();
		Thread.sleep(1000);
		for (int i = 0; i < 58; i++) {
			currencybox.sendKeys(Keys.ARROW_DOWN);
		}
		currencybox.sendKeys(Keys.ENTER);
	}

	@And("select minimum salary and maximum salary")
	public void select_minimum_salary_and_maximum_salary() throws InterruptedException {
		driver.findElement(
				By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[1]/div/div[2]/input"))
				.sendKeys("3000");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[2]/div/div[2]/input")).
		sendKeys("100000");
		Thread.sleep(1000);
	}

	@Then("verify success message")
	public void verify_success_message() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[2]/form/div[3]/button[2]")).click();
		// add screenshot code
	}

	@Then("verify the given data")
	public void verify_the_given_data() throws InterruptedException {
		// add assertions
		Thread.sleep(1000);
		driver.close();
	}


}
