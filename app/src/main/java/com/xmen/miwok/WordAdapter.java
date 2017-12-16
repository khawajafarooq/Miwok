package com.xmen.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter(Context context, ArrayList<Word> words) {
        super(context, R.layout.list_item, words);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Get the data
        Word word = getItem(position);

        // Checking if existing view is being reused
        if (convertView == null) {

            // inflat one yourself
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, null);
        }

        // set the data

        TextView defaultTextView = convertView.findViewById(R.id.default_text_view);
        TextView miwokTextView = convertView.findViewById(R.id.miwok_text_view);

        defaultTextView.setText(word.getDefaultTranslation());
        miwokTextView.setText(word.getMiwokTranslation());

        return convertView;
    }
}
