package io.poundcode.jokefetcher.database;

import io.poundcode.jokefetcher.model.Joke;

public interface JokeDatabase {
    Joke fetchJoke();
}
