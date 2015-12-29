package io.poundcode.jokeviewerlib.jokeview;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.poundcode.jokeviewerlib.R;

public class JokeViewFragment extends Fragment implements JokeViewContract.View {


    private String mJoke;
    private JokeViewPresenter mPresenter;
    private TextView mJokeDisplay;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mJoke = getJokeFromIntent(getArguments());
        mPresenter = new JokeViewPresenter(this);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jokeview, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mJokeDisplay = (TextView) view.findViewById(R.id.joke);
        mPresenter.passJokeToView(mJoke);
    }

    @Override
    public void displayJokeToUser(String joke) {
        //todo display joke
        mJokeDisplay.setText(joke);
    }

    private String getJokeFromIntent(Bundle bundle) {
        return bundle.getString("joke");
    }

}
