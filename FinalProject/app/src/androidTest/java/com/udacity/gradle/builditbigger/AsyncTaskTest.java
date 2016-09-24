package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.RenamingDelegatingContext;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Abhishek on 24-09-2016.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class AsyncTaskTest {

    Context mMockContext;

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule= new ActivityTestRule<>(MainActivity.class);

    public AsyncTaskTest() {
        super();

    }

    /**
     * Getting the context for testing
     * http://stackoverflow.com/questions/30319838/android-junit4-testing-where-to-get-context-from/30688585#30688585
     */
    @Before
    public void setUp() {
        mMockContext = new RenamingDelegatingContext(InstrumentationRegistry.getContext(), "test_");
    }

    @Test
    public void shouldReturnNonEmptyString()
    {
        String joke = "";
        try{
            EndpointsAsyncTask task= new EndpointsAsyncTask();
            task.execute("Abhishek");
            joke= task.get(30, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }

        assertNotNull("not null",joke);
    }
}
