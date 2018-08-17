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

public class MainActivityValidateInputTest {

    @Rule
    public ActivityTestRule<MainActivity> mainPage =
        new ActivityTestRule<>(MainActivity.class);

    @Test
    public void invalid_email_with_empty_email() {
        onView(withId(R.id.edtEmail))
                .perform(
                        typeText(""),
                        closeSoftKeyboard());
        onView(withId(R.id.edtPassword))
                .perform(
                        typeText("12345"),
                        closeSoftKeyboard()
                );
        onView(withId(R.id.btnLogin))
                .perform(click());

        onView(withId(R.id.edtEmail))
                .check(matches(hasErrorText("Invalid email")));
    }

    @Test
    public void invalid_password_with_empty_password() {
        onView(withId(R.id.edtEmail))
                .perform(
                        typeText("somkiat@gmail.com"),
                        closeSoftKeyboard());
        onView(withId(R.id.edtPassword))
                .perform(
                        typeText(""),
                        closeSoftKeyboard()
                );
        onView(withId(R.id.btnLogin))
                .perform(click());

        onView(withId(R.id.edtPassword))
                .check(matches(hasErrorText("Invalid password")));
    }


}