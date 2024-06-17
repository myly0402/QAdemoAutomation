package lazy;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.LocatorUtil;

public class LazyWebElement implements WebElement {
    private final WebDriver driver;
    private final FindBy locator;
    private WebElement element;

    public LazyWebElement(WebDriver driver, FindBy locator) {
        this.driver = driver;
        this.locator = locator;
    }

    private void initialize() {
        if (element == null) {
            element = driver.findElement(LocatorUtil.getByFromAnnotation(locator));
        }
    }

    private WebElement getElement() {
        if (element == null) {
            initialize();
        }
        return element;
    }

    @Override
    public void click() {
        getElement().click();
    }

    @Override
    public void submit() {
        getElement().submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        getElement().sendKeys(keysToSend);
    }

    @Override
    public void clear() {
        getElement().clear();
    }

    @Override
    public String getTagName() {
        return getElement().getTagName();
    }

    @Override
    public String getAttribute(String name) {
        return getElement().getAttribute(name);
    }

    @Override
    public boolean isSelected() {
        return getElement().isSelected();
    }

    @Override
    public boolean isEnabled() {
        return getElement().isEnabled();
    }

    @Override
    public String getText() {
        return getElement().getText();
    }

    @Override
    public java.util.List<WebElement> findElements(By by) {
        return getElement().findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return getElement().findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        return getElement().isDisplayed();
    }

    @Override
    public org.openqa.selenium.Point getLocation() {
        return getElement().getLocation();
    }

    @Override
    public org.openqa.selenium.Dimension getSize() {
        return getElement().getSize();
    }

    @Override
    public Rectangle getRect() {
        return getElement().getRect();
    }

    @Override
    public String getCssValue(String propertyName) {
        return getElement().getCssValue(propertyName);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return getElement().getScreenshotAs(target);    
    }
}
