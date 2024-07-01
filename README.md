

```markdown
# SliderDemo

This project demonstrates the use of Selenium WebDriver to interact with a price range slider on a web page. The code automates the movement of the minimum and maximum sliders to specified positions using the Actions class.

## Getting Started

These instructions will help you set up and run the project on your local machine for development and testing purposes.

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Maven (for dependency management)
- An IDE of your choice (Eclipse, IntelliJ IDEA, etc.)
- Internet connection (to download WebDriver binaries and dependencies)

### Installing

1. **Clone the repository**

   ```sh
   git clone https://github.com/Abdul-Firoz-Khan/SliderDemo.git
   cd SliderDemo
   ```

2. **Open the project in your IDE**

   Import the project as a Maven project to resolve dependencies automatically.

3. **Run the code**

   Execute the `main` method in the `SliderDemo` class to see the automation in action.

## Code Explanation

The main code is located in the `SliderDemo.java` file under the `com.afk` package.

### Code Breakdown

```java
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
```

### Key Points

- **WebDriverManager**: Manages the setup of the WebDriver binary.
- **WebDriver**: Interface to control the browser. In this example, we use `FirefoxDriver`.
- **WebElement**: Represents an HTML element. Here, we locate the slider handles using XPath.
- **Actions**: Provides a way to perform complex user interactions like drag-and-drop.
- **Thread.sleep**: Pauses the execution for a specified time (in milliseconds).

## Built With

- [Selenium WebDriver](https://www.selenium.dev/) - Browser automation framework
- [WebDriverManager](https://github.com/bonigarcia/webdrivermanager) - Manages WebDriver binaries
- [Maven](https://maven.apache.org/) - Dependency management

## Authors

- **Abdul Firoz Khan** - [GitHub](https://github.com/Abdul-Firoz-Khan)

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Inspired by various Selenium WebDriver tutorials and examples available online.
```

Save this content into a file named `README.md` in the root directory of your project. This file provides an overview of the project, setup instructions, code explanation, and other relevant information.
