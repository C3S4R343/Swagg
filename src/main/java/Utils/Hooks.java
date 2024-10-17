package Utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {
    private static WebDriver driver;

    // Método para configurar el navegador antes de cada prueba
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    // Método para cerrar el navegador después de cada prueba
    @After
    public void tearDown() {
        if (driver == null) {
            driver.quit();
        }
    }

    // Método para devolver el driver a otras clases
    public static WebDriver getDriver() {
        return driver;
    }
}
