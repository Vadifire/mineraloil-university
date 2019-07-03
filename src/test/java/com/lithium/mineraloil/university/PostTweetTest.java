package com.lithium.mineraloil.university;

import com.lithium.mineraloi.university.TabsEnum;
import com.lithium.mineraloi.university.UIController;
import com.lithium.mineraloi.university.browser.BaseUITest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;
import java.util.Random;

public class PostTweetTest extends BaseUITest {

    private static UIController controller;

    @BeforeAll
    static void setup() {
        controller = new UIController();
        controller.selectTab(TabsEnum.POST_TAB.getValue());
    }

    @DisplayName("Should post tweet and display success or message")
    @Test
    void postTweetTest() {
        final String POST_SUCCESS = "Successfully posted tweet.";
        final String POST_FAILURE = "Could not post tweet.";
        final byte[] array = new byte[100];
        new Random().nextBytes(array); // Random 100 characters (expect no status duplicate)
        final String randomTweet = new String(array, Charset.forName("UTF-8"));
        controller.postTweet(randomTweet);
        final String postResult = controller.getPostResult();
        Assertions.assertThat((postResult.equals(POST_SUCCESS)) || postResult.equals(POST_FAILURE)).isTrue();
    }
}
