package io.poundcode.jokeviewerlib;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.poundcode.jokeviewerlib.jokeview.JokeViewFragment;

public class JokeActvity extends AppCompatActivity {

    private static final String TAG = "JokeActvity";
    private JokeViewFragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_actvity);
        Log.d(TAG, "onCreate: got joke");
        if (getIntent() != null) {
            initFragment(getIntent());
        }
    }

    private void initFragment(Intent jokeIntent) {

        mFragment = new JokeViewFragment();
        mFragment.setArguments(jokeIntent.getExtras());
        FragmentManager manager = getFragmentManager();
        manager.beginTransaction()
            .replace(R.id.content, mFragment)
            .commit();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            initFragment(intent);
        }
    }
}
