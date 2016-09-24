package com.udacity.gradle.builditbigger;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Abhishek on 24-09-2016.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class AsyncTaskTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule= new ActivityTestRule<>(MainActivity.class);

    public AsyncTaskTest() {
        super();
    }

    @Test
    public void shouldReturnNonEmptyString()
    {
        onView(withId(R.id.button)).perform(click());

        String joke = "";
        try{
            EndpointsAsyncTask task= new EndpointsAsyncTask();
            task.execute();
            joke= task.get(30, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }

        assertNotNull("not null",joke);
    }
}
