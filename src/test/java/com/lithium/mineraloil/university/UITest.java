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

public class UITest extends BaseUITest {

    private static UIController controller;

    @BeforeAll
    static void setup() {
        controller = new UIController();
    }

    @DisplayName("Should display no results message when no tweets match filter")
    @Test
    void noResultsForFilterTest() {
        controller.selectTab(TabsEnum.HOME_TAB.getValue());
        final String NO_RESULTS_MESSAGE = "No tweets match the filter.";
        controller.filterBy("Expect no tweet to contain this 1232139128");
        Assertions.assertThat(controller.getTimelineMessage()).isEqualTo(NO_RESULTS_MESSAGE);
    }

    @DisplayName("Should display tweets that match the filter")
    @Test
    void filterTweetsTest() {
        controller.selectTab(TabsEnum.HOME_TAB.getValue());
        final String keyword = "the";
        controller.filterBy(keyword);
        controller.getTweetMessages().forEach(message ->
                Assertions.assertThat(message).contains(keyword)
        );
    }

    @DisplayName("Should display tweets from home timeline")
    @Test
    void homeTweetsTest() {
        controller.selectTab(TabsEnum.HOME_TAB.getValue());
        controller.getTweets().forEach(tweet ->
                Assertions.assertThat(controller.getMessageForTweet(tweet)).isNotEmpty()
        );
    }

    @DisplayName("Should display tweets from user timeline")
    @Test
    void userTweetsTest() {
        controller.selectTab(TabsEnum.USER_TAB.getValue());
        controller.getTweets().forEach(tweet ->
                Assertions.assertThat(controller.getMessageForTweet(tweet)).isNotEmpty()
        );
    }

    @DisplayName("Should post tweet and show success message")
    @Test
    void postTweetSuccessTest() {
        controller.selectTab(TabsEnum.POST_TAB.getValue());
        final String POST_SUCCESS = "Successfully posted tweet.";
        final byte[] array = new byte[100];
        new Random().nextBytes(array); // Random 100 characters (expect no status duplicate)
        final String randomTweet = new String(array, Charset.forName("UTF-8"));
        controller.postTweet(randomTweet);
        final String postResult = controller.getPostResult();
        Assertions.assertThat(postResult).isEqualTo(POST_SUCCESS);
    }

    @DisplayName("Should should failure message when trying to post duplicate tweet")
    @Test
    void postTweetFailure() {
        controller.selectTab(TabsEnum.POST_TAB.getValue());
        final String POST_FAILURE = "Could not post tweet.";
        final String duplicateTweet = "a";
        for (int i = 0; i < 2; i++) {
            controller.postTweet(duplicateTweet);
        }
        final String postResult = controller.getPostResult();
        Assertions.assertThat(postResult).isEqualTo(POST_FAILURE);

    }

}
