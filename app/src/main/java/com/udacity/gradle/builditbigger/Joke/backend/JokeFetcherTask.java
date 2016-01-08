package com.udacity.gradle.builditbigger.joke.backend;

import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

import io.poundcode.builditbigger.backend.myApi.MyApi;

public class JokeFetcherTask extends AsyncTask<Void, Void, String> {

    private static final String TAG = "JokeFetcherTask";
    private static MyApi myApiService = null;
    private final JokeFetcherListener listener;
    private boolean isError = false;

    public JokeFetcherTask(JokeFetcherListener listener) {
        this.listener = listener;
    }

    @Override
    protected String doInBackground(Void... params) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }


        try {
            return myApiService.tellJoke().execute().getData();
        } catch (IOException e) {
            listener.errorLoadingJoke(e);
            isError = true;
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        //listener to get joke.
        if (listener != null && !isError) {
            listener.jokeLoaded(result);

        } else {

            Log.e(TAG, "onPostExecute: Listener was null");

        }
    }
}
