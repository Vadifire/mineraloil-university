package com.lithium.mineraloil.university;

import com.lithium.mineraloi.university.UIController;
import com.lithium.mineraloi.university.browser.BaseUITest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FilterTest extends BaseUITest {

    private static UIController controller;

    @BeforeAll
    static void setup() {
        /* Setup Browser Driver */
        controller = new UIController();
    }

    @DisplayName("Should display no results message when no tweets match filter")
    @Test
    void missingResultTest() {
        final String NO_RESULTS_MESSAGE = "No tweets match the filter.";
        final StringBuilder filter = new StringBuilder();
        final int MAX_TWEET_LENGTH = 280;
        for (int i = 0; i < MAX_TWEET_LENGTH + 1; i++) {
            filter.append("@");
        }
        controller.filterBy(filter.toString());
        Assertions.assertThat(controller.getTimelineMessage()).isEqualTo(NO_RESULTS_MESSAGE);
    }

    @DisplayName("Should display tweets that match the filter")
    @Test
    void filteredTweetsTest() {
        final String keyword = "the";
        controller.filterBy(keyword);
        controller.getTweetMessages().forEach(message ->
                Assertions.assertThat(message).contains(keyword)
        );
    }

}
