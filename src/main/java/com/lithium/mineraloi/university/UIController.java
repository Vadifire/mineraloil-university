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

    public String getTimelineMessage() {
        return view.getTimelineContent().getText();
    }

    public List<String> getTweetMessages() {
        return view.getTimelineContent()
                .toList()
                .stream()
                .map(BaseElement::getText)
                    .collect(Collectors.toList());
    }
}
