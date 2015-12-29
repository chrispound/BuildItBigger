package io.poundcode.jokefetcher.model;

import java.io.Serializable;

public class Joke implements Serializable {

    private String question;
    private String answer;

    public Joke(String question, String answer)
    {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion()
    {
        return question;
    }

    public String getAnswer()
    {
        return answer;
    }
}
