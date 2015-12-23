package io.poundcode.jokefetcher.database;

import io.poundcode.jokefetcher.model.Joke;

public final class JokeDatabaseMock implements JokeDatabase {

    private static JokeDatabaseMock INSTANCE;

    private JokeDatabaseMock()
    {
    }

    public static JokeDatabaseMock getInstance()
    {
        if (INSTANCE == null) {
            INSTANCE = new JokeDatabaseMock();
        }
        return INSTANCE;
    }

    @Override
    public Joke fetchJoke()
    {
        return new Joke("Why do programmers always mix up Halloween and Christmas?", "Because Oct 31 == Dec 25");
    }
}
