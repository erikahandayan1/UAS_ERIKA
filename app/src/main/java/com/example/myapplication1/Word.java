package com.example.myapplication1;

public class Word {

    /** Asked question */
    private String m_question;

    /** Answer */
    private String m_answer;


    public Word(String question, String answer) {
        m_question = question;
        m_answer = answer;
    }

    public Word(String question, String answer, int intentResourceId) {
        m_question = question;
        m_answer = answer;
    }

    /**
     * Get the default translation of the word.
     */
    public String getM_question() {
        return m_question;
    }

    /**
     * Get the Miwok translation of the word.
     */
    public String getM_answer() {
        return m_answer;
    }

}
