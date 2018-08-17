package com.example.somkiat.hello;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class FormValidationTest {

    @Rule
    public ActivityTestRule<MainActivity> mainPage =
        new ActivityTestRule<>(MainActivity.class);

    @Test
    public void empty_email() {
        onView(withId(R.id.edtEmail))
                .perform(
                        typeText(""),
                        closeSoftKeyboard());
        onView(withId(R.id.edtPassword))
                .perform(
                        typeText("1234"),
                        closeSoftKeyboard()
                );
        onView(withId(R.id.btnLogin))
                .perform(click());

        onView(withId(R.id.edtEmail))
                .check(matches(hasErrorText("Invalid email")));

    }

    @Test
    public void null_email() {
        onView(withId(R.id.edtEmail))
                .perform(
                        click(),
                        closeSoftKeyboard());
        onView(withId(R.id.edtPassword))
                .perform(
                        typeText("1234"),
                        closeSoftKeyboard()
                );
        onView(withId(R.id.btnLogin))
                .perform(click());

        onView(withId(R.id.edtEmail))
                .check(matches(hasErrorText("Invalid email")));

    }


}