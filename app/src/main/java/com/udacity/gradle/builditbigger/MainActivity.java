package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;

import com.udacity.gradle.builditbigger.joke.backend.JokeFetcherListener;
import com.udacity.gradle.builditbigger.joke.backend.JokeFetcherTask;

import io.poundcode.jokeviewerlib.JokeActvity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void tellJoke(View view) {
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
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        }).execute();
    }
}
