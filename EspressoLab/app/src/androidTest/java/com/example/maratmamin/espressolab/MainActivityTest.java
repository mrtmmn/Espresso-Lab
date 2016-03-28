package com.example.maratmamin.espressolab;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by maratmamin on 3/28/16.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void testIfAddWorks() throws Exception {
        String value = "12.00";
        String expected = "$12.00";

        onView(withId(R.id.edittext)).perform(clearText(), typeText(value), closeSoftKeyboard());

        onView(withId(R.id.add)).perform(click());

        onView(withId(R.id.textview)).check(matches(withText(expected)));
    }

    @Test
    public void testIfRemoveWorks() throws Exception {
        String value = "12.00";
        String expected = "-$12.00";

        onView(withId(R.id.edittext)).perform(clearText(), typeText(value), closeSoftKeyboard());

        onView(withId(R.id.remove)).perform(click());

        onView(withId(R.id.textview)).check(matches(withText(expected)));
    }

    @Test
    public void testIfInfoWorks() throws Exception {
        
        onView(withId(R.id.info)).perform(click());

        onView(withId(R.id.infoemail)).check(matches(isDisplayed()));
        onView(withId(R.id.infoname)).check(matches(isDisplayed()));
    }
}
