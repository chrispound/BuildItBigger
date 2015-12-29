package io.poundcode.jokefetcher.database;

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

//    @Override
//    public Joke fetchJoke()
//    {
//        return new Joke("Why do programmers always mix up Halloween and Christmas?", "Because Oct 31 == Dec 25");
//    }

    public String fetchJoke() {
        return "Why do programmers always mix up Halloween and Christmas? \n Because Oct 31 == Dec 25";
    }
}
