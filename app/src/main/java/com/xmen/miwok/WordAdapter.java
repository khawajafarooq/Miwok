package com.xmen.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int mBackgroundColor;

    public WordAdapter(Context context, ArrayList<Word> words, int backgroundColor) {
        super(context, R.layout.list_item, words);
        mBackgroundColor = backgroundColor;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listView = convertView;

        // Checking if existing view is being reused
        if (listView == null) {

            // inflat one yourself
            listView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, null);
        }

        // set the color
        int color = ContextCompat.getColor(getContext(), mBackgroundColor);
        LinearLayout textContainer = listView.findViewById(R.id.list_item_color);
        textContainer.setBackgroundColor(color);

        // Get the data
        Word currentWord = getItem(position);

        // Set the data
        TextView defaultTextView = listView.findViewById(R.id.default_text_view);
        TextView miwokTextView = listView.findViewById(R.id.miwok_text_view);

        defaultTextView.setText(currentWord.getDefaultTranslation());
        miwokTextView.setText(currentWord.getMiwokTranslation());

        ImageView image = listView.findViewById(R.id.image);

        if (currentWord.hasImage()) {
            image.setImageResource(currentWord.getImageResourceId());

            // For view reusability
            image.setVisibility(View.VISIBLE);
        } else {
            image.setVisibility(View.GONE);
        }

        return listView;
    }
}
