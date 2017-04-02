package myfriend.com.dictionaryvietnam_laos;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

import myfriend.com.dictionaryvietnam_laos.adapter.CustomAdapterBookmark;
import myfriend.com.dictionaryvietnam_laos.database.DatabaseHelper;
import myfriend.com.dictionaryvietnam_laos.model.Word;

public class BookmarkActivity extends AppCompatActivity {
    private DatabaseHelper myDatabase;
    CustomAdapterBookmark adapter;
    ArrayList<Word> arr;
    private ListView listView_listBookmark;
    Word w;
    private int selected = -1;

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.mycontext, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_context_delete) {

            myDatabase.unBookMark(w.getId());
            finish();
            startActivity(getIntent());
        }
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);

        myDatabase = new DatabaseHelper(BookmarkActivity.this);
        checkDatabase();
        bindWidgets();
        arr = myDatabase.getListBookmark();
        adapter = new CustomAdapterBookmark(BookmarkActivity.this, R.layout.layout_listbookmark, arr);
        listView_listBookmark.setAdapter(adapter);
        setWidgetEventListner();
        registerForContextMenu(listView_listBookmark);


    }

    private void setWidgetEventListner() {
        listView_listBookmark.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                selected = position;
                w = arr.get(position);
                return false;
            }
        });
    }

    private void bindWidgets() {
        listView_listBookmark = (ListView) findViewById(R.id.listView_listBookmark);
    }

    private void checkDatabase() {
        try {
            myDatabase.openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }
    }

}

