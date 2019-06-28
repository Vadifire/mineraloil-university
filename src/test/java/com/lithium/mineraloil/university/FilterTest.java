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
        controller = new UIController();
    }

    /*@DisplayName("Should display error message when API is down")
    @Test
    void apiErrorTest() {
        String API_ERROR_MESSAGE = "Failed to fetch tweets from home timeline. Please try again later.";
        controller.filterBy("anything");
        Assertions.assertThat(controller.getTimelineMessage()).isEqualTo(API_ERROR_MESSAGE);
    }*/

    @DisplayName("Should display no results message when no tweets match filter")
    @Test
    void missingResultTest() {
        String NO_RESULTS_MESSAGE = "No tweets match the filter.";
        controller.filterBy("hopeimnotinoneoftheseheretweets");
        Assertions.assertThat(controller.getTimelineMessage()).isEqualTo(NO_RESULTS_MESSAGE);
    }

    @DisplayName("Should display no results message when no tweets match filter")
    @Test
    void filteredTweetsTest() {
        String keyword = "the";
        controller.filterBy(keyword);
        controller.getTweetMessages()
                .forEach(message -> {
                    Assertions.assertThat(message).contains(keyword);
                });
    }

}
