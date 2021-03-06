package app;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class AppManager {

    public BoardHelper boardHelper;
    public ListHelper listHelper;
    public CardHelper cardHelper;
    public NavigationHelper navigationHelper;
    public SessionHelper sessionHelper;

    FirefoxDriver wd;

    //setUp
    public void start() {
        wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.openSite();
        boardHelper = new BoardHelper(wd);
        listHelper = new ListHelper(wd);
        cardHelper = new CardHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper.login("qa12Test", "qa12Test");

    }


    //tearDown
    public void stop() {
        wd.quit();
    }


    public BoardHelper getBoardHelper() {
        return boardHelper;
    }

    public ListHelper getListHelper() {
        return listHelper;
    }

    public CardHelper getCardHelper() {
        return cardHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public SessionHelper getHelperBase() {
        return sessionHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }
}
