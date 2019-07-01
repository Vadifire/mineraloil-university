package com.lithium.mineraloi.university;

import com.lithium.mineraloi.university.browser.DriverManager;
import com.lithium.mineraloil.selenium.elements.BaseElement;
import com.lithium.mineraloil.selenium.elements.Driver;
import com.lithium.mineraloil.selenium.elements.TextElement;
import org.openqa.selenium.By;

public class UIView {
    private Driver driver;

    public UIView() {
        driver = DriverManager.INSTANCE.getDriver();
    }

    public BaseElement getFilterButton() {
        return driver.createBaseElement(By.xpath("//button[@class='filter-timeline']"));
    }

    public TextElement getFilterInput() {
        return driver.createTextElement(By.xpath("//input[@class='filter-input']"));
    }


    public BaseElement getTimelineContent() {
        return driver.createBaseElement(By.xpath("//div[@class='timeline-message']"));
    }
}
