package com.lithium.mineraloi.university;

import com.lithium.mineraloil.selenium.elements.BaseElement;

import java.util.List;
import java.util.stream.Collectors;

public class UIController {
    private UIView view;

    public UIController() {
        view = new UIView();
    }

    public void filterBy(String keyword) {
        view.getFilterInput().type(keyword);
        view.getFilterButton().click();
    }

    public void selectTab(int index) {
        view.getTabLink(index).click();
    }

    public String getTimelineMessage() {
        return view.getTimelineMessage().getText();
    }

    public List<String> getTweetMessages() {
        return view.getTweetMessages()
                .toList()
                .stream()
                .map(BaseElement::getText)
                    .collect(Collectors.toList());
    }

    public List<BaseElement> getTweets() {
        return view.getTweets().toList();
    }

    public String getMessageForTweet(BaseElement tweet) {
        return view.getMessageForTweet(tweet).getText();
    }

    public void postTweet(String message) {
        view.getTweetInput().type(message);
        view.getPostButton().click();
    }

    public String getPostResult() {
        return view.getPostResult().getText();
    }

}
