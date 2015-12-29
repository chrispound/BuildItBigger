package io.poundcode.jokeviewerlib.jokeview;

public interface JokeViewContract {

    interface View {
        void displayJokeToUser(String joke);
    }

    interface Presenter {
        void passJokeToView(String joke);
    }
}
