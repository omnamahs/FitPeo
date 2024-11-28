package calculator;

public class Calculate {
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class FitPeoAutomation {
	    public static void main(String[] args) {
	        // Set up WebDriver
	        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
	        WebDriver driver = new ChromeDriver();

	        try {
	            // Navigate to FitPeo homepage
	            driver.get("https://www.fitpeo.com");
	            driver.manage().window().maximize();

	            // Navigate to the Revenue Calculator Page
	            driver.findElement(By.linkText("Revenue Calculator")).click();

	            // Scroll down to the slider section
	            WebElement sliderSection = driver.findElement(By.id("slider-section-id")); 
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sliderSection);

	            // Adjust the slider to 820
	            WebElement slider = driver.findElement(By.id("slider-id")); // Replace with actual slider ID/selector
	            WebElement sliderTextField = driver.findElement(By.id("slider-text-field-id")); 
	            slider.sendKeys("820");

	            // Validate if the text field is updated to 820
	            String sliderValue = sliderTextField.getAttribute("value");
	            if (sliderValue.equals("820")) {
	                System.out.println("Slider updated to 820 successfully.");
	            } else {
	                System.out.println("Slider update failed.");
	            }

	            // Update the text field to 560
	            sliderTextField.clear();
	            sliderTextField.sendKeys("560");

	            // Validate if the slider position is updated to 560
	            String updatedSliderValue = slider.getAttribute("value");
	            if (updatedSliderValue.equals("560")) {
	                System.out.println("Slider position updated to 560 successfully.");
	            } else {
	                System.out.println("Slider position update failed.");
	            }

	            // Select CPT codes
	            driver.findElement(By.id("CPT-99091-checkbox-id")).click(); 
	            driver.findElement(By.id("CPT-99453-checkbox-id")).click();
	            driver.findElement(By.id("CPT-99454-checkbox-id")).click();
	            driver.findElement(By.id("CPT-99474-checkbox-id")).click();

	            // Validate Total Recurring Reimbursement
	            WebElement reimbursementHeader = driver.findElement(By.id("reimbursement-header-id"));
	            String reimbursementValue = reimbursementHeader.getText();
	            if (reimbursementValue.contains("$110700")) {
	                System.out.println("Reimbursement value is correct: $110700");
	            } else {
	                System.out.println("Reimbursement value is incorrect.");
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // Close the browser
	            driver.quit();
	        }
	    }
	}
}
