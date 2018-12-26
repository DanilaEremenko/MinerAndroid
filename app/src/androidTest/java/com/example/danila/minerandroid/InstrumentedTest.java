package com.example.danila.minerandroid;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


@LargeTest
@RunWith(AndroidJUnit4.class)
public class InstrumentedTest {

    @Rule
    public final ActivityTestRule<A_MenuActivity> activityActivityTestRule = new ActivityTestRule<>(A_MenuActivity.class);

    @Test
    public void testUI() {
        final int CYCLE_NUMBER = 2;

        for (int i = 0; i < CYCLE_NUMBER; i++) {

            /*main menu tests*/
            onView(withId(R.id.play_button))
                    .check(matches(isDisplayed()));
            onView(withId(R.id.records_button))
                    .check(matches(isDisplayed()));
            onView(withId(R.id.exit_button))
                    .check(matches(isDisplayed()));

            onView(withId(R.id.play_button))
                    .perform(click());


            /*choose level tests*/

            onView(withId(R.id.easy))
                    .check(matches(isDisplayed()));
            onView(withId(R.id.medium))
                    .check(matches(isDisplayed()));
            onView(withId(R.id.hard))
                    .check(matches(isDisplayed()));

            onView(withId(R.id.easy))
                    .perform(click());





            /*game tests*/
            onView(withId(R.id.menu_button))
                    .check(matches(isDisplayed()));
            onView(withId(R.id.reload_button))
                    .check(matches(isDisplayed()));


            onView(withId(R.id.game_field))
                    .perform(click());
            onView(withId(R.id.reload_button))
                    .perform(click());

            onView(withId(R.id.game_field))
                    .perform(click());
            onView(withId(R.id.reload_button))
                    .perform(click());

            onView(withId(R.id.game_field))
                    .perform(click());
            onView(withId(R.id.reload_button))
                    .perform(click());

            onView(withId(R.id.menu_button))
                    .perform(click());


        }


        /*main menu tests(after game)*/

        onView(withId(R.id.play_button))
                .check(matches(isDisplayed()));
        onView(withId(R.id.records_button))
                .check(matches(isDisplayed()));
        onView(withId(R.id.exit_button))
                .check(matches(isDisplayed()));


    }
}