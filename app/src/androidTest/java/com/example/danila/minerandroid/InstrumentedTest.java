package com.example.danila.minerandroid;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.Button;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.longClick;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withInputType;
import static org.hamcrest.core.IsNot.not;


@LargeTest
@RunWith(AndroidJUnit4.class)
public class InstrumentedTest {

    @Rule
    public final ActivityTestRule<AMenuActivity> activityActivityTestRule = new ActivityTestRule<>(AMenuActivity.class);

    @Test
    public void menuAndButtonExistingTest() {
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

    @Test
    public void gameWinTest() {

        onView(withId(R.id.play_button))
                .perform(click());
        onView(withId(R.id.easy))
                .perform(click());


        //Открываем все клетки и ставим флаг на все мины
        for (int i = 0; i < AGameActivity.FIELD_WIDTH * AGameActivity.FIELD_HEIGHT; i++) {
            GraphicCell graphicCell = (GraphicCell) withId(i);
            if (graphicCell.getLogicCell().getConditon() != 9)
                onView(withId(i))
                        .perform(click());
            else
                onView(withId(i))
                        .perform(longClick());
        }


        //пропускае ввод имени
        onView(withId(R.id.game_field)).perform(click());


        //проверяем, что мы в ARecordsTableActivity
        onView(withId(R.id.easy_table_button)).check(matches(isDisplayed()));
        onView(withId(R.id.easy_table_button)).check(matches(isDisplayed()));
        onView(withId(R.id.easy_table_button)).check(matches(isDisplayed()));

    }


    @Test
    public void goToMenuFromGameTest() {

        onView(withId(R.id.play_button))
                .perform(click());
        onView(withId(R.id.easy))
                .perform(click());

        /*Проверяем что мы в AGameActivity*/
        onView(withId(R.id.menu_button))
                .check(matches(isDisplayed()));
        onView(withId(R.id.reload_button))
                .check(matches(isDisplayed()));
        onView(withId(R.id.reloadlast_button))
                .check(matches(isDisplayed()));


        onView(withId(R.id.menu_button))
                .perform(click());


        /*Проверяем что мы опять в AGameMenu*/
        onView(withId(R.id.play_button))
                .check(matches(not(isDisplayed())));
        onView(withId(R.id.records_button))
                .check(matches(isDisplayed()));
        onView(withId(R.id.exit_button))
                .check(matches(isDisplayed()));

        pressBack();

        /*Проверяем что мы не в AGameActivity*/
        onView(withId(R.id.menu_button))
                .check(matches(not(isDisplayed())));
        onView(withId(R.id.reload_button))
                .check(matches(not(isDisplayed())));
        onView(withId(R.id.reloadlast_button))
                .check(matches(not(isDisplayed())));


    }


}