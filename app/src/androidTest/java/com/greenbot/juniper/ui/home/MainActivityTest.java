package com.greenbot.juniper.ui.home;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.greenbot.juniper.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void test_network_success() {
        onView(withId(R.id.progressBar)).check(matches(isDisplayed()));

        onView(withId(R.id.news_list)).check(matches(isDisplayed()));
    }

    @Test
    public void mainActivityTest() {
        ViewInteraction bottomNavigationItemView = onView(allOf(withId(R.id.action_movies), withContentDescription("Utilities"), isDisplayed()));
        bottomNavigationItemView.perform(click()); //action

        ViewInteraction viewPager = onView(allOf(withId(R.id.pager), isDisplayed()));
        viewPager.perform(swipeLeft());  // action

        ViewInteraction textView = onView(allOf(withId(R.id.textViewLabel), withText("Movies Fragment"), isDisplayed()));
        textView.check(matches(withText("Movies Fragment"))); // assertion

        ViewInteraction viewGroup = onView(allOf(withId(R.id.app_bar), isDisplayed()));
        viewGroup.check(matches(isDisplayed()));  //assertion

        ViewInteraction textView2 = onView(allOf(withText("Juniper"), isDisplayed()));
        textView2.check(matches(withText("Juniper"))); //assertion

        ViewInteraction bottomNavigationItemView2 = onView(allOf(withId(R.id.action_news), withContentDescription("News"),
                isDisplayed()));
        bottomNavigationItemView2.perform(click());

        ViewInteraction viewPager2 = onView(allOf(withId(R.id.pager), isDisplayed()));
        viewPager2.perform(swipeRight());

        ViewInteraction recyclerView = onView(allOf(withId(R.id.news_list), isDisplayed()));
        recyclerView.perform(actionOnItemAtPosition(3, click()));

    }

}
