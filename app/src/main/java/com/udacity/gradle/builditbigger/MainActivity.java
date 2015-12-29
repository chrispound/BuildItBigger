package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import io.poundcode.jokefetcher.JokeFetcher;
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        String joke = new JokeFetcher().fetchNewJoke();
//        Snackbar.make(view, joke, Snackbar.LENGTH_LONG).show();

        //todo pass to android lib.
        Intent intent = new Intent(this, JokeActvity.class);
        Bundle bundle = new Bundle();
        bundle.putString("joke", joke);
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


}
