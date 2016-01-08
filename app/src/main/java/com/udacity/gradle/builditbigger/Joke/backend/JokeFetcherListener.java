package com.udacity.gradle.builditbigger.joke.backend;

public interface JokeFetcherListener {
    void jokeLoaded(String result);

    void errorLoadingJoke(Exception e);
}
