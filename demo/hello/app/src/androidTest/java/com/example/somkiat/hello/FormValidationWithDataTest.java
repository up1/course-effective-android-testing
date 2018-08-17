package com.example.somkiat.hello;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(Parameterized.class)
public class FormValidationWithDataTest {

    private String email;
    private String password;
    private String expectedResult;

    public FormValidationWithDataTest(String email, String password, String expectedResult) {
        this.email = email;
        this.password = password;
        this.expectedResult = expectedResult;
    }

    @Parameters
    public static Collection<Object[]> xxxx() {
        return Arrays.asList(new Object[][] {
                {"", "1234", "Invalid email"},
                {"", "1234", "Invalid email"},
        });
    }

    @Rule
    public ActivityTestRule<MainActivity> mainPage =
        new ActivityTestRule<>(MainActivity.class);

    @Test
    public void validate() {
        onView(withId(R.id.edtEmail))
                .perform(
                        typeText(this.email),
                        closeSoftKeyboard());
        onView(withId(R.id.edtPassword))
                .perform(
                        typeText(this.password),
                        closeSoftKeyboard()
                );
        onView(withId(R.id.btnLogin))
                .perform(click());

        onView(withId(R.id.edtEmail))
                .check(matches(hasErrorText(this.expectedResult)));
    }


}