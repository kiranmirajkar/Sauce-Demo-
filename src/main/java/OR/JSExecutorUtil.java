

package OR;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSExecutorUtil {
    public static void flash(WebElement webElement, WebDriver driver){
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        String bgColor = webElement.getCssValue("backgroundColor");

        System.out.println("Color ==" + bgColor);
        for (int i = 0;i<5; i++){
            changeColor("#000000",webElement,driver);
            changeColor(bgColor, webElement,driver);
        }
    }
    private static void changeColor(String color,WebElement webElement, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("argument[0].style.backgroundColor='" + color + "'", webElement);
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
        }


    }
    public static void drawBorder(WebElement webElement, WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border= '5px solid red'",webElement);
    }
    public static String getTitle(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("return document.title").toString();
    }
}
