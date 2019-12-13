package com.example.myapplication1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;


public class WordAdapter extends ArrayAdapter<Word>  {

    /** Resource ID for the background color for this list of words */
    private int mColorResourceId;

    /**
     * Create a new {@link WordAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param words is the list of {@link Word}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of words
     */
    public WordAdapter(Context context, ArrayList<Word> words, int colorResourceId) {
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listQuestionView = convertView;
        if (listQuestionView == null) {
            listQuestionView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_question, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view.
        TextView questionTextView = (TextView) listQuestionView.findViewById(R.id.question_text_view);
        // Get the Miwok translation from the currentWord object and set this text on
        // the Question TextView.
        questionTextView.setText(currentWord.getM_question());

        // Find the TextView in the list_item.xml layout with the ID default_text_view.
        TextView answerTextView = (TextView) listQuestionView.findViewById(R.id.answer_text_view);
        // Get the default translation from the currentWord object and set this text on
        // the default TextView.
        answerTextView.setText(currentWord.getM_answer());

        // Set the theme color for the list item
        View textContainer = listQuestionView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listQuestionView;
    }
}