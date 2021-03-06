package application;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;


public class ApplicationManager {
    public SessionHelper sessionHelper;
    public HelperBase helperBase;
    public ContactHelper contactHelper;
    public GroupHelper groupHelper;
    public NavigationHelper navigationHelper;

    FirefoxDriver wd;

    public void start() {
        wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //goToSite
        sessionHelper = new SessionHelper(wd);
        sessionHelper.openSite();
        groupHelper = new GroupHelper(wd);
        contactHelper = new ContactHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        helperBase = new HelperBase(wd);
        //login
        sessionHelper.login("admin", "secret");
    }

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void stop() {
        wd.quit();
    }


    public void alertAccept() {
        wd.switchTo().alert().accept();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public HelperBase getHelperBase() {
        return helperBase;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }
}
