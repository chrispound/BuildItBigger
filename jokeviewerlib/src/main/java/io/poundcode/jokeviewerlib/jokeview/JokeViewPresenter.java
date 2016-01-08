package io.poundcode.jokeviewerlib.jokeview;

import android.support.annotation.NonNull;


public class JokeViewPresenter implements JokeViewContract.Presenter {

    private final JokeViewContract.View mJokeView;

    public JokeViewPresenter(@NonNull JokeViewContract.View mJokeView) {
        this.mJokeView = mJokeView;
    }


    @Override
    public void passJokeToView(String joke) {
        mJokeView.displayJokeToUser(joke);
    }
}
