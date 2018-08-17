package com.example.somkiat.hello;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(JUnitParamsRunner.class)
public class FormValidationWithData2Test {

    @Rule
    public ActivityTestRule<MainActivity> mainPage =
        new ActivityTestRule<>(MainActivity.class);

    @Test
    @Parameters({
            ", 1234, Invalid email",
            ", 1234, Invalid email",
            ", 1234, Invalid email",
    })
    public void validate(
            String email, String password, String expectedResult
    ) {
        onView(withId(R.id.edtEmail))
                .perform(
                        typeText(email),
                        closeSoftKeyboard());
        onView(withId(R.id.edtPassword))
                .perform(
                        typeText(password),
                        closeSoftKeyboard()
                );
        onView(withId(R.id.btnLogin))
                .perform(click());

        onView(withId(R.id.edtEmail))
                .check(matches(hasErrorText(expectedResult)));
    }


}