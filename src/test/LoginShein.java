import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginShein extends Page {


	public LoginShein() {
		super();
		driver.get("https://br.shein.com/");
	}

	private WebElement getEmail() {
		return driver.findElement(By.id("email"));
	}

	private WebElement getPassword() {
		return driver.findElement(By.id("password"));
	}

	private WebElement getButtonLogin() {
		return driver.findElement(By.id("button"));
	}

	public void login(String email, String password) {
		getEmail().sendKeys(email);
		getPassword().sendKeys(password);
		getButtonLogin().click();
	}
}