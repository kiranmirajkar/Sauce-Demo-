import lombok.extern.java.Log;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Properties;

public class LoginScenarioTest extends BaseSetUp{
    private Logger log = Logger.getLogger(Log.class.getName());

    private WebDriver d;
    private Properties p;



    @Before
    public void setUp(){
        d = getWebDriver();
        p = getObjRepo();
        log.info("CHILD CLASS BEFORE CALLED");
    }

    @Test
    public void testSuccessFullLogin(){
        log.info("...........starting test successFullLogin...");
        d.get(p.get("url").toString());
        WebElement uName = d.findElement(By.xpath(p.get("username").toString()));
        uName.sendKeys(p.get("uname_val").toString());
        WebElement uPassword = d.findElement(By.xpath(p.get("password").toString()));
        uPassword.sendKeys(p.get("upass_val").toString());
        WebElement loginButton = d.findElement(By.xpath(p.get("login_btn").toString()));
        loginButton.click();
        WebElement element = d.findElement(By.xpath(p.get("product_label").toString()));
        Assert.assertTrue(element.isDisplayed());
        log.info("..ending test successful login executed...");
    }
    @Test
    public void testLoginFailsWithIncorrectCredentials(){
        log.info("...........starting test successFullLogin...");
        d.get(p.get("url").toString());
        WebElement uName = d.findElement(By.xpath(p.get("username").toString()));
        uName.sendKeys(p.get("uname_val").toString());
        WebElement uPassword = d.findElement(By.xpath(p.get("password").toString()));
        uPassword.sendKeys(p.get("pass_val").toString());
        WebElement loginButton = d.findElement(By.xpath(p.get("login_btn").toString()));
        loginButton.click();
        WebElement element = d.findElement(By.xpath(p.get("product_label").toString()));
        Assert.assertTrue(element.isDisplayed());
        log.info("..ending test successful login executed...");

    }
}
