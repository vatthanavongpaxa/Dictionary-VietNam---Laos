package myfriend.com.dictionaryvietnam_laos;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

import myfriend.com.dictionaryvietnam_laos.database.DatabaseHelper;
import myfriend.com.dictionaryvietnam_laos.model.Word;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDbHelper;
    ArrayAdapter adapter;
    ArrayList<Word> arr;
    private ListView listView_listWords;
    private EditText editText_searchWord;
    private ImageButton imageButton_clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.mipmap.ic_launcher_tudien);

        myDbHelper = new DatabaseHelper(MainActivity.this);
        copyCheckDatabase();
        //Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
        bindWidgets();
        setWidgetEventListener();

    }

    private void copyCheckDatabase() {
        try {
            myDbHelper.createDatabase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }
        try {
            myDbHelper.openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }
    }

    private void setWidgetEventListener() {
        imageButton_clear.setVisibility(View.GONE);
        imageButton_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText_searchWord.setText("");
            }
        });
        editText_searchWord.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                if (!editText_searchWord.getText().toString().equals("")) { //if edittext include text
                    imageButton_clear.setVisibility(View.VISIBLE);

                } else { //not include text
                    imageButton_clear.setVisibility(View.GONE);
                }
                searchWord();
            }
        });

        listView_listWords.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                Word word = arr.get(position);
                Bundle bundle = new Bundle();
                bundle.putSerializable("WORD", word);
                intent.putExtra("DATA", bundle);
                startActivity(intent);
            }
        });
    }

    private void searchWord() {
        String word = editText_searchWord.getText().toString();
        if (word.length() == 0) {
            adapter.clear();
            listView_listWords.setAdapter(adapter);

        } else {
            arr = myDbHelper.getListWords(word);
            adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arr);
            listView_listWords.setAdapter(adapter);
        }
    }

    private void bindWidgets() {
        imageButton_clear = (ImageButton) findViewById(R.id.imageButton_clear);
        listView_listWords = (ListView) findViewById(R.id.listView_listWords);
        editText_searchWord = (EditText) findViewById(R.id.editText_searchWord);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id) {
            case R.id.action_bookmark:
                startActivity(new Intent(MainActivity.this, BookmarkActivity.class));
                break;
            case R.id.action_about:
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
                break;
            case R.id.action_exit:
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
