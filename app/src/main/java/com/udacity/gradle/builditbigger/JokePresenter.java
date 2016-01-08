package com.udacity.gradle.builditbigger;

import android.view.View;

public interface JokePresenter {
    void tellJoke(View view);

    void loadNextJoke();
}
