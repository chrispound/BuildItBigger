package io.poundcode.jokefetcher;

import io.poundcode.jokefetcher.database.JokeDatabaseMock;

public class JokeFetcher {
    public String fetchNewJoke()
    {
        return JokeDatabaseMock.getInstance().fetchJoke();
    }

}
