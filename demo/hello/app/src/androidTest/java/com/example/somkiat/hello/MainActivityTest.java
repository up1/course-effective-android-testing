package com.example.somkiat.hello;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainPage =
        new ActivityTestRule<>(MainActivity.class);

    @Test
    public void login_สำเร็จ() {
        onView(withId(R.id.edtEmail))
                .perform(
                        typeText("somkiat@gmail.com"),
                        closeSoftKeyboard());
        onView(withId(R.id.edtPassword))
                .perform(
                        typeText("12345"),
                        closeSoftKeyboard()
                );
        onView(withId(R.id.btnLogin))
                .perform(click());

        onView(withId(R.id.txtResult))
                .check(matches(withText("Success")));
    }

    @Test
    public void login_ไม่สำเร็จในกรณี_email_ไม่พบในระบบ() {
        onView(withId(R.id.edtEmail))
                .perform(
                        typeText("somkiat1@gmail.com"),
                        closeSoftKeyboard());
        onView(withId(R.id.edtPassword))
                .perform(
                        typeText("12345"),
                        closeSoftKeyboard()
                );
        onView(withId(R.id.btnLogin))
                .perform(click());

        onView(withId(R.id.txtResult))
                .check(matches(withText("BAD")));
    }

    @Test
    public void login_ไม่สำเร็จในกรณี_password_ไม่พบในระบบ() {
        onView(withId(R.id.edtEmail))
                .perform(
                        typeText("somkiat@gmail.com"),
                        closeSoftKeyboard());
        onView(withId(R.id.edtPassword))
                .perform(
                        typeText("123456"),
                        closeSoftKeyboard()
                );
        onView(withId(R.id.btnLogin))
                .perform(click());

        onView(withId(R.id.txtResult))
                .check(matches(withText("BAD")));
    }



}