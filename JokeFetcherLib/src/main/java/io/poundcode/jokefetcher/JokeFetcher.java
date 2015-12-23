package io.poundcode.jokefetcher;

import io.poundcode.jokefetcher.database.JokeDatabaseMock;
import io.poundcode.jokefetcher.model.Joke;

public class JokeFetcher {
    public Joke fetchNewJoke()
    {
        return JokeDatabaseMock.getInstance().fetchJoke();
    }

}
