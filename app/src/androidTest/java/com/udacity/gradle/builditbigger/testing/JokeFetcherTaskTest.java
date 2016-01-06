package com.udacity.gradle.builditbigger.testing;

import android.test.AndroidTestCase;

import com.udacity.gradle.builditbigger.joke.backend.JokeFetcherListener;
import com.udacity.gradle.builditbigger.joke.backend.JokeFetcherTask;

import java.util.concurrent.CountDownLatch;

public class JokeFetcherTaskTest extends AndroidTestCase {

    private CountDownLatch signal;
    private String mResult;

    public void testJokeIsNotNull() throws InterruptedException {
        new JokeFetcherTask(new JokeFetcherListener() {
            @Override
            public void jokeLoaded(String result) {

                mResult = result;
                signal.countDown();
            }
        }).execute();
        signal = new CountDownLatch(1);
        signal.await();
        assertNotNull(mResult);

    }


}
