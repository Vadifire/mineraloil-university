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

    public BaseElement getPostButton() {
        return driver.createBaseElement(By.xpath("//button[@class='post-tweet']"));
    }

    public TextElement getFilterInput() {
        return driver.createTextElement(By.xpath("//input[@class='filter-input']"));
    }

    public BaseElement getTimelineMessage() {
        return driver.createBaseElement(By.xpath( "//div[@class='timeline-message']"));
    }

    public BaseElement getTweetMessages() {
        return driver.createBaseElement(By.xpath("//div[@class='message']"));
    }

    public BaseElement getTweets() {
        return driver.createBaseElement(By.xpath("//div[@class='tweet']"));
    }

    public BaseElement getMessageForTweet(BaseElement tweet) {
        return tweet.createBaseElement(By.xpath("//div[@class='message']"));
    }

    public BaseElement getTabLink(int index) {
        return driver.createBaseElement(By.xpath(String.format("//ul[@role='tablist']//li[%d]//a", index)));
    }

    public TextElement getTweetInput() {
        return driver.createTextElement(By.xpath("//textarea[@class='tweet-input']"));
    }

    public BaseElement getPostResult() {
        return driver.createBaseElement(By.xpath("//div[contains(@class, 'post-result')]"));
    }
}
