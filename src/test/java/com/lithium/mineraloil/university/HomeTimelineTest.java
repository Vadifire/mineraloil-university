package com.lithium.mineraloil.university;

import com.lithium.mineraloi.university.TabsEnum;
import com.lithium.mineraloi.university.UIController;
import com.lithium.mineraloi.university.browser.BaseUITest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HomeTimelineTest extends BaseUITest {

    private static UIController controller;

    @BeforeAll
    static void setup() {
        controller = new UIController();
        controller.selectTab(TabsEnum.HOME_TAB.getValue());
    }

    @DisplayName("Should display tweets from home timeline")
    @Test
    void homeTweetsTest() {
        controller.getTweets().forEach(tweet ->
                Assertions.assertThat(controller.getMessageForTweet(tweet).length() > 0).isTrue()
        );
    }
}
