package com.lithium.mineraloi.university;

import com.lithium.mineraloi.university.browser.DriverManager;
import com.lithium.mineraloil.selenium.elements.BaseElement;
import com.lithium.mineraloil.selenium.elements.Driver;
import com.lithium.mineraloil.selenium.elements.TextElement;
import org.openqa.selenium.By;

public class UIView {

    public static final int HOME_TAB = 1;

    private Driver driver;
    private final String homeTimelineBase = "//div[@class='home-timeline timeline-component']";

    public UIView() {
        driver = DriverManager.INSTANCE.getDriver();
    }

    public BaseElement getFilterButton() {
        return driver.createBaseElement(By.xpath("//button[@class='filter-timeline']"));
    }

    public TextElement getFilterInput() {
        return driver.createTextElement(By.xpath("//input[@class='filter-input']"));
    }

    public BaseElement getTimelineMessage() {
        return driver.createBaseElement(By.xpath(String.format( "%s//div[@class='timeline-message']",
                homeTimelineBase)));
    }

    public BaseElement getTweetMessages() {
        return driver.createBaseElement(By.xpath(String.format("%s//div[@class='message']",
                homeTimelineBase)));
    }

    public BaseElement getTabLink(int index) {
        return driver.createBaseElement(By.xpath("//ul[@role='tablist']//li[" + index + "]//a"));
    }
}
