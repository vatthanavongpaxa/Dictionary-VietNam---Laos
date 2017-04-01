package myfriend.com.dictionaryvietnam_laos;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import myfriend.com.dictionaryvietnam_laos.database.DatabaseHelper;
import myfriend.com.dictionaryvietnam_laos.model.Word;

public class BookMarkActivity extends AppCompatActivity {

    private TextView textView_laWord;
    private TextView textView_vnWord;
    private ImageButton imageButton_bookMark;
    DatabaseHelper myDbHelper;
    private Word word;
    Bundle bundle;
    Intent getIndex;
    private FloatingActionButton fab;
    private Word w;
    private Button button_bookmark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_mark);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getIndex = getIntent();
        bundle = getIndex.getBundleExtra("DATA");
        word = (Word) bundle.getSerializable("WORD");
        myDbHelper = new DatabaseHelper(BookMarkActivity.this);
        try {
            myDbHelper.openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }
        w = myDbHelper.getWord(word.getId());
        bindWidgets();
        setWidgetEventListner();


    }

    private void setWidgetEventListner() {
        textView_laWord.setText(w.getLAWORD().toString());
        textView_vnWord.setText(w.getVNWORD().toString());
        switch (w.getBOOKMARK()) {
            case 1:
                fab.setImageResource(R.drawable.ic_bookmark_white_36px);

                break;
            case 0:
                fab.setImageResource(R.drawable.ic_bookmark_border_white_36px);

                break;

        }

        button_bookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = w.getId();
                switch (w.getBOOKMARK()) {
                    case 1:
                        myDbHelper.unBookMark(id);

                        fab.setImageResource(R.drawable.ic_bookmark_border_white_36px);
                        finish();
                        startActivity(getIntent());
                        break;
                    case 0:
                        myDbHelper.bookMark(id);
                        fab.setImageResource(R.drawable.ic_bookmark_white_36px);
                        finish();
                        startActivity(getIntent());
                        break;
                }
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = w.getId();
                switch (w.getBOOKMARK()) {
                    case 1:
                        fab.setImageResource(R.drawable.ic_bookmark_white_36px);
                        Snackbar.make(fab, "Bookmarked", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                        break;
                    case 0:
                        fab.setImageResource(R.drawable.ic_bookmark_border_white_36px);
                        Snackbar.make(fab, "Unbookmark", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                        break;

                }
//                if (w.getBOOKMARK() == 1) {
//                    int id = w.getId();
//                    myDbHelper.unBookMark(id);
//
//                    fab.setImageResource(R.drawable.ic_bookmark_border_white_36px);
//
//
//                    finish();
//                    startActivity(getIntent());
//                } else {
//                    int id = w.getId();
//                    myDbHelper.bookMark(id);
//                    fab.setImageResource(R.drawable.ic_bookmark_white_36px);
//
//                    finish();
//                    startActivity(getIntent());
//                }

            }
        });


    }

    private void bindWidgets() {
        textView_vnWord = (TextView) findViewById(R.id.textView_vnWord);
        textView_laWord = (TextView) findViewById(R.id.textView_laWord);
        button_bookmark = (Button) findViewById(R.id.button_bookmark);
        fab = (FloatingActionButton) findViewById(R.id.fab_bookmark);
    }

}
