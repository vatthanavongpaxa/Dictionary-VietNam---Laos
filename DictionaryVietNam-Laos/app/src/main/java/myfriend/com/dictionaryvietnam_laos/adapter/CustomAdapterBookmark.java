package myfriend.com.dictionaryvietnam_laos.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import myfriend.com.dictionaryvietnam_laos.R;
import myfriend.com.dictionaryvietnam_laos.model.Word;

/**
 * Created by vatth on 4/2/2017.
 */

public class CustomAdapterBookmark extends ArrayAdapter<Word> {
    ArrayList<Word> myArray;
    private Activity context;
    private int idLayout;

    public CustomAdapterBookmark(Activity context, int idLayout, ArrayList<Word> myArrays) {
        super(context, idLayout, myArrays);
        this.context = context;
        this.myArray = myArrays;
        this.idLayout = idLayout;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            convertView = inflater.inflate(idLayout, null);
        }
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(idLayout, null);
        if (myArray.size() > 0 && position >= 0) {
            final TextView textView_bookmark = (TextView) convertView.findViewById(R.id.textView_bookmark);
            final Word word = myArray.get(position);
            textView_bookmark.setText(word.getVNWORD());
            final ImageView imageView_star = (ImageView) convertView.findViewById(R.id.image_star);
            if (word.getBOOKMARK() == 1) {
                imageView_star.setImageResource(R.drawable.ic_star_black_36px);
            }
        }
        return convertView;
    }
}
