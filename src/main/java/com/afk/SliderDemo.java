package com.afk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SliderDemo {
    public static void main(String[] args) throws InterruptedException {
        // Setup WebDriver for Firefox
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize(); // Maximize browser window

        try {
            // Navigate to the web page with the price range slider
            driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");

            // Locate the minimum slider using XPath
            WebElement min_slider = driver.findElement(By.xpath("//span[1]"));
            // Print the location and size of the minimum slider
            System.out.println("Location of Minimum slider = " + min_slider.getLocation()); // (88, 233)
            System.out.println("Size of Minimum slider = " + min_slider.getSize()); // (20, 20)

            // Locate the maximum slider using XPath
            WebElement max_slider = driver.findElement(By.xpath("//span[2]"));
            // Print the location and size of the maximum slider
            System.out.println("Location of Maximum slider = " + max_slider.getLocation()); // (516, 288)
            System.out.println("Size of Maximum slider = " + max_slider.getSize()); // (20, 20)

            // Create an instance of Actions class to perform complex user interactions
            Actions actions = new Actions(driver);
            // Drag the minimum slider to the right by 100 pixels
            actions.dragAndDropBy(min_slider, 100, 0).build().perform();
            Thread.sleep(2000); // Wait for 2 seconds to observe the action

            // Drag the maximum slider to the left by 150 pixels
            actions.dragAndDropBy(max_slider, -150, 0).build().perform();
        } finally {
            // Wait for 2 seconds before closing the browser
            Thread.sleep(2000);
            // Close the browser
            driver.quit();
        }
    }
}
