package com.afk;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SliderDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        try {

        driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");

        WebElement min_slider=driver.findElement(By.xpath("//span[1]"));
        System.out.println("Location of Minimum slider = " + min_slider.getLocation());//(88, 233)
        System.out.println("Size of Minimum slider " + min_slider.getSize());//(20, 20)
        WebElement max_slider= driver.findElement(By.xpath("//span[2]"));
        System.out.println("Location of Maximum slider = " + max_slider.getLocation());//(516, 288)
        System.out.println("Size of Maximum slider " + max_slider.getSize());//(20, 20)

            Actions actions= new Actions(driver);
            actions.dragAndDropBy(min_slider,100,0).build().perform();
            Thread.sleep(2000);
            actions.dragAndDropBy(max_slider,-150,0).build().perform();

        }
        finally {
            Thread.sleep(2000);
            driver.quit();
        }

    }
}