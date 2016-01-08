package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;

import com.udacity.gradle.builditbigger.joke.JokeFragment;
import com.udacity.gradle.builditbigger.joke.backend.JokeFetcherListener;
import com.udacity.gradle.builditbigger.joke.backend.JokeFetcherTask;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.poundcode.jokeviewerlib.JokeActvity;

public class MainActivity extends AppCompatActivity implements JokePresenter {

    @Bind(R.id.progress)
    View progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void tellJoke(View view) {
        //todo load add if free
        ((JokeFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_joke)).showJoke();
    }

    @Override
    public void loadNextJoke() {
        progress.setVisibility(View.VISIBLE);
        new JokeFetcherTask(new JokeFetcherListener() {
            @Override
            public void jokeLoaded(String result) {
                Intent intent = new Intent(MainActivity.this, JokeActvity.class);
                Bundle bundle = new Bundle();
                bundle.putString("joke", result);
                intent.putExtras(bundle);
                Uri uri = new Uri.Builder()
                    .scheme("joke")
                    .build();
                intent.setType("text/plain");
                intent.setData(uri);
                progress.setVisibility(View.GONE);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }

            @Override
            public void errorLoadingJoke(Exception e) {
                Snackbar.make(progress, R.string.error_loading_joke, Snackbar.LENGTH_SHORT).show();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progress.setVisibility(View.GONE);
                    }
                });
            }
        }).execute();
    }
}
