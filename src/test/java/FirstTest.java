import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        // Suppress CDP warnings
        System.setProperty("webdriver.chrome.silentOutput", "true");
        java.util.logging.Logger.getLogger("").setLevel(java.util.logging.Level.SEVERE);
        java.util.logging.Logger.getLogger("org.openqa.selenium.devtools").setLevel(java.util.logging.Level.OFF);
        java.util.logging.Logger.getLogger("org.openqa.selenium.chromium").setLevel(java.util.logging.Level.OFF);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void openGoogle() {
        // Open Google
        driver.get("https://www.google.com");

        // Get the title of the page
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);

        // Verify title contains Google
        assert title.contains("Google") : "Title does not contain Google!";
        System.out.println("TEST PASSED! ✅");
        System.out.println("TEST PASSED! ✅");
        System.out.println("TEST PASSED! ✅");
    }

    @AfterClass
    public void teardown() {
        // This closes the browser
        driver.quit();
    }
}