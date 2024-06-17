package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class LocatorUtil {

    public static By getByFromAnnotation(FindBy locator) {
        if (!locator.className().isEmpty()) {
            return By.className(locator.className());
        } else if (!locator.css().isEmpty()) {
            return By.cssSelector(locator.css());
        } else if (!locator.id().isEmpty()) {
            return By.id(locator.id());
        } else if (!locator.linkText().isEmpty()) {
            return By.linkText(locator.linkText());
        } else if (!locator.name().isEmpty()) {
            return By.name(locator.name());
        } else if (!locator.partialLinkText().isEmpty()) {
            return By.partialLinkText(locator.partialLinkText());
        } else if (!locator.tagName().isEmpty()) {
            return By.tagName(locator.tagName());
        } else if (!locator.xpath().isEmpty()) {
            return By.xpath(locator.xpath());
        } else {
            throw new IllegalArgumentException("No valid locator found in @FindBy annotation");
        }
    }
}
