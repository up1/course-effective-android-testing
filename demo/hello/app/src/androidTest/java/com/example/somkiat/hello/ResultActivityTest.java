package com.example.somkiat.hello;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

public class ResultActivityTest {

    @Rule
    public ActivityTestRule<ResultActivity> resultPage =
            new ActivityTestRule<>(
                    ResultActivity.class, true, false);

    @Test
    public void แสดงค่า_Success() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        SharedPreferencesUser user = new SharedPreferencesUser(appContext);
        user.loggedIn("user");

        Intent intent = new Intent();
        intent.putExtra("result", "Success");

        resultPage.launchActivity(intent);

        onView(withId(R.id.txtResult))
                .check(matches(withText("Success")));
    }

}